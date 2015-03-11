package com.miki.email.domain.model.account.exceptions;

/**
 * Created by miki on 10.03.2015.
 */
public class InvalidConnectionParamException extends Exception {

    private static final String ERR_MSG = " is invalid for a connection.";

    public InvalidConnectionParamException(String param) {
        super(param + ERR_MSG);
    }
}
