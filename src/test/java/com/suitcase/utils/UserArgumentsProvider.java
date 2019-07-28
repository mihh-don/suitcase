package com.suitcase.utils;

import com.suitcase.domainmodel.dto.UserDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.suitcase.utils.TravelRestEndpointImplHelper.buildUsers;

public class UserArgumentsProvider implements ArgumentsProvider {

    private static final String SOME_VALUE = "somevalue";
    private static final String EMPTY_STRING = "";

    public static final String INVALID_INPUT_PROVIDER = "com.suitcase.utils.UserArgumentsProvider#invalidInputProvider";

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return buildUsers().stream().map(UserDTO::getUsername).map(Arguments::of);
    }

    static Stream<String> invalidInputProvider() {
        return Stream.of(null, EMPTY_STRING, SOME_VALUE);
    }
}
