package com.miki.email.vo;

import java.io.Serializable;

/**
 * Created by miki on 09.03.2015.
 */
public class NotificationVO implements Serializable{

    private int status;
    private String message;

    public static final NotificationVO SUCCESS = new NotificationVO(200,"Operation done!");
    public static final NotificationVO ERROR = new NotificationVO(500,"Operation crashed!");


    public NotificationVO(int status, String message) {
        this.status=status;
        this.message=message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationVO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}