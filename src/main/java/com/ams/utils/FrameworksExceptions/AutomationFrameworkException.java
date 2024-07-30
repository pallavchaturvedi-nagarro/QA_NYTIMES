package com.ams.utils.FrameworksExceptions;

public class AutomationFrameworkException extends RuntimeException{


    public AutomationFrameworkException(String message){
        super(message);
    }

    public AutomationFrameworkException(String message, Throwable cause){
        super(message,cause);
    }
}
