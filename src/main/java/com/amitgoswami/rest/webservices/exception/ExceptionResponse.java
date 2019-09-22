package com.amitgoswami.rest.webservices.exception;

import java.util.Date;

//Standard Exception which can be utilized by all the classes.
public class ExceptionResponse
{
    private Date timestramp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestramp, String message, String details)
    {
        super();
        this.timestramp = timestramp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestramp() {
        return timestramp;
    }

    public void setTimestramp(Date timestramp) {
        this.timestramp = timestramp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
