package com.suitcase.service;

import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.exception.InvalidInputException;
import com.suitcase.utils.ResponseErrorGenerator;
import com.suitcase.utils.TravelRestEndpointImplHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TravelService {

    private final List<UserDTO> users;

    @Autowired
    public TravelService() {
        // TODO test data to be removed after persistence layer is implemented
        // will use DAOs to retrieve Users and Converter to UserDTO
        users = TravelRestEndpointImplHelper.buildUsers();
    }

    public ResponseEntity<Set<String>> getUserBaggageItemsNames(String username) {
        try {
            checkValue(username);
            return ResponseEntity.ok(users.stream().filter(userDTO -> username.equals(userDTO.getUsername()))
                    .findAny()
                    .map(UserDTO::getBaggageItemsNames)
                    .orElseGet(Collections::emptySet));
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateErrorResponse(ex.getMessage());
        }
    }

    public ResponseEntity<BaggageItemDTO> getBaggageItem(final String baggageItemName) {
        try {
            checkValue(baggageItemName);
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateErrorResponse(ex.getMessage());
        }
        return null;
    }

    public ResponseEntity<Set<String>> getUserTravelPlansNames(final String username) {
        try {
            checkValue(username);
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateErrorResponse(ex.getMessage());
        }
        return null;
    }

    public ResponseEntity<TravelPlanDTO> getTravelPlan(final String travelPlanName) {
        try {
            checkValue(travelPlanName);
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateErrorResponse(ex.getMessage());
        }
        return null;
    }

    private void checkValue(final String value) throws InvalidInputException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidInputException("Please provide a valid value");
        }
        if (users.stream().map(UserDTO::getUsername).noneMatch(value::equals)) {
            throw new InvalidInputException("Value not found");
        }
    }
}
