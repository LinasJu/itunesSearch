package com.atlassian.plugins.exercise.rest;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
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
}