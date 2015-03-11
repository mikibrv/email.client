package com.miki.email.domain.model;

/**
 * Created by miki on 10.03.2015.
 */
public interface Entity<T> {

    boolean sameIdentityAs(T other);
}
