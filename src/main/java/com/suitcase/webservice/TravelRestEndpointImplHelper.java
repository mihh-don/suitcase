package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.UserDTO;
import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.baggage.DimensionsDTO;
import com.suitcase.domainmodel.dto.color.BasicColorEnum;
import com.suitcase.domainmodel.dto.color.ColorCombinationEnum;
import com.suitcase.domainmodel.dto.color.ColorDTO;
import com.suitcase.domainmodel.dto.enums.BaggageItemCategoryEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemPriorityEnum;
import com.suitcase.domainmodel.dto.enums.BaggageItemTypeEnum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

final class TravelRestEndpointImplHelper {

    private static final double WEIGHT_VALUE = 3.03;
    private static Map<String, Set<String>> userBaggageItemsMap = new HashMap<>();
    private static final String USER01 = "userone";
    private static final String USER02 = "usertwo";
    private static final String SMTH01 = "something_1";
    private static final String SMTH02 = "something_2";
    private static final String BAGGAGE_01 = "Toffifee";
    private static final String BAGGAGE_02 = "Pirates Game";
    private static final String BAGGAGE_03 = "Cotton wool";
    private static final String BAGGAGE_04 = "Socks";
    private static final String BAGGAGE_05 = "Relax ball";
    private static final String BAGGAGE_06 = "Headlamp";
    private static final String BAGGAGE_07 = "Mamaliga";

    private TravelRestEndpointImplHelper() {

    }

    static {
        userBaggageItemsMap.put(USER01, new HashSet<>(Arrays.asList(BAGGAGE_01, BAGGAGE_02, BAGGAGE_03)));
        userBaggageItemsMap.put(USER02, new HashSet<>(Arrays.asList(BAGGAGE_04, BAGGAGE_05, BAGGAGE_06, BAGGAGE_07)));
    }

    static Set<String> getBaggageItemsNames(String username) {
        return userBaggageItemsMap.get(username);
    }

    static List<UserDTO> buildUsers() {
        UserDTO user1 = new UserDTO.Builder()
                .withUsername(USER01)
                .withPassword(SMTH01)
                .withEmail(USER01 + "@mail.com")
                .withBaggageItems(buildBaggageItemsSetOne())
                .build();
        UserDTO user2 = new UserDTO.Builder()
                .withUsername(USER02)
                .withPassword(SMTH02)
                .withEmail(USER02 + "@mail.com")
                .withBaggageItems(buildBaggageItemsSetTwo())
                .build();
        return Arrays.asList(user1, user2);
    }

    private static Set<BaggageItemDTO> buildBaggageItemsSetOne() {
        BaggageItemDTO baggage1 = buildBaggageItem(BAGGAGE_01, BaggageItemCategoryEnum.FOOD);
        BaggageItemDTO baggage2 = buildBaggageItem(BAGGAGE_02, BaggageItemCategoryEnum.TOYS_GAMES);
        BaggageItemDTO baggage3 = buildBaggageItem(BAGGAGE_03, BaggageItemCategoryEnum.TOILETRIES);
        return new HashSet<>(Arrays.asList(baggage1, baggage2, baggage3));
    }

    private static Set<BaggageItemDTO> buildBaggageItemsSetTwo() {
        BaggageItemDTO baggage4 = buildBaggageItem(BAGGAGE_04, BaggageItemCategoryEnum.CLOTHES);
        BaggageItemDTO baggage5 = buildBaggageItem(BAGGAGE_05, BaggageItemCategoryEnum.TOYS_GAMES);
        BaggageItemDTO baggage6 = buildBaggageItem(BAGGAGE_06, BaggageItemCategoryEnum.ELECTRONIC_DEVICES);
        BaggageItemDTO baggage7 = buildBaggageItem(BAGGAGE_07, BaggageItemCategoryEnum.FOOD);
        return new HashSet<>(Arrays.asList(baggage4, baggage5, baggage6, baggage7));
    }

    private static BaggageItemDTO buildBaggageItem(final String name, final BaggageItemCategoryEnum category) {
        return new BaggageItemDTO.Builder()
                .withName(name)
                .withBaggageCategory(category)
                .withBaggageType(BaggageItemTypeEnum.SOLID)
                .withDefaultBaggagePriority(BaggageItemPriorityEnum.NEED)
                .withColor(new ColorDTO.Builder().withPrimaryColor(BasicColorEnum.BLACK).withColorCombination(ColorCombinationEnum.MONO).build())
                .withDescription(name + " info")
                .withDimensions(new DimensionsDTO.Builder().withCombinedDimensionsLength(BigDecimal.ONE).build())
                .withPieces(BigInteger.ONE)
                .withWeight(BigDecimal.valueOf(WEIGHT_VALUE))
                .build();
    }
}
