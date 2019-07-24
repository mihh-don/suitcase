package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@RestController
public class TransportRestEndpointImpl implements ITransportRestEndpoint {

    @Override
    public List<String> allTransportCarrierNames() {
        return Collections.emptyList();
    }

    @Override
    public List<TransportCarrierBaggagePolicyDTO> baggagePolicies(@NotNull String transportCarrierName) {
        return Collections.emptyList();
    }
}
