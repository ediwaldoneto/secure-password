package github.com.ediwaldoneto.secure.password.controller;

import jakarta.validation.constraints.NotBlank;

public class SecurePasswordRequest {

    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
