package com.suitcase.domainmodel.dto.transport;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.enums.TransportMeansEnum;
import com.suitcase.domainmodel.dto.enums.TravelClassEnum;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class TransportCarrierDTO extends AbstractEntityDTO {

    @NotNull
    private String name;
    @NotNull
    private TransportMeansEnum meanOfTransport;
    private Set<TransportCarrierBaggagePolicyDTO> baggagePolicies;
    private Set<TravelClassEnum> allTravelClasses;

    public Set<TravelClassEnum> getAllTravelClasses() {
        return allTravelClasses;
    }

    public void setAllTravelClasses(Set<TravelClassEnum> allTravelClasses) {
        this.allTravelClasses = allTravelClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportMeansEnum getMeanOfTransport() {
        return meanOfTransport;
    }

    public void setMeanOfTransport(TransportMeansEnum meanOfTransport) {
        this.meanOfTransport = meanOfTransport;
    }

    public Set<TransportCarrierBaggagePolicyDTO> getBaggagePolicies() {
        return baggagePolicies;
    }

    public void setBaggagePolicies(Set<TransportCarrierBaggagePolicyDTO> baggagePolicies) {
        this.baggagePolicies = baggagePolicies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportCarrierDTO)) return false;
        TransportCarrierDTO that = (TransportCarrierDTO) o;
        return Objects.equals(getName(), that.getName()) &&
                getMeanOfTransport() == that.getMeanOfTransport() &&
                Objects.equals(getBaggagePolicies(), that.getBaggagePolicies()) &&
                Objects.equals(getAllTravelClasses(), that.getAllTravelClasses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMeanOfTransport(), getBaggagePolicies(), getAllTravelClasses());
    }
}
