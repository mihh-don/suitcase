package com.suitcase.utils;

import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.suitcase.utils.TravelRestEndpointImplHelper.getAllTravelPlans;

public class TravelPlansArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return getAllTravelPlans().stream().map(TravelPlanDTO::getName).map(Arguments::of);
    }
}
