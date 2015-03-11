package com.miki.email.domain.model.account;

import com.miki.email.domain.model.Entity;
import com.miki.email.domain.model.account.exceptions.InvalidAccountException;
import com.miki.email.domain.model.account.specifications.PasswordSecurity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * Created by miki on 09.03.2015.
 */
public class Account implements Entity<Account> {

    private String email;
    private String password;
    private EmailProvider emailProvider;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPlainTextPassword() {
        return new PasswordSecurity().decrypt(this.password);
    }

    public EmailProvider getEmailProvider() {
        return emailProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return this.sameIdentityAs(account);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getEmail())
                .append(this.getEmailProvider())
                .hashCode();
    }

    @Override
    public boolean sameIdentityAs(Account other) {
        return other != null && new EqualsBuilder()
                .append(this.getEmail(), other.getEmail())
                .append(this.getEmailProvider(), other.getEmailProvider())
                .build();
    }

    public static class Builder {
        private Account account;

        public Builder() {
            this.account = new Account();
        }

        public Builder withEmail(String email) {
            this.account.email = email;
            return this;
        }

        public Builder withPlainTextPassword(String password) {
            this.account.password = new PasswordSecurity().encrypt(password);
            return this;
        }

        public Builder withEncryptedPassword(String password) {
            this.account.password = password;
            return this;
        }

        public Builder withProvider(EmailProvider emailProvider) {
            this.account.emailProvider = emailProvider;
            return this;
        }

        public Account build() throws InvalidAccountException {
            //don't forget to do validation
            if (!EmailValidator.getInstance().isValid(this.account.getEmail())) {
                throw new InvalidAccountException(this.account.getEmail());
            }
            if (!StringUtils.isNotEmpty(this.account.getPassword())) {
                throw new InvalidAccountException();
            }
            if (this.account.getEmailProvider() == null) {
                throw new InvalidAccountException(this.account.getEmailProvider());
            }

            return this.account;
        }
    }
}
