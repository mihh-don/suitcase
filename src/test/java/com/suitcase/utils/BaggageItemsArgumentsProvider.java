package com.suitcase.utils;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.suitcase.utils.TravelRestEndpointImplHelper.getAllBaggageItems;

public class BaggageItemsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return getAllBaggageItems().stream().map(BaggageItemDTO::getName).map(Arguments::of);
    }
}
