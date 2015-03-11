package com.miki.email.domain.account;

import com.miki.email.domain.model.account.Account;
import com.miki.email.domain.model.account.EmailProvider;
import com.miki.email.domain.model.account.exceptions.InvalidAccountException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by miki on 10.03.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountCreationTest {

    Account.Builder accountBuilder;

    @Mock
    EmailProvider.Builder emailProviderBuilder;

    @Before
    public void setUP() throws Exception {
        this.accountBuilder = new Account.Builder();

        when(emailProviderBuilder.build()).
                thenReturn(
                        new EmailProvider.Builder()
                                .withName("test")
                                .withIMAP("imap.pentalog.fr", 21)
                                .withSMTP("smtp.pentalog.fr", 587)
                                .build()
                );
    }

    @After
    public void tearDown() {
        this.emailProviderBuilder = null;
        this.accountBuilder = null;
    }

    @Test
    public void testOKAccountCreation() throws Exception {
        Account account = new Account.Builder()
                .withEmail("test@ceva.com")
                .withEncryptedPassword("ceva")
                .withProvider(
                        emailProviderBuilder.build())
                .build();
        assertNotNull(account);
        assertEquals(account.getEmail(), "test@ceva.com");
    }

    @Test(expected = InvalidAccountException.class)
    public void test_InvalidAccountException() throws InvalidAccountException {

        new Account.Builder()
                .withEmail("wrong email")
                .build();
    }

}
