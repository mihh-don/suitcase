package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.service.TransportService;
import com.suitcase.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@RequestScope
@RestController
public class TransportRestEndpointImpl implements ITransportRestEndpoint {

    private TransportService transportService;

    @Autowired
    public TransportRestEndpointImpl(final TransportService transportService) {
        Objects.requireNonNull(transportService);
        this.transportService = transportService;
    }

    @Override
    public CustomResponse<Set<String>> allTransportCarrierNames() {
        return transportService.getAllTransportCarrierNames();
    }

    @Override
    public CustomResponse<Set<TransportCarrierBaggagePolicyDTO>> baggagePolicies(@NotNull String transportCarrierName) {
        return transportService.getBaggagePolicies(transportCarrierName);
    }
}
