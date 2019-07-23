package com.suitcase.domainmodel.dto;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class UserDTO extends AbstractEntityDTO {

    @NotBlank
    private String username;
    @NotBlank
    // password will be stored encrypted in the DB
    private String password;
    private Date creationDate;
    @Email
    private String email;

    private Set<BaggageItemDTO> baggageItems;
    private Set<TravelPlanDTO> travelPlans;

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
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getUsername().equals(userDTO.getUsername()) &&
                Objects.equals(getEmail(), userDTO.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail());
    }
}
