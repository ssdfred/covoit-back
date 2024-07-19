package covoit.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RestResponseEntityExceptionHandler {
	@ExceptionHandler({AnomalieException.class})
	protected ResponseEntity<String> traiterErreurs(AnomalieException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
		}
}
