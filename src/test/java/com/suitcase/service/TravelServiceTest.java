package com.suitcase.service;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.utils.BaggageItemsArgumentsProvider;
import com.suitcase.utils.TravelPlansArgumentsProvider;
import com.suitcase.utils.UserArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static com.suitcase.utils.CustomResponseMatchers.*;
import static com.suitcase.utils.TravelRestEndpointImplHelper.*;
import static com.suitcase.utils.UserArgumentsProvider.INVALID_INPUT_PROVIDER;
import static org.hamcrest.MatcherAssert.assertThat;

class TravelServiceTest {

    private static final String SOME_VALUE = "somevalue";
    private static final String EMPTY_STRING = "";

    @InjectMocks
    private TravelService travelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void getUserBaggageItemsNamesShouldReturnErrorResponseForInvalidUsername(String value) {
        assertThat(travelService.getUserBaggageItemsNames(null), matchesCustomErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void getUserBaggageItemsNamesShouldReturnBaggageNamesForUsername(String username) {
        assertThat(travelService.getUserBaggageItemsNames(username), matchesResponseStringsSet(getBaggageItemsNames(username)));
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void getBaggageItemShouldReturnErrorResponseForInvalidInput(String value) {
        assertThat(travelService.getBaggageItem(value), matchesErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(BaggageItemsArgumentsProvider.class)
    void getBaggageItemShouldReturnCorrectDTOForEachExistingInput(String baggageItemName) {
        final BaggageItemDTO baggageItem = getBaggageItem(baggageItemName);

        assertThat(travelService.getBaggageItem(baggageItemName), matchesResponseBaggageItem(baggageItem));
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void getUserTravelPlansNamesShouldReturnErrorResponseForInvalidInput(String value) {
        assertThat(travelService.getUserTravelPlansNames(value), matchesErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void allTravelPlansNamesShouldReturnCorrectTravelPlansNamesForInput(String username) {
        final Set<String> travelPlansNames = getTravelPlansNames(username);

        assertThat(travelService.getUserTravelPlansNames(username), matchesResponseStringsSet(travelPlansNames));
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void getTravelPlanShouldReturnErrorResponseForInvalidInput(String value) {
        assertThat(travelService.getTravelPlan(value), matchesErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(TravelPlansArgumentsProvider.class)
    void getTravelPlanShouldReturnCorrectDTOForEachExistingInput(String value) {
        final TravelPlanDTO travelPlan = getTravelPlan(value);

        assertThat(travelService.getTravelPlan(value), matchesResponseTravelPlan(travelPlan));
    }

}