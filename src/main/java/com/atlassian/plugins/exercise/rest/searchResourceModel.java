package com.atlassian.plugins.exercise.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class searchResourceModel {

    @XmlElement(name = "value")
    private String message;
    @XmlAttribute
    private String key;

    public searchResourceModel() {
    }

    public searchResourceModel(String key, String message) {
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}