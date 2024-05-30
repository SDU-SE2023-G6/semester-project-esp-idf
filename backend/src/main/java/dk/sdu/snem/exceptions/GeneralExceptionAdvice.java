package dk.sdu.snem.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/** Exception handler controller advice. */
@ControllerAdvice
public class GeneralExceptionAdvice {


  @ExceptionHandler({ConstraintViolationException.class})
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ResponseEntity<ErrorDto> handleConstraintViolationException(
      ConstraintViolationException e, HttpServletRequest request) {
    return generateResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, e, request);
  }


  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ResponseEntity<ErrorDto> handleInvalidRequestInput(
      ConstraintViolationException e, HttpServletRequest request) {
    return generateResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, e, request);
  }

  /**
   * Default exception handler, any exceptions not handled will be handled here.
   *
   * @param e exception
   * @param request request
   * @return error response
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResponseEntity<ErrorDto> defaultHandleException(Exception e, HttpServletRequest request) {
    var annotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
    if (annotation != null) {
      return generateResponseEntity(annotation.value(), e, request);
    } else if (e instanceof ErrorResponse er) {
      return generateResponseEntity(HttpStatus.valueOf(er.getStatusCode().value()), e, request);
    } else if (e instanceof WebClientResponseException wce) {
      var errorMsg = wce.getResponseBodyAsString();
      return ResponseEntity.status(wce.getStatusCode())
          .body(new ErrorDto(errorMsg, request, HttpStatus.valueOf(wce.getStatusCode().value())));
    }
    e.printStackTrace();
    return generateResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e, request);
  }

  private ResponseEntity<ErrorDto> generateResponseEntity(
      HttpStatus status, Exception e, HttpServletRequest request) {
    return ResponseEntity.status(status)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorDto(e, request, status));
  }
}
