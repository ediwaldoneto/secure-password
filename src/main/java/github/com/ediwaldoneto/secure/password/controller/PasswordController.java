package github.com.ediwaldoneto.secure.password.controller;

import github.com.ediwaldoneto.secure.password.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping("validate-password")
    public ResponseEntity<Map<String, String>> validatePassword(@Valid @RequestBody SecurePasswordRequest request){
        return new ResponseEntity<>(service.validatePassword(request.getPassword()), HttpStatus.NO_CONTENT);
    }

}
