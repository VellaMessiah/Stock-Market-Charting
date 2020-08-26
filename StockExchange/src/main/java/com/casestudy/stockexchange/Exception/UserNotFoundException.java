package com.casestudy.stockexchange.Exception;

public class UserNotFoundException extends Throwable {
    private String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
