package com.suitcase.domainmodel.dto.transport;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.baggage.DimensionsDTO;
import com.suitcase.domainmodel.dto.enums.BaggagePolicyAllowanceTypeEnum;
import com.suitcase.domainmodel.dto.enums.BaggagePolicyTypeEnum;
import com.suitcase.domainmodel.dto.enums.TravelBaggageStorageTypeEnum;
import com.suitcase.domainmodel.dto.enums.TravelClassEnum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class TransportCarrierBaggagePolicyDTO extends AbstractEntityDTO {

    private String name;
    private BaggagePolicyTypeEnum baggagePolicyType;
    private TravelBaggageStorageTypeEnum storageType;
    private BaggagePolicyAllowanceTypeEnum baggagePolicyAllowanceType;
    // the maximum number of allowed items of this type
    private BigInteger maximumAllowedAmount;
    // the maximum allowed weight for this item
    private BigDecimal maximumAllowedWeight;
    // the maximum allowed dimensions (or combined dimensions)
    private DimensionsDTO maximumAllowedDimensions;
    // extra fee to pay for allowance, if applicable
    private BigDecimal extraFee;
    private String description;
    // the sequence order of this policy for its Transport Carrier
    private int sequence;
    // the Travel Class this policy applies to
    private TravelClassEnum travelClass;
    private TransportCarrierDTO transportCarrier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaggagePolicyTypeEnum getBaggagePolicyType() {
        return baggagePolicyType;
    }

    public void setBaggagePolicyType(BaggagePolicyTypeEnum baggagePolicyType) {
        this.baggagePolicyType = baggagePolicyType;
    }

    public TravelBaggageStorageTypeEnum getStorageType() {
        return storageType;
    }

    public void setStorageType(TravelBaggageStorageTypeEnum storageType) {
        this.storageType = storageType;
    }

    public BaggagePolicyAllowanceTypeEnum getBaggagePolicyAllowanceType() {
        return baggagePolicyAllowanceType;
    }

    public void setBaggagePolicyAllowanceType(BaggagePolicyAllowanceTypeEnum baggagePolicyAllowanceType) {
        this.baggagePolicyAllowanceType = baggagePolicyAllowanceType;
    }

    public BigInteger getMaximumAllowedAmount() {
        return maximumAllowedAmount;
    }

    public void setMaximumAllowedAmount(BigInteger maximumAllowedAmount) {
        this.maximumAllowedAmount = maximumAllowedAmount;
    }

    public BigDecimal getMaximumAllowedWeight() {
        return maximumAllowedWeight;
    }

    public void setMaximumAllowedWeight(BigDecimal maximumAllowedWeight) {
        this.maximumAllowedWeight = maximumAllowedWeight;
    }

    public DimensionsDTO getMaximumAllowedDimensions() {
        return maximumAllowedDimensions;
    }

    public void setMaximumAllowedDimensions(DimensionsDTO maximumAllowedDimensions) {
        this.maximumAllowedDimensions = maximumAllowedDimensions;
    }

    public BigDecimal getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(BigDecimal extraFee) {
        this.extraFee = extraFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public TravelClassEnum getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClassEnum travelClass) {
        this.travelClass = travelClass;
    }

    public TransportCarrierDTO getTransportCarrier() {
        return transportCarrier;
    }

    public void setTransportCarrier(TransportCarrierDTO transportCarrier) {
        this.transportCarrier = transportCarrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportCarrierBaggagePolicyDTO)) return false;
        TransportCarrierBaggagePolicyDTO that = (TransportCarrierBaggagePolicyDTO) o;
        return getSequence() == that.getSequence() &&
                getName().equals(that.getName()) &&
                getBaggagePolicyType() == that.getBaggagePolicyType() &&
                getStorageType() == that.getStorageType() &&
                getBaggagePolicyAllowanceType() == that.getBaggagePolicyAllowanceType() &&
                Objects.equals(getMaximumAllowedAmount(), that.getMaximumAllowedAmount()) &&
                Objects.equals(getMaximumAllowedWeight(), that.getMaximumAllowedWeight()) &&
                Objects.equals(getMaximumAllowedDimensions(), that.getMaximumAllowedDimensions()) &&
                Objects.equals(getExtraFee(), that.getExtraFee()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getTravelClass() == that.getTravelClass() &&
                Objects.equals(getTransportCarrier(), that.getTransportCarrier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBaggagePolicyType(), getStorageType(), getBaggagePolicyAllowanceType(), getMaximumAllowedAmount(), getMaximumAllowedWeight(), getMaximumAllowedDimensions(), getExtraFee(), getDescription(), getSequence(), getTravelClass(), getTransportCarrier());
    }
}
