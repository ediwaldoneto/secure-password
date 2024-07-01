package github.com.ediwaldoneto.secure.password.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SecurePasswordException extends RuntimeException {

     public ProblemDetail toProblemDetail() {
         var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
         pb.setTitle("Secure Password internal server error");
         return pb;
     }
}
