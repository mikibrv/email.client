package com.miki.email.vo.account;

import java.io.Serializable;

/**
 * Created by miki on 08.03.2015.
 */
public final class AccountVO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String uuid;
    private String username;
    private String name;
    private EmailProviderVO emailProvider;


    AccountVO(){
    }

    AccountVO(String uuid){
        this.uuid=uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmailProviderVO getEmailProviderVO() {
        return emailProvider;
    }

    public void setEmailProviderVO(EmailProviderVO emailProviderVO) {
        this.emailProvider= emailProviderVO;
    }
}
