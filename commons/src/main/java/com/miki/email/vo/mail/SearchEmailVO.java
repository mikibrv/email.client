package com.miki.email.vo.mail;

import com.miki.email.vo.account.SessionVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by miki on 09.03.2015.
 */
public class SearchEmailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SessionVO session;
    private String searchString;
    private List<String> fromList;
    private List<String> toList;
    private EmailFolderVO emailFolder;
    private Long lastTimeSearched;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<String> getFromList() {
        return fromList;
    }

    public void setFromList(List<String> fromList) {
        this.fromList = fromList;
    }

    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
    }

    public EmailFolderVO getEmailFolder() {
        return emailFolder;
    }

    public void setEmailFolder(EmailFolderVO emailFolder) {
        this.emailFolder = emailFolder;
    }

    public Long getLastTimeSearched() {
        return lastTimeSearched;
    }

    public void setLastTimeSearched(Long lastTimeSearched) {
        this.lastTimeSearched = lastTimeSearched;
    }

    public SessionVO getSession() {
        return session;
    }

    public void setSession(SessionVO session) {
        this.session = session;
    }
}
