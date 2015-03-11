package com.miki.email.service;

import com.miki.email.vo.account.AccountVO;
import com.miki.email.vo.account.SessionVO;
import com.miki.email.vo.mail.MailVO;
import com.miki.email.vo.NotificationVO;
import com.miki.email.vo.mail.SearchEmailVO;

import javax.security.sasl.AuthenticationException;
import java.util.List;

/**
 * Created by miki on 09.03.2015.
 */
public interface IEmailService {

    /**
     * sends an email from an account to a list of receivers.
     * @param mailVO
     * @return
     * @throws AuthenticationException
     */
    public NotificationVO send(MailVO mailVO) throws AuthenticationException;

    /**
     * returns new emails since last time checked.
     * @param searchEmail
     * @return
     * @throws AuthenticationException
     */
    public List<MailVO> receive(SearchEmailVO searchEmail) throws AuthenticationException;

}
