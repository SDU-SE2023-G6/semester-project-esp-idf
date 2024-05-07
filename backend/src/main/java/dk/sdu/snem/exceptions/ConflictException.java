package dk.sdu.snem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception for something that was not found. */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
  public ConflictException(String message) {
    super(message);
  }
}