package ru.online.t1_academy.projectT1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

@ExceptionHandler(value = {NullTaskException.class})
    public ResponseEntity<Object> handleNullTaskException(NullTaskException exc) {
    return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
}
}
