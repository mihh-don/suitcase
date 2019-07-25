package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@RequestMapping("/travel")
public interface ITravelRestEndpoint {

    @GetMapping("/all-baggage-items-names/{username}")
    ResponseEntity<Set<String>> allUserBaggageItemsNames(@PathVariable("username") @NotNull String username);

    @GetMapping("baggage-item/{baggageItemName}")
    ResponseEntity<BaggageItemDTO> baggageItem(@PathVariable("baggageItemName") @NotNull String baggageItemName);

    @GetMapping("/all-travel-plans-names/{username}")
    ResponseEntity<Set<String>> allUserTravelPlansNames(@PathVariable("username") @NotNull String username);

    @GetMapping("/travel-plan/{travelPlanName}")
    ResponseEntity<TravelPlanDTO> travelPlan(@PathVariable("travelPlanName") @NotNull String travelPlanName);
}
