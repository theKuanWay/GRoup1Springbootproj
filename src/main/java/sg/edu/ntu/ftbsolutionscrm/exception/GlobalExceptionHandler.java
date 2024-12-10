package sg.edu.ntu.ftbsolutionscrm.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FavouriteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourseNotFoundException(RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse (e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
}
