package com.suitcase.domainmodel.dto.transport;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.enums.*;

import java.util.Objects;

public class TransportCarrierBaggagePolicyDTO extends AbstractEntityDTO {

    private String name;
    private String description;

    // the Travel Class this policy applies to
    private TravelClassEnum travelClass;
    private BaggagePolicyTypeEnum baggagePolicyType;
    // for Item Type Policy, the Item Type has to be specified
    private BaggageItemTypeEnum baggageItemType;
    // for Category Type Policy, the Item Category has to be specified
    private BaggageItemCategoryEnum baggageItemCategory;
    // for Storage Type Policy, the Storage Type has to be specified
    private TravelBaggageStorageTypeEnum storageType;
    private BaggagePolicyItemsAmountTypeEnum baggagePolicyItemsAmountType;
    // the sequence order of this policy for its Transport Carrier
    private BaggagePolicyAllowanceDTO baggagePolicyAllowance;

    private int sequence;
    private TransportCarrierDTO transportCarrier;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BaggagePolicyTypeEnum getBaggagePolicyType() {
        return baggagePolicyType;
    }

    public void setBaggagePolicyType(final BaggagePolicyTypeEnum baggagePolicyType) {
        this.baggagePolicyType = baggagePolicyType;
    }

    public BaggageItemTypeEnum getBaggageItemType() {
        return baggageItemType;
    }

    public void setBaggageItemType(final BaggageItemTypeEnum baggageItemType) {
        this.baggageItemType = baggageItemType;
    }

    public BaggageItemCategoryEnum getBaggageItemCategory() {
        return baggageItemCategory;
    }

    public void setBaggageItemCategory(final BaggageItemCategoryEnum baggageItemCategory) {
        this.baggageItemCategory = baggageItemCategory;
    }

    public TravelBaggageStorageTypeEnum getStorageType() {
        return storageType;
    }

    public void setStorageType(final TravelBaggageStorageTypeEnum storageType) {
        this.storageType = storageType;
    }

    public BaggagePolicyItemsAmountTypeEnum getBaggagePolicyItemsAmountType() {
        return baggagePolicyItemsAmountType;
    }

    public void setBaggagePolicyItemsAmountType(final BaggagePolicyItemsAmountTypeEnum baggagePolicyItemsAmountType) {
        this.baggagePolicyItemsAmountType = baggagePolicyItemsAmountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    public TravelClassEnum getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(final TravelClassEnum travelClass) {
        this.travelClass = travelClass;
    }

    public TransportCarrierDTO getTransportCarrier() {
        return transportCarrier;
    }

    public void setTransportCarrier(final TransportCarrierDTO transportCarrier) {
        this.transportCarrier = transportCarrier;
    }

    public BaggagePolicyAllowanceDTO getBaggagePolicyAllowance() {
        return baggagePolicyAllowance;
    }

    public void setBaggagePolicyAllowance(BaggagePolicyAllowanceDTO baggagePolicyAllowance) {
        this.baggagePolicyAllowance = baggagePolicyAllowance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportCarrierBaggagePolicyDTO)) return false;
        TransportCarrierBaggagePolicyDTO that = (TransportCarrierBaggagePolicyDTO) o;
        return getSequence() == that.getSequence() &&
                getName().equals(that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getTravelClass() == that.getTravelClass() &&
                getBaggagePolicyType() == that.getBaggagePolicyType() &&
                getBaggageItemType() == that.getBaggageItemType() &&
                getBaggageItemCategory() == that.getBaggageItemCategory() &&
                getStorageType() == that.getStorageType() &&
                getBaggagePolicyItemsAmountType() == that.getBaggagePolicyItemsAmountType() &&
                Objects.equals(getBaggagePolicyAllowance(), that.getBaggagePolicyAllowance()) &&
                Objects.equals(getTransportCarrier(), that.getTransportCarrier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getTravelClass(), getBaggagePolicyType(), getBaggageItemType(), getBaggageItemCategory(), getStorageType(), getBaggagePolicyItemsAmountType(), getBaggagePolicyAllowance(), getSequence(), getTransportCarrier());
    }

    public static class Builder {
        private TransportCarrierBaggagePolicyDTO baggagePolicyDTO;

        public Builder() {
            baggagePolicyDTO = new TransportCarrierBaggagePolicyDTO();
        }

        public Builder withName(final String name) {
            baggagePolicyDTO.setName(name);
            return this;
        }

        public Builder withBaggagePolicyType(final BaggagePolicyTypeEnum baggagePolicyType) {
            baggagePolicyDTO.setBaggagePolicyType(baggagePolicyType);
            return this;
        }

        public Builder withBaggageItemType(final BaggageItemTypeEnum baggageItemType) {
            baggagePolicyDTO.setBaggageItemType(baggageItemType);
            return this;
        }

        public Builder withBaggageItemCategory(final BaggageItemCategoryEnum baggageItemCategory) {
            baggagePolicyDTO.setBaggageItemCategory(baggageItemCategory);
            return this;
        }

        public Builder withStorageType(final TravelBaggageStorageTypeEnum storageType) {
            baggagePolicyDTO.setStorageType(storageType);
            return this;
        }

        public Builder withBaggagePolicyItemsAmountType(final BaggagePolicyItemsAmountTypeEnum baggagePolicyItemsAmountType) {
            baggagePolicyDTO.setBaggagePolicyItemsAmountType(baggagePolicyItemsAmountType);
            return this;
        }

        public Builder withDescription(final String description) {
            baggagePolicyDTO.setDescription(description);
            return this;
        }

        public Builder withSequence(final int sequence) {
            baggagePolicyDTO.setSequence(sequence);
            return this;
        }

        public Builder withTravelClass(final TravelClassEnum travelClass) {
            baggagePolicyDTO.setTravelClass(travelClass);
            return this;
        }

        public Builder withTransportCarrier(final TransportCarrierDTO transportCarrier) {
            baggagePolicyDTO.setTransportCarrier(transportCarrier);
            return this;
        }

        public Builder withBaggagePolicyAllowance(BaggagePolicyAllowanceDTO baggagePolicyAllowance) {
            baggagePolicyDTO.setBaggagePolicyAllowance(baggagePolicyAllowance);
            return this;
        }

        public TransportCarrierBaggagePolicyDTO build() {
            return baggagePolicyDTO;
        }
    }
}
