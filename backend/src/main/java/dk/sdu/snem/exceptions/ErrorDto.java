package dk.sdu.snem.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.http.HttpStatus;

/**
 * Error response.
 *
 * @param timestamp when error occurred
 * @param status http status of error
 * @param error error title
 * @param message error message
 * @param path request path error occurred at
 */
@Schema(name = "ErrorResponse")
public record ErrorDto(Instant timestamp, int status, String error, String message, String path) {
  /**
   * Instantiate error using exception and request.
   *
   * @param e exception
   * @param request request
   * @param status status
   */
  public ErrorDto(Exception e, HttpServletRequest request, HttpStatus status) {
    this(e.getMessage(), request, status);
  }

  /**
   * Instantiate error using exception and request.
   *
   * @param message message
   * @param request request
   * @param status status
   */
  public ErrorDto(String message, HttpServletRequest request, HttpStatus status) {
    this(
        Instant.now().truncatedTo(ChronoUnit.MILLIS),
        status.value(),
        status.getReasonPhrase(),
        message,
        request.getRequestURI());
  }
}
