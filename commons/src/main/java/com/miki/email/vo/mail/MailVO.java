package com.miki.email.vo.mail;

import com.miki.email.vo.account.SessionVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by miki on 09.03.2015.
 */
public class MailVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private SessionVO session;

    private String message;

    private String subject;

    private List<String> sendList;

    private List<String> ccList;

    private List<String> bccList;

    private EmailFolderVO emailFolder;

    public EmailFolderVO getEmailFolder() {
        return emailFolder;
    }

    public void setEmailFolder(EmailFolderVO emailFolder) {
        this.emailFolder = emailFolder;
    }

    public List<String> getBccList() {
        return bccList;
    }

    public void setBccList(List<String> bccList) {
        this.bccList = bccList;
    }

    public List<String> getCcList() {
        return ccList;
    }

    public void setCcList(List<String> ccList) {
        this.ccList = ccList;
    }

    public List<String> getSendList() {
        return sendList;
    }

    public void setSendList(List<String> sendList) {
        this.sendList = sendList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SessionVO getSession() {
        return session;
    }

    public void setSession(SessionVO session) {
        this.session = session;
    }
}
