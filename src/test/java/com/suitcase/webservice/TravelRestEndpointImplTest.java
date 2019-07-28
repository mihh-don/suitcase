package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.service.TravelService;
import com.suitcase.utils.BaggageItemsArgumentsProvider;
import com.suitcase.utils.TravelPlansArgumentsProvider;
import com.suitcase.utils.UserArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static com.suitcase.utils.ResponseEntityMatchers.*;
import static com.suitcase.utils.TravelRestEndpointImplHelper.*;
import static com.suitcase.utils.UserArgumentsProvider.INVALID_INPUT_PROVIDER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TravelRestEndpointImplTest {

    @Mock
    private TravelService travelService;

    @InjectMocks
    private TravelRestEndpointImpl restEndpoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
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
    @MethodSource(INVALID_INPUT_PROVIDER)
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
    @MethodSource(INVALID_INPUT_PROVIDER)
    void allTravelPlansNamesShouldReturnErrorResponseForInvalidInput(String value) {
        when(travelService.getUserTravelPlansNames(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.allUserTravelPlansNames(value), matchesErrorResponse());

        verify(travelService).getUserTravelPlansNames(value);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void allTravelPlansNamesShouldReturnCorrectTravelPlansNamesForInput(String username) {
        final Set<String> travelPlansNames = getTravelPlansNames(username);
        when(travelService.getUserTravelPlansNames(username)).thenReturn(ResponseEntity.ok(travelPlansNames));

        assertThat(restEndpoint.allUserTravelPlansNames(username), matchesResponseStringsSet(travelPlansNames));

        verify(travelService).getUserTravelPlansNames(username);
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
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

}