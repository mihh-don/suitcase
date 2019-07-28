package com.suitcase.domainmodel.dto.transport;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.baggage.DimensionsDTO;
import com.suitcase.domainmodel.dto.enums.BaggagePolicyAllowanceTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class BaggagePolicyAllowanceDTO extends AbstractEntityDTO {

    @NotNull
    private BaggagePolicyAllowanceTypeEnum baggagePolicyAllowanceType;
    // the min & max number of allowed items of this type
    private BigInteger minimumAllowedAmount;
    private BigInteger maximumAllowedAmount;
    // the min & max allowed weight for this item
    private BigDecimal minimumAllowedWeight;
    private BigDecimal maximumAllowedWeight;
    // the min & max allowed volume for this item
    private BigDecimal minimumAllowedVolume;
    private BigDecimal maximumAllowedVolume;
    // the min & max allowed dimensions (or combined dimensions)
    private DimensionsDTO minimumAllowedDimensions;
    private DimensionsDTO maximumAllowedDimensions;
    // extra fee to pay for allowance, if applicable
    private BigDecimal extraFee;
    // optional description of the policy allowance
    private String description;

    public BaggagePolicyAllowanceTypeEnum getBaggagePolicyAllowanceType() {
        return baggagePolicyAllowanceType;
    }

    public void setBaggagePolicyAllowanceType(final BaggagePolicyAllowanceTypeEnum baggagePolicyAllowanceType) {
        this.baggagePolicyAllowanceType = baggagePolicyAllowanceType;
    }

    public BigInteger getMaximumAllowedAmount() {
        return maximumAllowedAmount;
    }

    public void setMaximumAllowedAmount(final BigInteger maximumAllowedAmount) {
        this.maximumAllowedAmount = maximumAllowedAmount;
    }

    public BigDecimal getMaximumAllowedWeight() {
        return maximumAllowedWeight;
    }

    public void setMaximumAllowedWeight(final BigDecimal maximumAllowedWeight) {
        this.maximumAllowedWeight = maximumAllowedWeight;
    }

    public BigDecimal getMaximumAllowedVolume() {
        return maximumAllowedVolume;
    }

    public void setMaximumAllowedVolume(final BigDecimal maximumAllowedVolume) {
        this.maximumAllowedVolume = maximumAllowedVolume;
    }

    public DimensionsDTO getMaximumAllowedDimensions() {
        return maximumAllowedDimensions;
    }

    public void setMaximumAllowedDimensions(final DimensionsDTO maximumAllowedDimensions) {
        this.maximumAllowedDimensions = maximumAllowedDimensions;
    }

    public BigInteger getMinimumAllowedAmount() {
        return minimumAllowedAmount;
    }

    public void setMinimumAllowedAmount(BigInteger minimumAllowedAmount) {
        this.minimumAllowedAmount = minimumAllowedAmount;
    }

    public BigDecimal getMinimumAllowedWeight() {
        return minimumAllowedWeight;
    }

    public void setMinimumAllowedWeight(BigDecimal minimumAllowedWeight) {
        this.minimumAllowedWeight = minimumAllowedWeight;
    }

    public BigDecimal getMinimumAllowedVolume() {
        return minimumAllowedVolume;
    }

    public void setMinimumAllowedVolume(BigDecimal minimumAllowedVolume) {
        this.minimumAllowedVolume = minimumAllowedVolume;
    }

    public DimensionsDTO getMinimumAllowedDimensions() {
        return minimumAllowedDimensions;
    }

    public void setMinimumAllowedDimensions(DimensionsDTO minimumAllowedDimensions) {
        this.minimumAllowedDimensions = minimumAllowedDimensions;
    }

    public BigDecimal getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(final BigDecimal extraFee) {
        this.extraFee = extraFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaggagePolicyAllowanceDTO)) return false;
        BaggagePolicyAllowanceDTO that = (BaggagePolicyAllowanceDTO) o;
        return getBaggagePolicyAllowanceType() == that.getBaggagePolicyAllowanceType() &&
                Objects.equals(getMinimumAllowedAmount(), that.getMinimumAllowedAmount()) &&
                Objects.equals(getMaximumAllowedAmount(), that.getMaximumAllowedAmount()) &&
                Objects.equals(getMinimumAllowedWeight(), that.getMinimumAllowedWeight()) &&
                Objects.equals(getMaximumAllowedWeight(), that.getMaximumAllowedWeight()) &&
                Objects.equals(getMinimumAllowedVolume(), that.getMinimumAllowedVolume()) &&
                Objects.equals(getMaximumAllowedVolume(), that.getMaximumAllowedVolume()) &&
                Objects.equals(getMinimumAllowedDimensions(), that.getMinimumAllowedDimensions()) &&
                Objects.equals(getMaximumAllowedDimensions(), that.getMaximumAllowedDimensions()) &&
                Objects.equals(getExtraFee(), that.getExtraFee()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBaggagePolicyAllowanceType(), getMinimumAllowedAmount(), getMaximumAllowedAmount(), getMinimumAllowedWeight(), getMaximumAllowedWeight(), getMinimumAllowedVolume(), getMaximumAllowedVolume(), getMinimumAllowedDimensions(), getMaximumAllowedDimensions(), getExtraFee(), getDescription());
    }

    public static class Builder {
        private BaggagePolicyAllowanceDTO baggagePolicyAllowance;

        public Builder() {
            baggagePolicyAllowance = new BaggagePolicyAllowanceDTO();
        }

        public Builder withBaggagePolicyAllowanceType(final BaggagePolicyAllowanceTypeEnum baggagePolicyAllowanceType) {
            baggagePolicyAllowance.setBaggagePolicyAllowanceType(baggagePolicyAllowanceType);
            return this;
        }

        public Builder withMinimumAllowedAmount(final BigInteger minimumAllowedAmount) {
            baggagePolicyAllowance.setMinimumAllowedAmount(minimumAllowedAmount);
            return this;
        }

        public Builder withMaximumAllowedAmount(final BigInteger maximumAllowedAmount) {
            baggagePolicyAllowance.setMaximumAllowedAmount(maximumAllowedAmount);
            return this;
        }

        public Builder withMinimumAllowedWeight(BigDecimal minimumAllowedWeight) {
            baggagePolicyAllowance.setMinimumAllowedWeight(minimumAllowedWeight);
            return this;
        }

        public Builder withMaximumAllowedWeight(final BigDecimal maximumAllowedWeight) {
            baggagePolicyAllowance.setMaximumAllowedWeight(maximumAllowedWeight);
            return this;
        }

        public Builder withMinimumAllowedVolume(final BigDecimal minimumAllowedVolume) {
            baggagePolicyAllowance.setMinimumAllowedVolume(minimumAllowedVolume);
            return this;
        }

        public Builder withMaximumAllowedVolume(final BigDecimal maximumAllowedVolume) {
            baggagePolicyAllowance.setMaximumAllowedVolume(maximumAllowedVolume);
            return this;
        }

        public Builder withMinimumAllowedDimensions(final DimensionsDTO minimumAllowedDimensions) {
            baggagePolicyAllowance.setMinimumAllowedDimensions(minimumAllowedDimensions);
            return this;
        }

        public Builder withMaximumAllowedDimensions(final DimensionsDTO maximumAllowedDimensions) {
            baggagePolicyAllowance.setMaximumAllowedDimensions(maximumAllowedDimensions);
            return this;
        }

        public Builder withExtraFee(final BigDecimal extraFee) {
            baggagePolicyAllowance.setExtraFee(extraFee);
            return this;
        }

        public Builder withDescription(final String description) {
            baggagePolicyAllowance.setDescription(description);
            return this;
        }

        public BaggagePolicyAllowanceDTO build() {
            return baggagePolicyAllowance;
        }
    }
}
