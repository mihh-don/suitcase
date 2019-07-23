package com.suitcase.domainmodel.dto.travel;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.enums.BaggageItemPriorityEnum;
import com.suitcase.domainmodel.dto.enums.TravelBaggageStorageTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

public class TravelBaggageItemDTO extends AbstractEntityDTO {

    @NotNull
    // the real Baggage Item used during this Travel Plan
    private BaggageItemDTO baggageItem;
    // the actual priority
    private BaggageItemPriorityEnum baggagePriority;
    private TravelBaggageStorageTypeEnum baggageStorageType;
    // count of how many pieces are taken for this trip
    // validate that is <= pieces of real baggage item
    private BigInteger pieces;

    public BaggageItemDTO getBaggageItem() {
        return baggageItem;
    }

    public void setBaggageItem(BaggageItemDTO baggageItem) {
        this.baggageItem = baggageItem;
    }

    public BaggageItemPriorityEnum getBaggagePriority() {
        return baggagePriority;
    }

    public void setBaggagePriority(BaggageItemPriorityEnum baggagePriority) {
        this.baggagePriority = baggagePriority;
    }

    public TravelBaggageStorageTypeEnum getBaggageStorageType() {
        return baggageStorageType;
    }

    public void setBaggageStorageType(TravelBaggageStorageTypeEnum baggageStorageType) {
        this.baggageStorageType = baggageStorageType;
    }

    public BigInteger getPieces() {
        return pieces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelBaggageItemDTO)) return false;
        TravelBaggageItemDTO that = (TravelBaggageItemDTO) o;
        return getBaggageItem().equals(that.getBaggageItem()) &&
                getBaggagePriority() == that.getBaggagePriority() &&
                getBaggageStorageType() == that.getBaggageStorageType() &&
                Objects.equals(getPieces(), that.getPieces());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBaggageItem(), getBaggagePriority(), getBaggageStorageType(), getPieces());
    }

    public void setPieces(BigInteger pieces) {
        this.pieces = pieces;
    }
}
