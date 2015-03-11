package com.miki.email.domain.model.account;

import com.miki.email.domain.model.Entity;
import com.miki.email.domain.model.account.exceptions.InvalidConnectionParamException;
import com.miki.email.domain.model.account.exceptions.MissingEmailProviderConnection;
import com.miki.email.domain.model.account.validators.EmailProviderValidator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by miki on 10.03.2015.
 */
public class EmailProvider implements Entity<EmailProvider> {


    private String name;
    private EmailProviderConnection smtpConnection;
    private EmailProviderConnection pop3Connection;
    private EmailProviderConnection imapConnection;

    public String getName() {
        return name;
    }

    public EmailProviderConnection getSmtpConnection() {
        return smtpConnection;
    }

    public EmailProviderConnection getPop3Connection() {
        return pop3Connection;
    }

    public EmailProviderConnection getImapConnection() {
        return imapConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailProvider that = (EmailProvider) o;

        return this.sameIdentityAs(that);
    }

    @Override
    public int hashCode() {
        return
                new HashCodeBuilder()
                        .append(this.getName())
                        .hashCode();
    }

    @Override
    public boolean sameIdentityAs(EmailProvider other) {
        return other != null &&
                new EqualsBuilder()
                        .append(this.getName(), other.getName())
                        .build();
    }

    public static class Builder {

        private EmailProvider emailProvider;

        public Builder() {
            this.emailProvider = new EmailProvider();
        }

        public Builder withName(String name) {
            this.emailProvider.name = name;
            return this;
        }

        public Builder withSMTP(String host, Integer port) throws InvalidConnectionParamException {
            this.emailProvider.smtpConnection = new EmailProviderConnection.Builder()
                    .withHost(host)
                    .withPort(port)
                    .build();
            return this;
        }

        public Builder withPOP3(String host, Integer port) throws InvalidConnectionParamException {
            this.emailProvider.pop3Connection = new EmailProviderConnection.Builder()
                    .withHost(host)
                    .withPort(port)
                    .build();
            return this;
        }

        public Builder withIMAP(String host, Integer port) throws InvalidConnectionParamException {
            this.emailProvider.imapConnection = new EmailProviderConnection.Builder()
                    .withHost(host)
                    .withPort(port)
                    .build();
            return this;
        }

        public EmailProvider build() throws MissingEmailProviderConnection {
            new EmailProviderValidator().validate(this.emailProvider);
            return this.emailProvider;
        }
    }
}
