package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.service.TravelService;
import com.suitcase.utils.BaggageItemsArgumentsProvider;
import com.suitcase.utils.TravelPlansArgumentsProvider;
import com.suitcase.utils.UserArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.suitcase.utils.ResponseEntityMatchers.*;
import static com.suitcase.utils.TravelRestEndpointImplHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TravelRestEndpointImplTest {

    private static final String SOME_USER = "someuser";
    private static final String SOME_BAGGAGE = "somebaggage";
    private static final String SOME_VALUE = "somevalue";
    private static final String EMPTY_STRING = "";

    @Mock
    private TravelService travelService;

    @InjectMocks
    private TravelRestEndpointImpl restEndpoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void allUserBaggageItemsNamesShouldReturnErrorResponseForInvalidUsername(String value) {
        when(travelService.getUserBaggageItemsNames(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.allUserBaggageItemsNames(value), matchesErrorResponse());

        verify(travelService).getUserBaggageItemsNames(value);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void allUserBaggageItemsNamesShouldReturnBaggageNamesForUsername(String username) {
        final Set<String> baggageItemsNames = getBaggageItemsNames(username);
        when(travelService.getUserBaggageItemsNames(username)).thenReturn(ResponseEntity.ok(baggageItemsNames));

        assertThat(restEndpoint.allUserBaggageItemsNames(username), matchesResponseStringsSet(baggageItemsNames));

        verify(travelService).getUserBaggageItemsNames(username);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void baggageItemShouldReturnErrorResponseForInvalidInput(String value) {
        when(travelService.getBaggageItem(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.baggageItem(value), matchesErrorResponse());

        verify(travelService).getBaggageItem(value);
    }

    @ParameterizedTest
    @ArgumentsSource(BaggageItemsArgumentsProvider.class)
    void baggageItemShouldReturnCorrectDTOForEachExistingInput(String baggageItemName) {
        final BaggageItemDTO baggageItem = getBaggageItem(baggageItemName);
        when(travelService.getBaggageItem(baggageItemName)).thenReturn(ResponseEntity.ok(baggageItem));

        assertThat(restEndpoint.baggageItem(baggageItemName), matchesResponseBaggageItem(baggageItem));

        verify(travelService).getBaggageItem(baggageItemName);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void allTravelPlansNamesShouldReturnErrorResponseForInvalidInput(String value) {
        when(travelService.getUserTravelPlansNames(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.allUserTravelPlansNames(value), matchesErrorResponse());

        verify(travelService).getUserTravelPlansNames(value);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void allTravelPlansNamesShouldReturnCorrectTravelPlansNamesForInput(String travelPlanName) {
        final Set<String> travelPlansNames = getTravelPlansNames(travelPlanName);
        when(travelService.getUserTravelPlansNames(travelPlanName)).thenReturn(ResponseEntity.ok(travelPlansNames));

        assertThat(restEndpoint.allUserTravelPlansNames(travelPlanName), matchesResponseStringsSet(travelPlansNames));

        verify(travelService).getUserTravelPlansNames(travelPlanName);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void travelPlanShouldReturnErrorResponseForInvalidInput(String value) {
        when(travelService.getTravelPlan(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.travelPlan(value), matchesErrorResponse());

        verify(travelService).getTravelPlan(value);
    }

    @ParameterizedTest
    @ArgumentsSource(TravelPlansArgumentsProvider.class)
    void travelPlanShouldReturnCorrectDTOForEachExistingInput(String value) {
        final TravelPlanDTO travelPlan = getTravelPlan(value);
        when(travelService.getTravelPlan(value)).thenReturn(ResponseEntity.ok(travelPlan));

        assertThat(restEndpoint.travelPlan(value), matchesResponseTravelPlan(travelPlan));

        verify(travelService).getTravelPlan(value);
    }

    private static Stream<String> invalidInputProvider() {
        return Stream.of(null, EMPTY_STRING, SOME_VALUE);
    }

}