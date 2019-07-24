package com.suitcase.domainmodel.dto.travel;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.UserDTO;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class TravelPlanDTO extends AbstractEntityDTO {

    @NotNull
    private String name;
    @NotNull
    private UserDTO user;
    // all the items which are taken within this Travel Plan
    private Set<TravelBaggageItemDTO> travelBaggageItems;
    private TravelDetailsDTO travelDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TravelBaggageItemDTO> getTravelBaggageItems() {
        return travelBaggageItems;
    }

    public void setTravelBaggageItems(Set<TravelBaggageItemDTO> travelBaggageItems) {
        this.travelBaggageItems = travelBaggageItems;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TravelDetailsDTO getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetailsDTO travelDetails) {
        this.travelDetails = travelDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelPlanDTO)) return false;
        TravelPlanDTO that = (TravelPlanDTO) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getTravelBaggageItems(), that.getTravelBaggageItems()) &&
                getUser().equals(that.getUser()) &&
                Objects.equals(getTravelDetails(), that.getTravelDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTravelBaggageItems(), getUser(), getTravelDetails());
    }
}
