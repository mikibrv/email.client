package com.miki.email.service;

import com.miki.email.vo.account.AccountVO;
import com.miki.email.vo.NotificationVO;
import com.miki.email.vo.account.SessionVO;

import javax.security.sasl.AuthenticationException;

/**
 * Created by miki on 09.03.2015.
 */
public interface IAccountService {

    /**
     *
     * @param account
     * @return AccountVO
     * @throws javax.security.sasl.AuthenticationException
     */
    public SessionVO login(AccountVO account) throws AuthenticationException;

    /**
     * 
     * @param session
     * @return
     */
    public NotificationVO logout(SessionVO session);

}
