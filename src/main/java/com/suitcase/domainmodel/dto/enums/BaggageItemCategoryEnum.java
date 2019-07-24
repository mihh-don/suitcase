package com.suitcase.domainmodel.dto.enums;

public enum BaggageItemCategoryEnum {
    SHOES("Shoes"),
    TOILETRIES("Toiletries & cosmetics"),
    BAGS("Bags, Backpacks & Suitcases"),
    MEDICINE("Medicine"),
    MEDICAL_DEVICES("Medical devices"),
    WEARABLES("Wearable technology"),
    ACCESSORIES("Accessories (non technological)"),
    CLOTHES("Clothes"),
    OFFICE_SUPPLIES("Office supplies (pen, paper, paper clips etc.)"),
    ELECTRONIC_DEVICES("Electronic devices"),
    HOUSE_TOOLS("Keys, screwdrivers etc."),
    FOOD("Food"),
    LIQUIDS("Liquids"),
    HOME_SUPPLIES("Dishes, cutlery, table cloths etc."),
    TOYS_GAMES("Toys, boardgames etc."),
    BOOKS_MAGAZINES("Books, magazines, flyers etc."),
    VEHICLES("Bikes, Mopeds, Cars, Boats etc."),
    SPECIAL_EQUIPMENT("Skiing equipment, Fishing equipment etc."),
    PETS("Pets"),
    PLANTS("Plants"),
    DANGEROUS_GOODS("Firearms and ammunition, Gases, Explosives, Flammable substances, Oxidizers, Corrosives, Chemical substances, Toxic substances"),
    CIGARETTES("(e-)cigarettes, cigars etc."),
    OTHERS("Other categories");

    private String description;

    BaggageItemCategoryEnum(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }
}
