package com.suitcase.utils;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public final class ResponseEntityMatchers {
    private ResponseEntityMatchers() {

    }

    public static Matcher<ResponseEntity<?>> matchesErrorResponse() {
        return new TypeSafeMatcher<ResponseEntity<?>>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Should return error response");
            }

            @Override
            protected boolean matchesSafely(ResponseEntity<?> response) {
                return response != null
                        && response.getStatusCode() != null
                        && response.getStatusCode().is4xxClientError();
            }
        };
    }

    public static Matcher<ResponseEntity<Set<String>>> matchesResponseStringsSet(final Set<String> set) {

        return new TypeSafeMatcher<ResponseEntity<Set<String>>>() {

            @Override
            protected boolean matchesSafely(final ResponseEntity<Set<String>> response) {
                return isOKResponse(response)
                        && response.getBody() != null
                        && response.getBody().size() == set.size()
                        && response.getBody().containsAll(set);
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the set: "
                        + String.join(", ", set));
            }
        };
    }

    public static Matcher<ResponseEntity<BaggageItemDTO>> matchesResponseBaggageItem(final BaggageItemDTO dto) {
        return new TypeSafeMatcher<ResponseEntity<BaggageItemDTO>>() {

            @Override
            protected boolean matchesSafely(final ResponseEntity<BaggageItemDTO> response) {
                return isOKResponse(response)
                        && response.getBody() != null
                        && dto.equals(response.getBody());
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the baggage item dto: "
                        + dto);
            }
        };
    }

    public static Matcher<ResponseEntity<TravelPlanDTO>> matchesResponseTravelPlan(final TravelPlanDTO dto) {
        return new TypeSafeMatcher<ResponseEntity<TravelPlanDTO>>() {

            @Override
            protected boolean matchesSafely(final ResponseEntity<TravelPlanDTO> response) {
                return isOKResponse(response)
                        && response.getBody() != null
                        && dto.equals(response.getBody());
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the baggage item dto: "
                        + dto);
            }
        };
    }

    private static boolean isOKResponse(ResponseEntity<?> response) {
        return HttpStatus.OK.equals(response.getStatusCode());
    }
}
