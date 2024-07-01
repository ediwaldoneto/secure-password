package github.com.ediwaldoneto.secure.password.service;

import github.com.ediwaldoneto.secure.password.exception.PasswordCriteriaException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class PasswordService {

    public Map<String, String> validatePassword(final String password) {
        Map<String, String> validationResults = new HashMap<>();

        if (password.length() < 8) {
            validationResults.put("length", "A senha deve ter pelo menos 8 caracteres.");
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        if (!hasUpper) {
            validationResults.put("uppercase", "A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (!hasLower) {
            validationResults.put("lowercase", "A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!hasDigit) {
            validationResults.put("digit", "A senha deve conter pelo menos um número.");
        }
        if (!hasSpecial) {
            validationResults.put("special", "A senha deve conter pelo menos um caractere especial.");
        }

        if (!validationResults.isEmpty()) {
            throw new PasswordCriteriaException(validationResults.toString());
        }
        return null;
    }
}

