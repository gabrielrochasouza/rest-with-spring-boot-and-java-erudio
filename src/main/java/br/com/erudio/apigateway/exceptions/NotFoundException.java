package br.com.erudio.apigateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String exceptionInfo) {
        super(exceptionInfo);
    }
}
