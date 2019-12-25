package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 6678420965611108427L;

    private String from;

    private String message;

    public Message() {

    }

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }



}
