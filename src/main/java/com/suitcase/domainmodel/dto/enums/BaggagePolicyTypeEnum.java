package com.suitcase.domainmodel.dto.enums;

public enum BaggagePolicyTypeEnum {
    BAGGAGE_ITEM_TYPE_POLICY("Policy applicable to item types"),
    BAGGAGE_ITEM_CATEGORY_POLICY("Policy applicable to item categories"),
    BAGGAGE_STORAGE_TYPE_POLICY("Policy applicable to storage types");

    private String description;

    BaggagePolicyTypeEnum(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }
}
