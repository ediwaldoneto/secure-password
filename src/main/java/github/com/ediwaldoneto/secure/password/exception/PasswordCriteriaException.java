package github.com.ediwaldoneto.secure.password.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PasswordCriteriaException extends SecurePasswordException {


    private final String detail;

    public PasswordCriteriaException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
       var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
       pb.setTitle("Critérios de Senha Não Atendidos");
       pb.setDetail(detail);
       return pb;
    }
}
