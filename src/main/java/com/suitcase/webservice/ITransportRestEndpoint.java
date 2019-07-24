package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/transport")
public interface ITransportRestEndpoint {

    @GetMapping("/all-transport-carrier-names")
    List<String> allTransportCarrierNames();

    @GetMapping("/baggage-policies/{transportCarrierName}")
    List<TransportCarrierBaggagePolicyDTO> baggagePolicies(@PathVariable("transportCarrierName") @NotNull String transportCarrierName);
}
