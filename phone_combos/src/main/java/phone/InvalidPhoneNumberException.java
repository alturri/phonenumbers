package phone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 *  This class extends RuntimeException, rather than Exception, so as to 
 *  go along what seems to me to be the predominant practice these days 
 *  regarding use of unchecked, rather than checked, exceptions, at least
 *  when using Spring.  Also, this way, these exceptions will still be handled
 *  by the corresponding @ControllerAdvice-annotated class.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPhoneNumberException extends RuntimeException {

	public InvalidPhoneNumberException(String errorMessage) {
		super(errorMessage);
	}
}