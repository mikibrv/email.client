package com.miki.email.domain.model.account.exceptions;

/**
 * Created by miki on 10.03.2015.
 */
public class InvalidAccountException extends Exception {

    private static final String ERR_MSG = " is not valid for an account";

    public InvalidAccountException() {
        super(ERR_MSG);
    }

    public InvalidAccountException(String invalidParam) {
        super(invalidParam + ERR_MSG);
    }

    public InvalidAccountException(Object invalidParam) {
        super(invalidParam.toString() + ERR_MSG);
    }

}
