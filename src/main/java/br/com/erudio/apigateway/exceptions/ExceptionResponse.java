package br.com.erudio.apigateway.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID= 1L;

    private String message;
    private Date timeStamp;
    private String details;
    private int statusCode;

    public ExceptionResponse(String message, Date timeStamp, String details, int statusCode) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
        this.statusCode = statusCode;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
