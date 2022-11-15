package UserDefinedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "This User Not Found.")
public class UserNotFoundException extends Exception {


}
