package org.myapp;

public class ApplicationException extends Exception{

    public ApplicationException(String s) {
        super(s);
    }

    public ApplicationException(String s, Exception e) {
        super(s, e);
    }
}