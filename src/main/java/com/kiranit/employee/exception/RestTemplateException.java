package com.kiranit.employee.exception;

public class RestTemplateException extends RuntimeException{
    RestTemplateException(){
        super();
    }

    public RestTemplateException(String exception){
        super(exception);
    }
}
