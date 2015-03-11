package com.miki.email.domain.model.account;

/**
 * Created by miki on 10.03.2015.
 */
public abstract class DefaultEmailProviders {

    public static final EmailProvider GMAIL;
    public static final EmailProvider SOFTENRO;

    static {
        EmailProvider tmp = null;
        try {
            tmp = new EmailProvider.Builder()
                    .withSMTP("smtp.gmail.com", 465)
                    .withIMAP("imap.gmail.com", 993)
                    .withName("GMAIL")
                    .build();
        } catch (Exception e) {
            //this will never happen
        }
        GMAIL = tmp;


        try {
            tmp = new EmailProvider.Builder()
                    .withSMTP("mail.softwareengineer.ro", 587)
                    .withIMAP("mail.softwareengineer.ro", 143)
                    .withName("SoftwareEngineerRO")
                    .build();
        } catch (Exception e) {
            //this will never happen
        }
        SOFTENRO = tmp;
    }

}
