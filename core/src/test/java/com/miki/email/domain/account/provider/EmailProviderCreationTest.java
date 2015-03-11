package com.miki.email.domain.account.provider;

import com.miki.email.domain.model.account.EmailProvider;
import com.miki.email.domain.model.account.exceptions.InvalidConnectionParamException;
import com.miki.email.domain.model.account.exceptions.MissingEmailProviderConnection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by miki on 10.03.2015.
 */
public class EmailProviderCreationTest {

    @Test
    public void createAValidConnection() throws Exception {
        EmailProvider emailProvider = new EmailProvider.Builder()
                .withName("pentalog")
                .withIMAP("imap.pentalog.fr", 21)
                .withSMTP("smpt.pentalog.fr", 587)
                .build();

        assertNotNull(emailProvider);
    }

    @Test(expected = MissingEmailProviderConnection.class)
    public void test_MissingEmailProviderConnection() throws Exception {

        new EmailProvider.Builder()
                .withName("pentalog")
                .withIMAP("imap.pentalog.fr", 21)
                .build();
    }

    @Test(expected = InvalidConnectionParamException.class)
    public void test_InvalidConnectionParamException() throws Exception {

        new EmailProvider.Builder()
                .withName("pentalog")
                .withIMAP("imap.pentalog.fr", 0)    // -->this is invalid
                .withSMTP("smpt.pentalog.fr", 587)
                .build();
    }


}
