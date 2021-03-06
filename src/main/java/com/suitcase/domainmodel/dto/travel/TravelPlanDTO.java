package com.suitcase.domainmodel.dto.travel;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class TravelPlanDTO extends AbstractEntityDTO {

    @NotNull
    private String name;
    @NotNull
    private String user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
        if (getId() != null && getId().equals(that.getId())) {
            return true;
        }
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getTravelBaggageItems(), that.getTravelBaggageItems()) &&
                getUser().equals(that.getUser()) &&
                Objects.equals(getTravelDetails(), that.getTravelDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTravelBaggageItems(), getUser(), getTravelDetails());
    }

    public static class Builder {
        private TravelPlanDTO travelPlanDTO;

        public Builder() {
            travelPlanDTO = new TravelPlanDTO();
        }

        public Builder withName(String name) {
            travelPlanDTO.setName(name);
            return this;
        }

        public Builder withTravelBaggageItems(Set<TravelBaggageItemDTO> travelBaggageItems) {
            travelPlanDTO.setTravelBaggageItems(travelBaggageItems);
            return this;
        }

        public Builder withUser(String user) {
            travelPlanDTO.setUser(user);
            return this;
        }

        public Builder withTravelDetails(TravelDetailsDTO travelDetails) {
            travelPlanDTO.setTravelDetails(travelDetails);
            return this;
        }

        public TravelPlanDTO build() {
            return travelPlanDTO;
        }
    }
}
