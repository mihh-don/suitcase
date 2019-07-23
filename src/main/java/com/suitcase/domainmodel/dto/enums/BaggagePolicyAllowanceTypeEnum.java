package com.suitcase.domainmodel.dto.enums;

public enum BaggagePolicyAllowanceTypeEnum {
    UNRESTRICTED("unrestricted"),
    NOT_ALLOWED("not allowed"),
    LIMITED_AMOUNT("limited amount"),
    LIMITED_WEIGHT("limited weight"),
    EXTRA_FEE("extra fee"),
    SECURELY_WRAPPED("securely wrapped");

    private String description;

    BaggagePolicyAllowanceTypeEnum(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }
}
