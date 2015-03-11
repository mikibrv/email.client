package com.miki.email.domain.model.mail;

import com.miki.email.domain.model.ValueObject;
import com.miki.email.domain.model.account.Account;
import com.miki.email.domain.model.mail.exceptions.InvalidEmailFromException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by miki on 10.03.2015.
 */
public final class Mail implements ValueObject<Mail> {

    private Email email = new HtmlEmail();

    private Mail() {
    }


    public Email getEmail() {
        return this.email;
    }

    @Override
    public boolean sameValueAs(Mail other) {
        return false;
    }


    public static class Builder {

        private Mail mail;

        public Builder() {
            this.mail = new Mail();
        }

        public Builder usingAccount(Account account) throws EmailException {
            Email email = this.mail.getEmail();
            email.setAuthenticator(
                    new DefaultAuthenticator(account.getEmail(), account.getPlainTextPassword()));

            email.setHostName(account.getEmailProvider().getSmtpConnection().getHost());
            email.setSmtpPort(account.getEmailProvider().getSmtpConnection().getPort());

            email.setSSLOnConnect(true);
            email.setFrom(account.getEmail());
            return this;
        }

        public Mail build() throws InvalidEmailFromException {
            if (this.mail.getEmail().getFromAddress() == null) {
                throw new InvalidEmailFromException();
            }
            return this.mail;
        }
    }

}
