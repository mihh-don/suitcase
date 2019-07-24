package com.suitcase.domainmodel.dto.baggage;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.color.ColorDTO;
import com.suitcase.domainmodel.dto.enums.BaggageItemCategoryEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemPriorityEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemTypeEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

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
    @NotNull
    @Size(min = 1)
    private Set<UserDTO> owners;

    public BaggageItemDTO() {
        name = "";
        baggageCategory = BaggageItemCategoryEnum.OTHERS;
        baggageType = BaggageItemTypeEnum.OTHER;
        defaultBaggagePriority = BaggageItemPriorityEnum.NOT_APPLICABLE;
        owners = new HashSet<>();
    }

    public Set<UserDTO> getOwners() {
        return owners;
    }

    public void addOwner(UserDTO owner) {
        this.owners.add(owner);
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

    public static class Builder {
        private BaggageItemDTO baggageItemDTO;

        public Builder() {
            baggageItemDTO = new BaggageItemDTO();
        }

        public Builder withOwners(Set<UserDTO> owners) {
            Optional.ofNullable(owners).orElseGet(Collections::emptySet).forEach(baggageItemDTO::addOwner);
            return this;
        }

        public Builder withName(String name) {
            baggageItemDTO.setName(name);
            return this;
        }

        public Builder withBaggageCategory(BaggageItemCategoryEnum baggageCategory) {
            baggageItemDTO.setBaggageCategory(baggageCategory);
            return this;
        }

        public Builder withBaggageType(BaggageItemTypeEnum baggageType) {
            baggageItemDTO.setBaggageType(baggageType);
            return this;
        }

        public Builder withDescription(String description) {
            baggageItemDTO.setDescription(description);
            return this;
        }

        public Builder withDimensions(DimensionsDTO dimensions) {
            baggageItemDTO.setDimensions(dimensions);
            return this;
        }

        public Builder withWeight(BigDecimal weight) {
            baggageItemDTO.setWeight(weight);
            return this;
        }

        public Builder withPieces(BigInteger pieces) {
            baggageItemDTO.setPieces(pieces);
            return this;
        }

        public Builder withColor(ColorDTO color) {
            baggageItemDTO.setColor(color);
            return this;
        }

        public Builder withDefaultBaggagePriority(BaggageItemPriorityEnum defaultBaggagePriority) {
            baggageItemDTO.setDefaultBaggagePriority(defaultBaggagePriority);
            return this;
        }

        public BaggageItemDTO build() {
            return baggageItemDTO;
        }
    }
}
