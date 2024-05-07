package dk.sdu.snem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception for something that was not found. */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
  public NotFoundException() {
    super("Resource was not found");
  }

  public NotFoundException(String message) {
    super(message);
  }
}
