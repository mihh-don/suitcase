package com.suitcase.utils;

import com.suitcase.domainmodel.dto.baggage.BaggageItemDTO;
import com.suitcase.domainmodel.dto.transport.TransportCarrierBaggagePolicyDTO;
import com.suitcase.domainmodel.dto.travel.TravelPlanDTO;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.stream.Collectors;

public final class CustomResponseMatchers {
    private CustomResponseMatchers() {

    }

    public static Matcher<CustomResponse<?>> matchesErrorResponse() {
                return new TypeSafeMatcher<CustomResponse<?>>() {

                    @Override
                    public void describeTo(Description description) {
                        description.appendText("Should return error response");
                    }

                    @Override
                    protected boolean matchesSafely(CustomResponse<?> response) {
                        return response != null
                                && response.getStatus() != null
                        && response.getStatus().is4xxClientError();
                    }
        };
    }

    public static Matcher<CustomResponse<?>> matchesCustomErrorResponse() {
        return new TypeSafeMatcher<CustomResponse<?>>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Should return error response");
            }

            @Override
            protected boolean matchesSafely(CustomResponse<?> response) {
                return response != null
                        && response.getStatus() != null
                        && response.getStatus().is4xxClientError();
            }
        };
    }

    public static Matcher<CustomResponse<Set<String>>> matchesResponseStringsSet(final Set<String> set) {

        return new TypeSafeMatcher<CustomResponse<Set<String>>>() {

            @Override
            protected boolean matchesSafely(final CustomResponse<Set<String>> response) {
                return isOKResponse(response)
                        && responseBodyMatchesSet(response.getContent(), set);
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the set: "
                        + String.join(", ", set));
            }
        };
    }

    public static Matcher<CustomResponse<BaggageItemDTO>> matchesResponseBaggageItem(final BaggageItemDTO dto) {
        return new TypeSafeMatcher<CustomResponse<BaggageItemDTO>>() {

            @Override
            protected boolean matchesSafely(final CustomResponse<BaggageItemDTO> response) {
                return isOKResponse(response)
                        && response.getContent() != null
                        && dto.equals(response.getContent());
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the baggage item dto: "
                        + dto);
            }
        };
    }

    public static Matcher<CustomResponse<TravelPlanDTO>> matchesResponseTravelPlan(final TravelPlanDTO dto) {
        return new TypeSafeMatcher<CustomResponse<TravelPlanDTO>>() {

            @Override
            protected boolean matchesSafely(final CustomResponse<TravelPlanDTO> response) {
                return isOKResponse(response)
                        && response.getContent() != null
                        && dto.equals(response.getContent());
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the baggage item dto: "
                        + dto);
            }
        };
    }

    public static Matcher<CustomResponse<Set<TransportCarrierBaggagePolicyDTO>>>
    matchesResponseBaggagePoliciesSet(final Set<TransportCarrierBaggagePolicyDTO> set) {

        return new TypeSafeMatcher<CustomResponse<Set<TransportCarrierBaggagePolicyDTO>>>() {

            @Override
            protected boolean matchesSafely(final CustomResponse<Set<TransportCarrierBaggagePolicyDTO>> response) {
                return isOKResponse(response)
                        && responseBodyMatchesSet(response.getContent(), set);
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should be OK and match the set: "
                        + set.stream().map(TransportCarrierBaggagePolicyDTO::getName).collect(Collectors.joining(", ")));
            }
        };
    }

    private static <V, T extends Set<V>> boolean responseBodyMatchesSet(final T responseBody, final Set<V> set) {
        return responseBody != null
                && responseBody.size() == set.size()
                && responseBody.containsAll(set);
    }

    private static boolean isOKResponse(CustomResponse<?> response) {
        return HttpStatus.OK.equals(response.getStatus());
    }
}
