package com.teste.maven.resources.exception;

import com.teste.maven.services.exception.ResourceCantBeModifier;
import com.teste.maven.services.exception.ResourceCannotBeDeleted;
import com.teste.maven.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<StandardError> errorIdNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String erro = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError er = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }

    @ExceptionHandler(ResourceCannotBeDeleted.class)
    public ResponseEntity<StandardError> IdCanNotBeDeleted(ResourceCannotBeDeleted e, HttpServletRequest request){
        String erro = "This Id Have 1 or More Open Orders ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError er = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }

    @ExceptionHandler(ResourceCantBeModifier.class)
    public ResponseEntity<StandardError> AttributeCantBeModifier(ResourceNotFoundException e, HttpServletRequest request) {
        String erro = "Invalid Modification";
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        StandardError er = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(er);
    }



}
