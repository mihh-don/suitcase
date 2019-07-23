package com.suitcase.domainmodel.dto.color;

public enum ColorCombinationEnum {
    MONO("Monocoloured"), DUO("Bicoloured"), MULTI("Multicoloured");

    private String description;

    ColorCombinationEnum(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }
}
