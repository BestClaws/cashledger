package in.sliya.cashledger.controllers.errors;

import in.sliya.cashledger.models.errors.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ApiError> handleAllExceptions(RuntimeException e) {
        logger.error("error occurred: ", e);
      return ResponseEntity.internalServerError().body(new ApiError(500, "INTERNAL_SERVER_ERROR", e.getMessage()));
   }
}
