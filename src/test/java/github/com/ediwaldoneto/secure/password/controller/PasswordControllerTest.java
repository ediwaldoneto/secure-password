package github.com.ediwaldoneto.secure.password.controller;

import github.com.ediwaldoneto.secure.password.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordControllerTest {


    @Mock
    private PasswordService passwordService;

    @InjectMocks
    private PasswordController passwordController;


    @Test
    public void testValidatePassword() {

        String password = "securePassword123";
        SecurePasswordRequest request = new SecurePasswordRequest();
        request.setPassword(password);
        Map<String, String> expectedResponse = new HashMap<>();
        assertTrue(expectedResponse.isEmpty());

        when(passwordService.validatePassword(password)).thenReturn(expectedResponse);

        ResponseEntity<Map<String, String>> response = passwordController.validatePassword(request);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
}