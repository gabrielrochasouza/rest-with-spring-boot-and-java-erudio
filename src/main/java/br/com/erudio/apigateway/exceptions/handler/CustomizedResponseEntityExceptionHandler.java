package br.com.erudio.apigateway.exceptions.handler;

import br.com.erudio.apigateway.exceptions.ExceptionResponse;
import br.com.erudio.apigateway.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException (
            Exception exception, WebRequest request
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(
            Exception exception, WebRequest request
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage(), new Date(), request.getDescription(false), HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
