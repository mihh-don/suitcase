package com.suitcase.domainmodel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO extends AbstractEntityDTO {

    @NotBlank
    private String username;
    @NotBlank
    // password will be stored encrypted in the DB
    private String password;
    @Email
    private String email;
    private Set<BaggageItemDTO> baggageItems;
    private Set<TravelPlanDTO> travelPlans;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TravelPlanDTO> getTravelPlans() {
        return travelPlans;
    }

    public void setTravelPlans(Set<TravelPlanDTO> travelPlans) {
        this.travelPlans = travelPlans;
    }

    public Set<BaggageItemDTO> getBaggageItems() {
        return baggageItems;
    }

    public void setBaggageItems(Set<BaggageItemDTO> baggageItems) {
        this.baggageItems = baggageItems;
        Optional.ofNullable(baggageItems).orElseGet(Collections::emptySet).forEach(baggageItemDTO -> baggageItemDTO.addOwner(this));
    }

    @JsonIgnore
    public Set<String> getBaggageItemsNames() {
        return Optional.ofNullable(baggageItems).orElseGet(Collections::emptySet).stream().map(BaggageItemDTO::getName).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        if (getId().equals(userDTO.getId())) {
            return true;
        }
        return getUsername().equals(userDTO.getUsername()) &&
                Objects.equals(getEmail(), userDTO.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail());
    }

    public static class Builder {
        private UserDTO userDTO;

        public Builder() {
            userDTO = new UserDTO();
        }

        public Builder withUsername(String username) {
            userDTO.setUsername(username);
            return this;
        }

        public Builder withPassword(String password) {
            userDTO.setPassword(password);
            return this;
        }

        public Builder withEmail(String email) {
            userDTO.setEmail(email);
            return this;
        }

        public Builder withTravelPlans(Set<TravelPlanDTO> travelPlans) {
            userDTO.setTravelPlans(travelPlans);
            return this;
        }

        public Builder withBaggageItems(Set<BaggageItemDTO> baggageItems) {
            userDTO.setBaggageItems(baggageItems);
            return this;
        }

        public UserDTO build() {
            return userDTO;
        }
    }
}
