package com.sportfemme.en_avant_toutes.err;

import lombok.Getter;

@Getter
public class UserInexistantException extends RuntimeException {
    private static final long serialVersionUID = -4001785457990592779L;
    private String message;

    public UserInexistantException() {}

    public UserInexistantException(String msg) {
        super(msg);
        this.message = msg;
    }

}
