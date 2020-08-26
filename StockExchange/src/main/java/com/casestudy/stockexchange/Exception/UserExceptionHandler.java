package com.casestudy.stockexchange.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        UserErrorResponse userErrorResponse = new UserErrorResponse("No such user found", HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return new ResponseEntity<UserErrorResponse>(userErrorResponse,HttpStatus.NOT_FOUND);
    }
}
