package com.suitcase.config;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.suitcase.users.UserController;
import com.suitcase.users.User;
import com.suitcase.users.UserRepository;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class HelloControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController controller;

    private List<User> users;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        users = new ArrayList<>();
    }

    @Test
    void allUsersShouldBeReturned() {
        when(userRepository.findAll()).thenReturn(users);

        assertThat(controller.getAllUsers(), usersMatcher(users));
        logger.debug("All users");
    }

    private Matcher<List<User>> usersMatcher(List<User> originalUsers) {
        return new TypeSafeMatcher<List<User>>() {
            @Override
            protected boolean matchesSafely(List<User> users) {
                return users.containsAll(originalUsers) && users.size() == originalUsers.size();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Should match all original users");
            }
        };
    }
}
