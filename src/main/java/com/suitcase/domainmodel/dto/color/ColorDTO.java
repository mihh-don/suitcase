package com.suitcase.domainmodel.dto.color;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ColorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private ColorCombinationEnum colorCombination;
    @NotNull
    private BasicColorEnum primaryColor;
    private BasicColorEnum secondaryColor;

    public ColorCombinationEnum getColorCombination() {
        return colorCombination;
    }

    public void setColorCombination(ColorCombinationEnum colorCombination) {
        this.colorCombination = colorCombination;
    }

    public BasicColorEnum getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(BasicColorEnum primaryColor) {
        this.primaryColor = primaryColor;
    }

    public BasicColorEnum getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(BasicColorEnum secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorDTO)) return false;
        ColorDTO colorDTO = (ColorDTO) o;
        return getColorCombination() == colorDTO.getColorCombination() &&
                getPrimaryColor() == colorDTO.getPrimaryColor() &&
                getSecondaryColor() == colorDTO.getSecondaryColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColorCombination(), getPrimaryColor(), getSecondaryColor());
    }
}
