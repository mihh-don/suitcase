package com.suitcase.utils;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.suitcase.utils.TransportRestEndpointImplHelper.getAllTransportCarrierNames;
import static com.suitcase.utils.TravelRestEndpointImplHelper.getAllBaggageItems;

public class TransportCarriersArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return getAllTransportCarrierNames().stream().map(Arguments::of);
    }
}
