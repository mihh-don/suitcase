package com.suitcase.utils;

import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.baggage.DimensionsDTO;
import com.suitcase.domainmodel.dto.color.BasicColorEnum;
import com.suitcase.domainmodel.dto.color.ColorCombinationEnum;
import com.suitcase.domainmodel.dto.color.ColorDTO;
import com.suitcase.domainmodel.dto.enums.*;
import com.suitcase.domainmodel.dto.transport.TransportCarrierDTO;
import com.suitcase.domainmodel.dto.travel.TravelBaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelDetailsDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.domainmodel.dto.travel.TravelTransportCarrierDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.*;

import static com.suitcase.utils.TransportRestEndpointImplHelper.buildTransportCarrier;

// TODO add this class only to the test classes, after the persistence layer is implemented
public final class TravelRestEndpointImplHelper {

    private static final double WEIGHT_VALUE = 3.03;
    private static final String USER01 = "mihh";
    private static final String USER02 = "ley";
    private static final String SMTH01 = "something_1";
    private static final String SMTH02 = "something_2";
    private static final String BAGGAGE_01 = "Toffifee";
    private static final String BAGGAGE_02 = "Pirates Game";
    private static final String BAGGAGE_03 = "Cotton wool";
    private static final String BAGGAGE_04 = "Socks";
    private static final String BAGGAGE_05 = "Relax ball";
    private static final String BAGGAGE_06 = "Headlamp";
    private static final String BAGGAGE_07 = "Mamaliga";
    private static final String TRAVEL_01 = "Ibiza";
    private static final String TRAVEL_02 = "Mont Blanc";
    private static final String TRAVEL_03 = "Portofino";

    private static Map<String, Set<String>> userBaggageItemsMap = new HashMap<>();
    private static Map<String, Set<String>> userTravelPlansMap = new HashMap<>();
    private static Set<BaggageItemDTO> allBaggageItems = new HashSet<>();
    private static Set<BaggageItemDTO> baggageItemsSetUserOne;
    private static Set<BaggageItemDTO> baggageItemsSetUserTwo;
    private static Set<TravelPlanDTO> allTravelPlans = new HashSet<>();
    private static Set<TravelPlanDTO> userOneTravelPlansSet;
    private static Set<TravelPlanDTO> userTwoTravelPlansSet;
    private static TransportCarrierDTO bicycle;
    private static TransportCarrierDTO train;
    private static TransportCarrierDTO runner;

    private TravelRestEndpointImplHelper() {

    }

    static {
        userBaggageItemsMap.put(USER01, new HashSet<>(Arrays.asList(BAGGAGE_01, BAGGAGE_02, BAGGAGE_03)));
        userBaggageItemsMap.put(USER02, new HashSet<>(Arrays.asList(BAGGAGE_04, BAGGAGE_05, BAGGAGE_06, BAGGAGE_07)));

        userTravelPlansMap.put(USER01, new HashSet<>(Collections.singletonList(TRAVEL_01)));
        userTravelPlansMap.put(USER02, new HashSet<>(Arrays.asList(TRAVEL_02, TRAVEL_03)));

        baggageItemsSetUserOne = buildBaggageItemsSetOne();
        baggageItemsSetUserTwo = buildBaggageItemsSetTwo();
        allBaggageItems.addAll(baggageItemsSetUserOne);
        allBaggageItems.addAll(baggageItemsSetUserTwo);

        bicycle = buildTransportCarrier("Cannondale", TransportMeansEnum.BICYCLE);
        train = buildTransportCarrier("OEBB", TransportMeansEnum.TRAIN);
        runner = buildTransportCarrier("Mihh", TransportMeansEnum.BY_FOOT);

        userOneTravelPlansSet = buildUserOneTravelPlansSet();
        userTwoTravelPlansSet = buildUserTwoTravelPlansSet();
        allTravelPlans.addAll(userOneTravelPlansSet);
        allTravelPlans.addAll(userTwoTravelPlansSet);
    }

    public static Set<String> getBaggageItemsNames(final String username) {
        return userBaggageItemsMap.get(username);
    }

    public static Set<String> getTravelPlansNames(final String username) {
        return userTravelPlansMap.get(username);
    }

    public static BaggageItemDTO getBaggageItem(final String baggageItemName) {
        return allBaggageItems.stream()
                .filter(baggageItemDTO -> baggageItemDTO.getName().equals(baggageItemName))
                .findAny()
                .orElse(null);
    }

    public static TravelPlanDTO getTravelPlan(final String travelPlanName) {
        return allTravelPlans.stream()
                .filter(travelPlanDTO -> travelPlanDTO.getName().equals(travelPlanName))
                .findAny()
                .orElse(null);
    }

    public static Set<BaggageItemDTO> getAllBaggageItems() {
        return allBaggageItems;
    }

    public static Set<TravelPlanDTO> getAllTravelPlans() {
        return allTravelPlans;
    }

    public static List<UserDTO> buildUsers() {

        UserDTO user1 = new UserDTO.Builder()
                .withUsername(USER01)
                .withPassword(SMTH01)
                .withEmail(USER01 + "@mail.com")
                .withBaggageItems(baggageItemsSetUserOne)
                .withTravelPlans(userOneTravelPlansSet)
                .build();
        UserDTO user2 = new UserDTO.Builder()
                .withUsername(USER02)
                .withPassword(SMTH02)
                .withEmail(USER02 + "@mail.com")
                .withBaggageItems(baggageItemsSetUserTwo)
                .withTravelPlans(userTwoTravelPlansSet)
                .build();
        return Arrays.asList(user1, user2);
    }

    private static Set<BaggageItemDTO> buildBaggageItemsSetOne() {
        BaggageItemDTO baggage1 = buildBaggageItem(BAGGAGE_01, BaggageItemCategoryEnum.FOOD);
        BaggageItemDTO baggage2 = buildBaggageItem(BAGGAGE_02, BaggageItemCategoryEnum.TOYS_GAMES);
        BaggageItemDTO baggage3 = buildBaggageItem(BAGGAGE_03, BaggageItemCategoryEnum.TOILETRIES);
        return new HashSet<>(Arrays.asList(baggage1, baggage2, baggage3));
    }

    private static Set<BaggageItemDTO> buildBaggageItemsSetTwo() {
        BaggageItemDTO baggage4 = buildBaggageItem(BAGGAGE_04, BaggageItemCategoryEnum.CLOTHES);
        BaggageItemDTO baggage5 = buildBaggageItem(BAGGAGE_05, BaggageItemCategoryEnum.TOYS_GAMES);
        BaggageItemDTO baggage6 = buildBaggageItem(BAGGAGE_06, BaggageItemCategoryEnum.ELECTRONIC_DEVICES);
        BaggageItemDTO baggage7 = buildBaggageItem(BAGGAGE_07, BaggageItemCategoryEnum.FOOD);
        return new HashSet<>(Arrays.asList(baggage4, baggage5, baggage6, baggage7));
    }

    private static BaggageItemDTO buildBaggageItem(final String name, final BaggageItemCategoryEnum category) {
        return new BaggageItemDTO.Builder()
                .withName(name)
                .withBaggageCategory(category)
                .withBaggageType(BaggageItemTypeEnum.SOLID)
                .withDefaultBaggagePriority(BaggageItemPriorityEnum.NEED)
                .withColor(new ColorDTO.Builder().withPrimaryColor(BasicColorEnum.BLACK).withColorCombination(ColorCombinationEnum.MONO).build())
                .withDescription(name + " info")
                .withDimensions(new DimensionsDTO.Builder().withCombinedDimensionsLength(BigDecimal.ONE).build())
                .withPieces(BigInteger.ONE)
                .withWeight(BigDecimal.valueOf(WEIGHT_VALUE))
                .build();
    }

    private static Set<TravelPlanDTO> buildUserOneTravelPlansSet() {
        TravelPlanDTO travelPlan = new TravelPlanDTO.Builder()
                .withName(TRAVEL_01)
                .withTravelBaggageItems(buildUserOneTravelBaggageItemsSetOne())
                .withTravelDetails(buildUserOneTravelDetailsOne())
                .build();

        Set<TravelPlanDTO> plans = new HashSet<>();
        plans.add(travelPlan);
        return plans;
    }

    private static Set<TravelPlanDTO> buildUserTwoTravelPlansSet() {
        TravelPlanDTO travelPlan2 = new TravelPlanDTO.Builder()
                .withName(TRAVEL_02)
                .withTravelBaggageItems(buildUserTwoTravelBaggageItemsSetOne())
                .withTravelDetails(buildUserTwoTravelDetailsOne())
                .build();
        TravelPlanDTO travelPlan3 = new TravelPlanDTO.Builder()
                .withName(TRAVEL_03)
                .withTravelBaggageItems(buildUserTwoTravelBaggageItemsSetTwo())
                .withTravelDetails(buildUserTwoTravelDetailsTwo())
                .build();

        Set<TravelPlanDTO> plans = new HashSet<>();
        plans.add(travelPlan2);
        plans.add(travelPlan3);
        return plans;
    }

    private static Set<TravelBaggageItemDTO> buildUserOneTravelBaggageItemsSetOne() {
        final Iterator<BaggageItemDTO> iterator = baggageItemsSetUserOne.iterator();
        Set<TravelBaggageItemDTO> items = new HashSet<>();
        TravelBaggageItemDTO baggage1 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.CHECKIN_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.NOT_REQUIRED)
                .build();
        TravelBaggageItemDTO baggage2 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.CABIN_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.WANT)
                .build();
        items.add(baggage1);
        items.add(baggage2);
        return items;
    }

    private static Set<TravelBaggageItemDTO> buildUserTwoTravelBaggageItemsSetOne() {
        final Iterator<BaggageItemDTO> iterator = baggageItemsSetUserTwo.iterator();
        Set<TravelBaggageItemDTO> items = new HashSet<>();
        TravelBaggageItemDTO baggage1 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.HAND_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.NOT_REQUIRED)
                .build();
        TravelBaggageItemDTO baggage2 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.HAND_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.WANT)
                .build();
        items.add(baggage1);
        items.add(baggage2);
        return items;
    }

    private static Set<TravelBaggageItemDTO> buildUserTwoTravelBaggageItemsSetTwo() {
        final Iterator<BaggageItemDTO> iterator = baggageItemsSetUserTwo.iterator();
        Set<TravelBaggageItemDTO> items = new HashSet<>();
        iterator.next();
        TravelBaggageItemDTO baggage1 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.HAND_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.NOT_REQUIRED)
                .build();
        TravelBaggageItemDTO baggage2 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.HAND_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.WANT)
                .build();
        TravelBaggageItemDTO baggage3 = new TravelBaggageItemDTO.Builder()
                .withBaggageItem(iterator.next())
                .withBaggageStorageType(TravelBaggageStorageTypeEnum.CABIN_BAGGAGE)
                .withPieces(BigInteger.ONE)
                .withBaggagePriority(BaggageItemPriorityEnum.NEED)
                .build();
        items.add(baggage1);
        items.add(baggage2);
        items.add(baggage3);
        return items;
    }

    private static TravelDetailsDTO buildUserOneTravelDetailsOne() {
        return new TravelDetailsDTO.Builder()
                .withStartDate(ZonedDateTime.now())
                .withEndDate(ZonedDateTime.now().plusDays(10))
                .withSeason(SeasonEnum.SUMMER)
                .withTravelPurpose(TravelPurposeEnum.LEISURE)
                .withTravelTransportCarriers(buildUserOneTravelTransportCarrierSetOne())
                .build();
    }

    private static TravelDetailsDTO buildUserTwoTravelDetailsOne() {
        return new TravelDetailsDTO.Builder()
                .withStartDate(ZonedDateTime.now().minusMonths(4))
                .withEndDate(ZonedDateTime.now().minusMonths(3))
                .withSeason(SeasonEnum.SPRING)
                .withTravelPurpose(TravelPurposeEnum.BUSINESS)
                .withTravelTransportCarriers(buildUserTwoTravelTransportCarrierSetOne())
                .build();
    }

    private static TravelDetailsDTO buildUserTwoTravelDetailsTwo() {
        return new TravelDetailsDTO.Builder()
                .withStartDate(ZonedDateTime.now().plusMonths(1))
                .withEndDate(ZonedDateTime.now().plusMonths(3))
                .withSeason(SeasonEnum.AUTUMN)
                .withTravelPurpose(TravelPurposeEnum.STUDY)
                .withTravelTransportCarriers(buildUserTwoTravelTransportCarrierSetTwo())
                .build();
    }

    private static Set<TravelTransportCarrierDTO> buildUserOneTravelTransportCarrierSetOne() {
        Set<TravelTransportCarrierDTO> carriers = new HashSet<>();
        carriers.add(buildTravelTransportCarrier(0, bicycle));
        carriers.add(buildTravelTransportCarrier(1, train));
        return carriers;
    }

    private static Set<TravelTransportCarrierDTO> buildUserTwoTravelTransportCarrierSetOne() {
        Set<TravelTransportCarrierDTO> carriers = new HashSet<>();
        carriers.add(buildTravelTransportCarrier(0, runner));
        carriers.add(buildTravelTransportCarrier(1, train));
        return carriers;
    }

    private static Set<TravelTransportCarrierDTO> buildUserTwoTravelTransportCarrierSetTwo() {
        Set<TravelTransportCarrierDTO> carriers = new HashSet<>();
        carriers.add(buildTravelTransportCarrier(0, runner));
        carriers.add(buildTravelTransportCarrier(1, bicycle));
        carriers.add(buildTravelTransportCarrier(2, train));
        return carriers;
    }

    private static TravelTransportCarrierDTO buildTravelTransportCarrier(final int sequence, final TransportCarrierDTO transportCarrier) {
        return new TravelTransportCarrierDTO.Builder()
                .withTravelClass(TravelClassEnum.ECONOMY)
                .withSequence(sequence)
                .withTransportCarrier(transportCarrier)
                .build();
    }
}
