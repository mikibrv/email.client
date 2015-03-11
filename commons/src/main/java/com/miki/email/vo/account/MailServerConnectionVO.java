package com.miki.email.vo.account;

import java.io.Serializable;

/**
 * Created by miki on 10.03.2015.
 */
public final class MailServerConnectionVO implements Serializable {

    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
