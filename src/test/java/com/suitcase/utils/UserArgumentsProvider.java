package com.suitcase.utils;

import com.suitcase.domainmodel.dto.UserDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.suitcase.utils.TravelRestEndpointImplHelper.buildUsers;

public class UserArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return buildUsers().stream().map(UserDTO::getUsername).map(Arguments::of);
    }
}
