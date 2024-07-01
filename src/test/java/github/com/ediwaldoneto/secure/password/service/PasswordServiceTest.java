package github.com.ediwaldoneto.secure.password.service;

import github.com.ediwaldoneto.secure.password.exception.PasswordCriteriaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordServiceTest {

    @InjectMocks
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void whenPasswordIsValid_thenNoException() {
        String validPassword = "Valid1@Password";
        Map<String, String> result = passwordService.validatePassword(validPassword);
        assertTrue(result.isEmpty());
    }

    @Test
    void whenPasswordIsTooShort_thenThrowException() {
        String shortPassword = "Short1@";
        PasswordCriteriaException exception = assertThrows(PasswordCriteriaException.class, () -> {
            passwordService.validatePassword(shortPassword);
        });
        assertTrue(exception.toProblemDetail().getDetail().contains("length"));
    }

    @Test
    void whenPasswordHasNoUppercase_thenThrowException() {
        String noUppercasePassword = "valid1@password";
        PasswordCriteriaException exception = assertThrows(PasswordCriteriaException.class, () -> {
            passwordService.validatePassword(noUppercasePassword);
        });
        assertTrue(exception.toProblemDetail().getDetail().contains("uppercase"));
    }

    @Test
    void whenPasswordHasNoLowercase_thenThrowException() {
        String noLowercasePassword = "VALID1@PASSWORD";
        PasswordCriteriaException exception = assertThrows(PasswordCriteriaException.class, () -> {
            passwordService.validatePassword(noLowercasePassword);
        });
        assertTrue(exception.toProblemDetail().getDetail().contains("lowercase"));
    }

    @Test
    void whenPasswordHasNoDigit_thenThrowException() {
        String noDigitPassword = "Valid@Password";
        PasswordCriteriaException exception = assertThrows(PasswordCriteriaException.class, () -> {
            passwordService.validatePassword(noDigitPassword);
        });
        assertTrue(exception.toProblemDetail().getDetail().contains("digit"));
    }

    @Test
    void whenPasswordHasNoSpecialCharacter_thenThrowException() {
        String noSpecialPassword = "Valid1Password";
        PasswordCriteriaException exception = assertThrows(PasswordCriteriaException.class, () -> {
            passwordService.validatePassword(noSpecialPassword);
        });
        assertTrue(exception.toProblemDetail().getDetail().contains("special"));
    }

}
