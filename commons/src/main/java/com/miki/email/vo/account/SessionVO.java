package com.miki.email.vo.account;

/**
 * Created by miki on 09.03.2015.
 */
public class SessionVO {

    private String sessionID;
    private AccountVO account;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public AccountVO getAccount() {
        return account;
    }

    public void setAccount(AccountVO account) {
        this.account = account;
    }
}
