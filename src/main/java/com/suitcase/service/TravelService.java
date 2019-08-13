package com.suitcase.service;

import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.exception.InvalidInputException;
import com.suitcase.utils.CustomResponse;
import com.suitcase.utils.ResponseErrorGenerator;
import com.suitcase.utils.TransportRestEndpointImplHelper;
import com.suitcase.utils.TravelRestEndpointImplHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

@Service
public class TravelService {

    private final List<UserDTO> users;
    private final Set<BaggageItemDTO> baggageItems;
    private final Set<TravelPlanDTO> travelPlans;

    @Autowired
    public TravelService() {
        // TODO test data to be removed after persistence layer is implemented
        // will use DAOs to retrieve Users and Converter to UserDTO
        users = TravelRestEndpointImplHelper.buildUsers();
        baggageItems = TravelRestEndpointImplHelper.getAllBaggageItems();
        travelPlans = TravelRestEndpointImplHelper.getAllTravelPlans();
    }

    public CustomResponse<Set<String>> getUserBaggageItemsNames(String username) {
        try {
            checkValue(username);
            return CustomResponse.ok(users.stream().filter(userDTO -> username.equals(userDTO.getUsername()))
                    .findAny()
                    .orElseThrow(() -> new InvalidInputException("User not found"))
                    .getBaggageItemsNames(), TransportRestEndpointImplHelper.OK);

        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateNotFoundError(ex.getMessage());
        }
    }

    public CustomResponse<BaggageItemDTO> getBaggageItem(final String baggageItemName) {
        try {
            checkValue(baggageItemName);
            return CustomResponse.ok(baggageItems.stream()
                    .filter(baggageItemDTO -> baggageItemDTO.getName().equals(baggageItemName))
                    .findAny()
                    .orElseThrow(() -> new InvalidInputException("Baggage item not found")));
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateNotFoundError(ex.getMessage());
        }
    }

    public CustomResponse<Set<String>> getUserTravelPlansNames(final String username) {
        try {
            checkValue(username);
            return CustomResponse.ok(users.stream()
                    .filter(userDTO -> userDTO.getUsername().equals(username))
                    .findAny()
                    .orElseThrow(() -> new InvalidInputException("User not found"))
                    .getTravelPlansNames());
        } catch (InvalidInputException ex) {
            return ResponseErrorGenerator.generateNotFoundError(ex.getMessage());
        }
    }

    public CustomResponse<TravelPlanDTO> getTravelPlan(final String travelPlanName) {
        try {
            checkValue(travelPlanName);
            return CustomResponse.ok(travelPlans.stream()
                    .filter(travelPlanDTO -> travelPlanDTO.getName().equals(travelPlanName))
                    .findAny()
                    .orElseThrow(() -> new InvalidInputException("Travel plan not found")));
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
