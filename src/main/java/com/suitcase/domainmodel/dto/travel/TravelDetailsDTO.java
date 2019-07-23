package com.suitcase.domainmodel.dto.travel;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.enums.SeasonEnum;
import com.suitcase.domainmodel.dto.enums.TravelPurposeEnum;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

public class TravelDetailsDTO extends AbstractEntityDTO {

    private String name;
    @NotNull
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private ZonedDateTime lastNotificationDate;
    private SeasonEnum season;
    private TravelPurposeEnum travelPurpose;
    private Set<TravelTransportCarrierDTO> travelTransportCarriers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public ZonedDateTime getLastNotificationDate() {
        return lastNotificationDate;
    }

    public void setLastNotificationDate(ZonedDateTime lastNotificationDate) {
        this.lastNotificationDate = lastNotificationDate;
    }

    public SeasonEnum getSeason() {
        return season;
    }

    public void setSeason(SeasonEnum season) {
        this.season = season;
    }

    public TravelPurposeEnum getTravelPurpose() {
        return travelPurpose;
    }

    public void setTravelPurpose(TravelPurposeEnum travelPurpose) {
        this.travelPurpose = travelPurpose;
    }

    public Set<TravelTransportCarrierDTO> getTravelTransportCarriers() {
        return travelTransportCarriers;
    }

    public void setTravelTransportCarriers(Set<TravelTransportCarrierDTO> travelTransportCarriers) {
        this.travelTransportCarriers = travelTransportCarriers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelDetailsDTO)) return false;
        TravelDetailsDTO that = (TravelDetailsDTO) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getLastNotificationDate(), that.getLastNotificationDate()) &&
                getSeason() == that.getSeason() &&
                getTravelPurpose() == that.getTravelPurpose() &&
                Objects.equals(getTravelTransportCarriers(), that.getTravelTransportCarriers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartDate(), getEndDate(), getLastNotificationDate(), getSeason(), getTravelPurpose(), getTravelTransportCarriers());
    }
}
