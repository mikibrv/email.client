package com.miki.email.domain.email;

import com.miki.email.domain.model.account.Account;
import com.miki.email.domain.model.account.DefaultEmailProviders;
import com.miki.email.domain.model.account.exceptions.InvalidAccountException;
import com.miki.email.domain.model.mail.Mail;
import com.miki.email.domain.model.mail.exceptions.InvalidEmailFromException;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by miki on 10.03.2015.
 */
public class EmailSenderTesT {


    @Test
    public void testEmailSendWithGmail() throws InvalidAccountException, EmailException, InvalidEmailFromException {

        Account account = new Account.Builder()
                .withEmail("p5.mcsere@gmail.com")
                .withEncryptedPassword("dXJzdWxldGlp")
                .withProvider(DefaultEmailProviders.GMAIL)
                .build();
        assertNotNull(account);

        Email email = new Mail.Builder()
                .usingAccount(account)
                .build()
                .getEmail();

        email.addTo("mcsere@pentalog.fr");
        email.setSubject("test");
        email.setMsg("<html>Dude! Test!</html>");
        email.send();
    }

}
