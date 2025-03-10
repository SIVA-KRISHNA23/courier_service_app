package com.example.courier.service;

import com.example.courier.dao.UserRepository;
import com.example.courier.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteUser() {
        // Mock data
        Long userId = 1L;
        Mockito.when(userRepository.existsById(userId)).thenReturn(true);

        // Call service method
        boolean deleted = userService.deleteUser(userId);

        // Assertions
        Assertions.assertTrue(deleted);
    }

    @Test
    public void testDeleteUserNotFound() {
        // Mock data
        Long userId = 1L;
        Mockito.when(userRepository.existsById(userId)).thenReturn(false);

        // Call service method
        boolean deleted = userService.deleteUser(userId);

        // Assertions
        Assertions.assertFalse(deleted);
    }
}
