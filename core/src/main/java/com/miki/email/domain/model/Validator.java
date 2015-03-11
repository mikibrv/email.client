package com.miki.email.domain.model;

/**
 * Created by miki on 10.03.2015.
 */
public interface Validator<T> {

    void validate(T object) throws Exception;
}
