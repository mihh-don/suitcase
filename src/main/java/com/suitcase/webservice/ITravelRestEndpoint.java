package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.utils.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RequestMapping("/travel")
public interface ITravelRestEndpoint {

    @GetMapping("/all-baggage-items-names/{username}")
    CustomResponse<Set<String>> allUserBaggageItemsNames(@PathVariable("username") @NotNull String username);

    @GetMapping("baggage-item/{baggageItemName}")
    CustomResponse<BaggageItemDTO> baggageItem(@PathVariable("baggageItemName") @NotNull String baggageItemName);

    @GetMapping("/all-travel-plans-names/{username}")
    CustomResponse<Set<String>> allUserTravelPlansNames(@PathVariable("username") @NotNull String username);

    @GetMapping("/travel-plan/{travelPlanName}")
    CustomResponse<TravelPlanDTO> travelPlan(@PathVariable("travelPlanName") @NotNull String travelPlanName);
}
