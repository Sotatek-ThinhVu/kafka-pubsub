package com.example.kafkapubsub.producer;

import com.example.kafkapubsub.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProducerService {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value("${kafka.user.topicName}")
    private String topicName ;

    public void producerUser(User user){
        ProducerRecord<String,User> producerRecord = new ProducerRecord<>(topicName,user);
        System.out.println("Receive: " +user);
        kafkaTemplate.send(producerRecord);
    }
}
