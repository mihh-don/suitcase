package com.suitcase.domainmodel.dto.enums;

public enum BaggagePolicyItemsAmountTypeEnum {
    SINGLE_ITEM("Policy applies to each single item"),
    MULTIPLE_ITEMS("Policy applies to multiple items"),
    ALL("Policy applies to all items");

    private String description;

    BaggagePolicyItemsAmountTypeEnum(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }
}