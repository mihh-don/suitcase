package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.utils.ResponseErrorGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequestScope
@RestController
public class TravelRestEndpointImpl implements ITravelRestEndpoint {

    private final List<UserDTO> users;

    @Autowired
    public TravelRestEndpointImpl() {
        // TODO test data to be removed after persistence layer is implemented
        users = TravelRestEndpointImplHelper.buildUsers();
    }

    @Override
    public ResponseEntity<Set<String>> allUserBaggageItemsNames(String username) {
        if (StringUtils.isEmpty(username)) {
            return ResponseErrorGenerator.generateErrorResponse("Please provide a valid username");
        }
        if (users.stream().map(UserDTO::getUsername).noneMatch(username::equals)) {
            return ResponseErrorGenerator.generateErrorResponse("Username not found");
        }
        return ResponseEntity.ok(users.stream().filter(userDTO -> username.equals(userDTO.getUsername()))
                .findAny()
                .map(UserDTO::getBaggageItemsNames)
                .orElseGet(Collections::emptySet));
    }

    @Override
    public BaggageItemDTO baggageItem(@NotNull String baggageItemName) {
        return null;
    }

    @Override
    public List<String> allTravelPlansNames(@NotNull String username) {
        return Collections.emptyList();
    }

    @Override
    public TravelPlanDTO travelPlan(@NotNull String travelPlanName) {
        return null;
    }
}
