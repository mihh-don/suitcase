package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@RestController
public class TransportRestEndpointImpl implements ITransportRestEndpoint {

    private TransportService transportService;

    @Autowired
    public TransportRestEndpointImpl(final TransportService transportService) {
        Objects.requireNonNull(transportService);
        this.transportService = transportService;
    }

    @Override
    public ResponseEntity<Set<String>> allTransportCarrierNames() {
        return transportService.getAllTransportCarrierNames();
    }

    @Override
    public ResponseEntity<Set<TransportCarrierBaggagePolicyDTO>> baggagePolicies(@NotNull String transportCarrierName) {
        return transportService.getBaggagePolicies(transportCarrierName);
    }
}
