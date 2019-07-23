package com.suitcase.domainmodel.dto.baggage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class DimensionsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;
    // this field may look redundant, but sometimes we need to know only the sum and not the single values
    private BigDecimal combinedDimensionsLength;

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getCombinedDimensionsLength() {
        return combinedDimensionsLength;
    }

    public void setCombinedDimensionsLength(BigDecimal combinedDimensionsLength) {
        this.combinedDimensionsLength = combinedDimensionsLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DimensionsDTO)) return false;
        DimensionsDTO that = (DimensionsDTO) o;
        return Objects.equals(getWidth(), that.getWidth()) &&
                Objects.equals(getHeight(), that.getHeight()) &&
                Objects.equals(getDepth(), that.getDepth()) &&
                Objects.equals(getCombinedDimensionsLength(), that.getCombinedDimensionsLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight(), getDepth(), getCombinedDimensionsLength());
    }
}
