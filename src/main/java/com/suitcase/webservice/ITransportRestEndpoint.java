package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RequestMapping("/transport")
public interface ITransportRestEndpoint {

    @GetMapping("/all-transport-carrier-names")
    ResponseEntity<Set<String>> allTransportCarrierNames();

    @GetMapping("/baggage-policies/{transportCarrierName}")
    ResponseEntity<Set<TransportCarrierBaggagePolicyDTO>> baggagePolicies(@PathVariable("transportCarrierName") @NotNull String transportCarrierName);
}
