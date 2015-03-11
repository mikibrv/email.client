package com.miki.email.domain.email;

import com.miki.email.domain.model.account.Account;
import com.miki.email.domain.model.account.DefaultEmailProviders;
import org.junit.Test;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

/**
 * Created by miki on 10.03.2015.
 */
public class ReceiveEmailTest {

    @Test
    public void testEmailReceiveWithGmail() throws Exception {

        Account account = new Account.Builder()
                .withEmail("test@softwareengineer.ro")
                .withPlainTextPassword("test1234")
                .withProvider(DefaultEmailProviders.SOFTENRO)
                .build();
        assertNotNull(account);

        Folder folder = null;
        Store store = null;
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        // session.setDebug(true);[Gmail]/Sent Mail
        store = session.getStore("imaps");
        store.connect(account.getEmailProvider().getImapConnection().getHost(),
                account.getEmail(), account.getPlainTextPassword());
        folder = store.getFolder("Inbox");

        folder.open(Folder.READ_WRITE);
        Message messages[] = folder.getMessages();

        assertNotNull(messages);

        System.out.println("No of Messages : " + folder.getMessageCount());
        System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
        Message message = messages[0];
        message.getContent().toString();
        System.out.println(message.getSubject());
        message.getSentDate();
    }
}
