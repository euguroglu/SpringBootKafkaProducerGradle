package com.enesuguroglu.Model;

import lombok.Data;

@Data
public class IncomingMessage {

    private String topic;
    private String key;
    private String value;
}
