package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import com.suitcase.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@RequestScope
@RestController
public class TravelRestEndpointImpl implements ITravelRestEndpoint {

    private TravelService travelService;

    @Autowired
    public TravelRestEndpointImpl(final TravelService service) {
        Objects.requireNonNull(service);
        this.travelService = service;
    }

    @Override
    public ResponseEntity<Set<String>> allUserBaggageItemsNames(final String username) {
        return travelService.getUserBaggageItemsNames(username);
    }

    @Override
    public ResponseEntity<BaggageItemDTO> baggageItem(@NotNull final String baggageItemName) {
        return travelService.getBaggageItem(baggageItemName);
    }

    @Override
    public ResponseEntity<Set<String>> allUserTravelPlansNames(@NotNull final String username) {
        return travelService.getUserTravelPlansNames(username);
    }

    @Override
    public ResponseEntity<TravelPlanDTO> travelPlan(@NotNull final String travelPlanName) {
        return travelService.getTravelPlan(travelPlanName);
    }
}
