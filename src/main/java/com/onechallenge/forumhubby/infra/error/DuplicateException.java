package com.onechallenge.forumhubby.infra.error;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String errorMessage){
        super(errorMessage);
    }
}
