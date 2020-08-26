package com.casestudy.stockexchange.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorResponse {
    private String errorMessage;
    private int statusCode;
    private long exceptionTime;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(long exceptionTime) {
        this.exceptionTime = exceptionTime;
    }
}
