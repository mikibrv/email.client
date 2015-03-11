package com.miki.email.vo.account;

import java.io.Serializable;

/**
 * Created by miki on 09.03.2015.
 */
public class EmailProviderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private MailServerConnectionVO smtpConnection;

    private MailServerConnectionVO imapConnection;

    private MailServerConnectionVO pop3Connection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MailServerConnectionVO getSmtpConnection() {
        return smtpConnection;
    }

    public void setSmtpConnection(MailServerConnectionVO smtpConnection) {
        this.smtpConnection = smtpConnection;
    }

    public MailServerConnectionVO getImapConnection() {
        return imapConnection;
    }

    public void setImapConnection(MailServerConnectionVO imapConnection) {
        this.imapConnection = imapConnection;
    }

    public MailServerConnectionVO getPop3Connection() {
        return pop3Connection;
    }

    public void setPop3Connection(MailServerConnectionVO pop3Connection) {
        this.pop3Connection = pop3Connection;
    }
}
