package com.suitcase.utils;

import com.suitcase.domainmodel.dto.baggage.DimensionsDTO;
import com.suitcase.domainmodel.dto.enums.*;
import com.suitcase.domainmodel.dto.transport.BaggagePolicyAllowanceDTO;
import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.domainmodel.dto.transport.TransportCarrierDTO;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransportRestEndpointImplHelper {

    private static final String BICYCLE_01 = "Merida";
    private static final String TRAIN_01 = "DB";
    private static final String RUNNER_01 = "Eliud";
    private static final String AIRPLANE_01 = "Austrian";
    private static final String CAR_01 = "Uber";
    private static final String BUS_01 = "Flixbus";
    private static final String OTHER_01 = "Hoverboard";

    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final int MAX_DIMENSIONS_SUM = 158;
    private static final double MAX_ITEM_VOLUME = 0.1;

    private static TransportCarrierDTO bicycle;
    private static TransportCarrierDTO train;
    private static TransportCarrierDTO runner;
    private static TransportCarrierDTO airplane;
    private static TransportCarrierDTO car;
    private static TransportCarrierDTO bus;
    private static TransportCarrierDTO hoverboard;

    private static Set<TransportCarrierDTO> allTransportCarriers;
    private static Set<String> allTransportCarrierNames;

    private TransportRestEndpointImplHelper() {

    }

    static {
        bicycle = buildTransportCarrier(BICYCLE_01, TransportMeansEnum.BICYCLE);
        train = buildTransportCarrier(TRAIN_01, TransportMeansEnum.TRAIN);
        runner = buildTransportCarrier(RUNNER_01, TransportMeansEnum.BY_FOOT);
        airplane = buildTransportCarrier(AIRPLANE_01, TransportMeansEnum.AIRPLANE, buildAirplaneBaggagePoliciesSet());
        car = buildTransportCarrier(CAR_01, TransportMeansEnum.CAR);
        bus = buildTransportCarrier(BUS_01, TransportMeansEnum.BUS);
        hoverboard = buildTransportCarrier(OTHER_01, TransportMeansEnum.OTHER);

        allTransportCarriers = Stream.of(bicycle, train, runner, airplane, car, bus, hoverboard).collect(Collectors.toSet());
        allTransportCarrierNames = Stream.of(BICYCLE_01, TRAIN_01, RUNNER_01, AIRPLANE_01, CAR_01, BUS_01, OTHER_01).collect(Collectors.toSet());
    }

    public static Set<String> getAllTransportCarrierNames() {
        return allTransportCarrierNames;
    }

    public static Set<TransportCarrierBaggagePolicyDTO> getBaggagePolicies(final String transportCarrierName) {
        return allTransportCarriers.stream()
                .filter(transportCarrierDTO -> transportCarrierDTO.getName().equals(transportCarrierName))
                .findAny()
                .map(TransportCarrierDTO::getBaggagePolicies)
                .orElseGet(Collections::emptySet);
    }

    public static Set<TransportCarrierDTO> getAllTransportCarriers() {
        return allTransportCarriers;
    }

    static TransportCarrierDTO buildTransportCarrier(final String name, final TransportMeansEnum transportMean) {
        return new TransportCarrierDTO.Builder()
                .withAllTravelClasses(EnumSet.allOf(TravelClassEnum.class))
                .withName(name)
                .withMeanOfTransport(transportMean)
                .build();
    }

    static TransportCarrierDTO buildTransportCarrier(final String name,
                                                     final TransportMeansEnum transportMean,
                                                     final Set<TransportCarrierBaggagePolicyDTO> baggagePolicies) {
        return new TransportCarrierDTO.Builder()
                .withAllTravelClasses(EnumSet.allOf(TravelClassEnum.class))
                .withName(name)
                .withMeanOfTransport(transportMean)
                .withBaggagePolicies(baggagePolicies)
                .build();
    }

    static Set<TransportCarrierBaggagePolicyDTO> buildAirplaneBaggagePoliciesSet() {
        Set<TransportCarrierBaggagePolicyDTO> baggagePolicies = new HashSet<>();
        baggagePolicies.add(buildLimitedLiquidItemCabinBaggagePolicy(0));
        baggagePolicies.add(buildLimitedTotalLiquidsCabinBaggagePolicy(1));
        baggagePolicies.add(buildLimitedOneCheckInBaggage(2));
        baggagePolicies.add(buildLimitedTotalDimensionsCheckInBaggage(3));
        return baggagePolicies;
    }

    private static TransportCarrierBaggagePolicyDTO buildLimitedLiquidItemCabinBaggagePolicy(final int sequence) {
        return new TransportCarrierBaggagePolicyDTO.Builder()
                .withName("Cabin allowed liquid item per passenger")
                .withDescription("Passengers for all classes are allowed with liquids not exceeding 100mL per item in their cabin baggage")
                .withTravelClass(TravelClassEnum.ALL)
                .withBaggagePolicyType(BaggagePolicyTypeEnum.BAGGAGE_ITEM_CATEGORY_POLICY)
                .withBaggageItemCategory(BaggageItemCategoryEnum.LIQUIDS)
                .withBaggagePolicyAllowance(buildBaggageAllowanceMaxVolume(BigDecimal.valueOf(MAX_ITEM_VOLUME)))
                .withBaggagePolicyItemsAmountType(BaggagePolicyItemsAmountTypeEnum.SINGLE_ITEM)
                .withStorageType(TravelBaggageStorageTypeEnum.CABIN_BAGGAGE)
                .withSequence(sequence)
                .build();
    }

    private static TransportCarrierBaggagePolicyDTO buildLimitedTotalLiquidsCabinBaggagePolicy(final int sequence) {
        return new TransportCarrierBaggagePolicyDTO.Builder()
                .withName("Cabin allowed total liquids per passenger")
                .withDescription("Passengers for all classes are allowed with liquids not exceeding 1L in total in their cabin baggage")
                .withTravelClass(TravelClassEnum.ALL)
                .withBaggagePolicyType(BaggagePolicyTypeEnum.BAGGAGE_ITEM_CATEGORY_POLICY)
                .withBaggageItemCategory(BaggageItemCategoryEnum.LIQUIDS)
                .withBaggagePolicyAllowance(buildBaggageAllowanceMaxVolume(ONE))
                .withBaggagePolicyItemsAmountType(BaggagePolicyItemsAmountTypeEnum.ALL)
                .withStorageType(TravelBaggageStorageTypeEnum.CABIN_BAGGAGE)
                .withSequence(sequence)
                .build();
    }

    private static TransportCarrierBaggagePolicyDTO buildLimitedTotalDimensionsCheckInBaggage(final int sequence) {
        return new TransportCarrierBaggagePolicyDTO.Builder()
                .withName("Checked in baggage maximum sum of dimensions for Economy")
                .withDescription("Passengers of Economy class are allowed with a check-in baggage with sum of dimensions not exceeding 158 cm")
                .withTravelClass(TravelClassEnum.ECONOMY)
                .withBaggagePolicyType(BaggagePolicyTypeEnum.BAGGAGE_STORAGE_TYPE_POLICY)
                .withBaggagePolicyAllowance(buildBaggageAllowanceMaxDimensionsSum(BigDecimal.valueOf(MAX_DIMENSIONS_SUM)))
                .withBaggagePolicyItemsAmountType(BaggagePolicyItemsAmountTypeEnum.SINGLE_ITEM)
                .withStorageType(TravelBaggageStorageTypeEnum.CHECKIN_BAGGAGE)
                .withSequence(sequence)
                .build();
    }

    private static TransportCarrierBaggagePolicyDTO buildLimitedOneCheckInBaggage(final int sequence) {
        return new TransportCarrierBaggagePolicyDTO.Builder()
                .withName("Checked in baggage maximum amount for Economy")
                .withDescription("Passengers of Economy class are allowed with only one check-in baggage")
                .withTravelClass(TravelClassEnum.ECONOMY)
                .withBaggagePolicyType(BaggagePolicyTypeEnum.BAGGAGE_STORAGE_TYPE_POLICY)
                .withBaggagePolicyAllowance(buildBaggageAllowanceMaxAmount(ONE))
                .withBaggagePolicyItemsAmountType(BaggagePolicyItemsAmountTypeEnum.ALL)
                .withStorageType(TravelBaggageStorageTypeEnum.CHECKIN_BAGGAGE)
                .withSequence(sequence)
                .build();
    }

    private static BaggagePolicyAllowanceDTO buildBaggageAllowanceMaxVolume(final BigDecimal maxValue) {
        return new BaggagePolicyAllowanceDTO.Builder()
                .withBaggagePolicyAllowanceType(BaggagePolicyAllowanceTypeEnum.LIMITED_VOLUME)
                .withMaximumAllowedVolume(maxValue)
                .withDescription("Maximum allowed volume")
                .build();
    }

    private static BaggagePolicyAllowanceDTO buildBaggageAllowanceMaxAmount(final BigDecimal maxValue) {
        return new BaggagePolicyAllowanceDTO.Builder()
                .withBaggagePolicyAllowanceType(BaggagePolicyAllowanceTypeEnum.LIMITED_AMOUNT)
                .withMaximumAllowedVolume(maxValue)
                .withDescription("Maximum allowed amount of items")
                .build();
    }

    private static BaggagePolicyAllowanceDTO buildBaggageAllowanceMaxDimensionsSum(final BigDecimal maxValue) {
        return new BaggagePolicyAllowanceDTO.Builder()
                .withBaggagePolicyAllowanceType(BaggagePolicyAllowanceTypeEnum.LIMITED_DIMENSIONS)
                .withMaximumAllowedDimensions(new DimensionsDTO.Builder().withCombinedDimensionsLength(maxValue).build())
                .withDescription("Maximum sum of all dimensions")
                .build();
    }

}
