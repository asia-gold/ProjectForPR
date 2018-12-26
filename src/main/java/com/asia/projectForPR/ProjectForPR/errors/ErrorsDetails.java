package com.asia.projectForPR.ProjectForPR.errors;

import java.util.Date;

public class ErrorsDetails {

    private Date timestamp;
    private String message;
    private String details;

    public ErrorsDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
