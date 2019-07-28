package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.service.TransportService;
import com.suitcase.utils.BaggageItemsArgumentsProvider;
import com.suitcase.utils.TransportCarriersArgumentsProvider;
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

import java.util.Set;

import static com.suitcase.utils.ResponseEntityMatchers.*;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getAllTransportCarrierNames;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getBaggagePolicies;
import static com.suitcase.utils.TravelRestEndpointImplHelper.getBaggageItem;
import static com.suitcase.utils.TravelRestEndpointImplHelper.getBaggageItemsNames;
import static com.suitcase.utils.UserArgumentsProvider.INVALID_INPUT_PROVIDER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TransportRestEndpointImplTest {

    @Mock
    private TransportService transportService;

    @InjectMocks
    private TransportRestEndpointImpl restEndpoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void allTransportCarrierNamesShouldReturnAllStoredNames() {
        final Set<String> transportCarrierNames = getAllTransportCarrierNames();
        when(transportService.getAllTransportCarrierNames()).thenReturn(ResponseEntity.ok(transportCarrierNames));

        assertThat(restEndpoint.allTransportCarrierNames(), matchesResponseStringsSet(transportCarrierNames));

        verify(transportService).getAllTransportCarrierNames();
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void baggagePoliciesShouldReturnErrorResponseForInvalidUsername(String value) {
        when(transportService.getBaggagePolicies(value)).thenReturn(ResponseEntity.badRequest().build());

        assertThat(restEndpoint.baggagePolicies(value), matchesErrorResponse());

        verify(transportService).getBaggagePolicies(value);
    }

    @ParameterizedTest
    @ArgumentsSource(TransportCarriersArgumentsProvider.class)
    void baggagePoliciesShouldReturnCorrectDTOsForEachExistingInput(String transportCarrierName) {
        final Set<TransportCarrierBaggagePolicyDTO> baggagePolicies = getBaggagePolicies(transportCarrierName);
        when(transportService.getBaggagePolicies(transportCarrierName)).thenReturn(ResponseEntity.ok(baggagePolicies));

        assertThat(restEndpoint.baggagePolicies(transportCarrierName), matchesResponseBaggagePoliciesSet(baggagePolicies));

        verify(transportService).getBaggagePolicies(transportCarrierName);
    }
}