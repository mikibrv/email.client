package com.miki.email.domain.model.account.validators;

import com.miki.email.domain.model.Validator;
import com.miki.email.domain.model.account.EmailProvider;
import com.miki.email.domain.model.account.exceptions.MissingEmailProviderConnection;

/**
 * Created by miki on 10.03.2015.
 */
public class EmailProviderValidator implements Validator<EmailProvider> {


    @Override
    public void validate(EmailProvider provider) throws MissingEmailProviderConnection {
        if (provider.getImapConnection() == null && provider.getPop3Connection() == null) {
            throw new MissingEmailProviderConnection();
        }
        if (provider.getSmtpConnection() == null) {
            throw new MissingEmailProviderConnection();
        }
    }
}
