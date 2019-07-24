package com.suitcase.webservice;

import com.suitcase.domainmodel.dto.UserDTO;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static com.suitcase.webservice.TravelRestEndpointImplHelper.buildUsers;
import static com.suitcase.webservice.TravelRestEndpointImplHelper.getBaggageItemsNames;
import static org.hamcrest.MatcherAssert.assertThat;

class TravelRestEndpointImplTest {

    @InjectMocks
    private TravelRestEndpointImpl restEndpoint;
    private UserDTO user1;
    private UserDTO user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        List<UserDTO> users = buildUsers();
        user1 = users.get(0);
        user2 = users.get(1);
    }

    @Test
    void allUserBaggageItemsNamesShouldReturnErrorResponseForNullUsername() {
        assertThat(restEndpoint.allUserBaggageItemsNames(null), matchesErrorResponse());
    }

    @Test
    void allUserBaggageItemsNamesShouldReturnErrorResponseForEmptyUsername() {
        assertThat(restEndpoint.allUserBaggageItemsNames(""), matchesErrorResponse());
    }

    @Test
    void allUserBaggageItemsNamesShouldReturnErrorResponseForNotExistingUsername() {
        assertThat(restEndpoint.allUserBaggageItemsNames("someuser"), matchesErrorResponse());
    }

    @Test
    void allUserBaggageItemsNamesShouldReturnBaggageNamesForUser1() {
        String username = user1.getUsername();
        assertThat(restEndpoint.allUserBaggageItemsNames(username), matchesResponse(getBaggageItemsNames(username)));
    }

    @Test
    void allUserBaggageItemsNamesShouldReturnBaggageNamesForUser2() {
        String username = user2.getUsername();
        assertThat(restEndpoint.allUserBaggageItemsNames(username), matchesResponse(getBaggageItemsNames(username)));
    }

    private Matcher<ResponseEntity<Set<String>>> matchesErrorResponse() {
        return new TypeSafeMatcher<ResponseEntity<Set<String>>>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Should return error response");
            }

            @Override
            protected boolean matchesSafely(ResponseEntity<Set<String>> response) {
                return response != null
                        && response.getStatusCode() != null
                        && response.getStatusCode().is4xxClientError();
            }
        };
    }

    private Matcher<ResponseEntity<Set<String>>> matchesResponse(final Set<String> list) {

        return new TypeSafeMatcher<ResponseEntity<Set<String>>>() {

            @Override
            protected boolean matchesSafely(ResponseEntity<Set<String>> response) {
                return HttpStatus.OK.equals(response.getStatusCode())
                        && response.getBody() != null
                        && response.getBody().size() == list.size()
                        && response.getBody().containsAll(list);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Response should be OK and match the list: " + String.join(", ", list));
            }
        };
    }
}