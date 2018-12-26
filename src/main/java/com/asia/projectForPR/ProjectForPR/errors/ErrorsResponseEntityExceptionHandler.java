package com.asia.projectForPR.ProjectForPR.errors;

import com.asia.projectForPR.ProjectForPR.Dog.DogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class ErrorsResponseEntityExceptionHandler {

    @ExceptionHandler(DogNotFoundException.class)
    public final ResponseEntity<ErrorsDetails> handleUserNotFoundException(DogNotFoundException ex, WebRequest request) {
        ErrorsDetails errorDetails = new ErrorsDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
