package com.suitcase.service;

import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.domainmodel.dto.transport.TransportCarrierDTO;
import com.suitcase.exception.InvalidInputException;
import com.suitcase.utils.CustomResponse;
import com.suitcase.utils.ResponseErrorGenerator;
import com.suitcase.utils.TransportRestEndpointImplHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransportService {

    private Set<TransportCarrierDTO> allTransportCarriers;

    @Autowired
    public TransportService() {
        allTransportCarriers = TransportRestEndpointImplHelper.getAllTransportCarriers();
    }

    public CustomResponse<Set<String>> getAllTransportCarrierNames() {
        return CustomResponse.ok(allTransportCarriers.stream()
                .map(TransportCarrierDTO::getName).collect(Collectors.toSet()));
    }

    public CustomResponse<Set<TransportCarrierBaggagePolicyDTO>> getBaggagePolicies(final String transportCarrierName) {
        try {
            checkValue(transportCarrierName);
            return CustomResponse.ok(Optional.ofNullable(allTransportCarriers.stream()
                    .filter(transportCarrierDTO -> transportCarrierName.equals(transportCarrierDTO.getName()))
                    .findAny()
                    .orElseThrow(() -> new InvalidInputException("Transport Carrier not found"))
                    .getBaggagePolicies())
                    .orElseGet(Collections::emptySet));

        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateNotFoundError(ex.getMessage());
        }
    }

    private void checkValue(final String value) throws InvalidInputException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidInputException("Please provide a valid value");
        }
    }
}
