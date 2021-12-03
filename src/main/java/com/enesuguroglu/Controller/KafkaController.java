package com.enesuguroglu.Controller;

import com.enesuguroglu.Model.IncomingMessage;
import com.enesuguroglu.Services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage message){

        kafkaProducer.sendMessage(message.getTopic(), message.getKey(), message.getValue());
        return String.format("Success -Message for key %s is sent to Kafka Topic: %s",
                message.getKey(), message.getTopic());
    }
}
