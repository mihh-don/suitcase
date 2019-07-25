package com.suitcase.service;

import com.suitcase.utils.UserArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.suitcase.utils.ResponseEntityMatchers.matchesErrorResponse;
import static com.suitcase.utils.ResponseEntityMatchers.matchesResponseStringsSet;
import static com.suitcase.utils.TravelRestEndpointImplHelper.getBaggageItemsNames;
import static org.hamcrest.MatcherAssert.assertThat;

class TravelServiceTest {

    private static final String SOME_USER = "someuser";

    @InjectMocks
    private TravelService travelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserBaggageItemsNamesShouldReturnErrorResponseForNullUsername() {
        assertThat(travelService.getUserBaggageItemsNames(null), matchesErrorResponse());
    }

    @Test
    void getUserBaggageItemsNamesShouldReturnErrorResponseForEmptyUsername() {
        assertThat(travelService.getUserBaggageItemsNames(""), matchesErrorResponse());
    }

    @Test
    void getUserBaggageItemsNamesShouldReturnErrorResponseForNonExistingUsername() {
        assertThat(travelService.getUserBaggageItemsNames(SOME_USER), matchesErrorResponse());
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    void getUserBaggageItemsNamesShouldReturnBaggageNamesForUsername(String username) {
        assertThat(travelService.getUserBaggageItemsNames(username), matchesResponseStringsSet(getBaggageItemsNames(username)));
    }
}