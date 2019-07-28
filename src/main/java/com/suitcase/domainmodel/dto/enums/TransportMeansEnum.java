package com.suitcase.domainmodel.dto.enums;

public enum TransportMeansEnum {
    AIRPLANE("airplane"),
    HELICOPTER("helicopter"),
    TRAIN("train"),
    SHIP("ship"),
    BOAT("boat"),
    CAR("car"),
    BUS("bus"),
    TRUCK("truck"),
    MOTORCYCLE("motorcycle"),
    BICYCLE("bicycle & e-bike"),
    SCOOTER("scooter & e-scooter"),
    BY_FOOT("by foot"),
    OTHER("other");

    private String value;

    TransportMeansEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
