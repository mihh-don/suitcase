package com.suitcase.service;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.utils.TransportCarriersArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static com.suitcase.utils.CustomResponseMatchers.*;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getAllTransportCarrierNames;
import static com.suitcase.utils.TransportRestEndpointImplHelper.getBaggagePolicies;
import static com.suitcase.utils.UserArgumentsProvider.INVALID_INPUT_PROVIDER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

class TransportServiceTest {

    @InjectMocks
    private TransportService transportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTransportCarrierNamesShouldReturnAllStoredNames() {
        final Set<String> transportCarrierNames = getAllTransportCarrierNames();

        assertThat(transportService.getAllTransportCarrierNames(), matchesResponseStringsSet(transportCarrierNames));
    }

    @ParameterizedTest
    @MethodSource(INVALID_INPUT_PROVIDER)
    void getBaggagePoliciesShouldReturnErrorResponseForInvalidUsername(String value) {
        assertThat(transportService.getBaggagePolicies(value), matchesErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(TransportCarriersArgumentsProvider.class)
    void getBaggagePoliciesShouldReturnCorrectDTOsForEachExistingInput(String transportCarrierName) {
        final Set<TransportCarrierBaggagePolicyDTO> baggagePolicies = getBaggagePolicies(transportCarrierName);

        assertThat(transportService.getBaggagePolicies(transportCarrierName), matchesResponseBaggagePoliciesSet(baggagePolicies));
    }
}