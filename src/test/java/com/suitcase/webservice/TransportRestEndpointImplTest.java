package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.service.TransportService;
import com.suitcase.utils.CustomResponse;
import com.suitcase.utils.TransportCarriersArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static com.suitcase.utils.CustomResponseMatchers.*;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getAllTransportCarrierNames;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getBaggagePolicies;
import static com.suitcase.utils.UserArgumentsProvider.INVALID_INPUT_PROVIDER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TransportRestEndpointImplTest {

    private static final String BAD_REQUEST_MESSAGE = "Bad Request";

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
        when(transportService.getAllTransportCarrierNames()).thenReturn(CustomResponse.ok(transportCarrierNames));

        assertThat(restEndpoint.allTransportCarrierNames(), matchesResponseStringsSet(transportCarrierNames));

        verify(transportService).getAllTransportCarrierNames();
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void baggagePoliciesShouldReturnErrorResponseForInvalidUsername(String value) {
        when(transportService.getBaggagePolicies(value)).thenReturn(CustomResponse.badRequest(BAD_REQUEST_MESSAGE));

        assertThat(restEndpoint.baggagePolicies(value), matchesErrorResponse());

        verify(transportService).getBaggagePolicies(value);
    }

    @ParameterizedTest
    @ArgumentsSource(TransportCarriersArgumentsProvider.class)
    void baggagePoliciesShouldReturnCorrectDTOsForEachExistingInput(String transportCarrierName) {
        final Set<TransportCarrierBaggagePolicyDTO> baggagePolicies = getBaggagePolicies(transportCarrierName);
        when(transportService.getBaggagePolicies(transportCarrierName)).thenReturn(CustomResponse.ok(baggagePolicies));

        assertThat(restEndpoint.baggagePolicies(transportCarrierName), matchesResponseBaggagePoliciesSet(baggagePolicies));

        verify(transportService).getBaggagePolicies(transportCarrierName);
    }
}