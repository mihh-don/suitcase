package com.suitcase.domainmodel.dto.baggage;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.color.ColorDTO;
import com.suitcase.domainmodel.dto.enums.BaggageItemCategoryEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemPriorityEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

public class BaggageItemDTO extends AbstractEntityDTO {

    @NotNull
    private String name;
    @NotNull
    private BaggageItemCategoryEnum baggageCategory;
    @NotNull
    private BaggageItemTypeEnum baggageType;
    @NotNull
    private BaggageItemPriorityEnum defaultBaggagePriority;
    private String description;
    private DimensionsDTO dimensions;
    private BigDecimal weight;
    private BigInteger pieces;
    private ColorDTO color;
    private Set<UserDTO> owners;

    public Set<UserDTO> getOwners() {
        return owners;
    }

    public void setOwners(Set<UserDTO> owners) {
        this.owners = owners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaggageItemCategoryEnum getBaggageCategory() {
        return baggageCategory;
    }

    public void setBaggageCategory(BaggageItemCategoryEnum baggageCategory) {
        this.baggageCategory = baggageCategory;
    }

    public BaggageItemTypeEnum getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(BaggageItemTypeEnum baggageType) {
        this.baggageType = baggageType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DimensionsDTO getDimensions() {
        return dimensions;
    }

    public void setDimensions(DimensionsDTO dimensions) {
        this.dimensions = dimensions;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigInteger getPieces() {
        return pieces;
    }

    public void setPieces(BigInteger pieces) {
        this.pieces = pieces;
    }

    public ColorDTO getColor() {
        return color;
    }

    public void setColor(ColorDTO color) {
        this.color = color;
    }

    public BaggageItemPriorityEnum getDefaultBaggagePriority() {
        return defaultBaggagePriority;
    }

    public void setDefaultBaggagePriority(BaggageItemPriorityEnum defaultBaggagePriority) {
        this.defaultBaggagePriority = defaultBaggagePriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaggageItemDTO)) return false;
        BaggageItemDTO that = (BaggageItemDTO) o;
        return getName().equals(that.getName()) &&
                getBaggageCategory() == that.getBaggageCategory() &&
                getBaggageType() == that.getBaggageType() &&
                getDefaultBaggagePriority() == that.getDefaultBaggagePriority() &&
                Objects.equals(getDimensions(), that.getDimensions()) &&
                Objects.equals(getWeight(), that.getWeight()) &&
                Objects.equals(getColor(), that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBaggageCategory(), getBaggageType(), getDefaultBaggagePriority(), getDimensions(), getWeight(), getColor());
    }
}
