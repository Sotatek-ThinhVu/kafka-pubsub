package com.example.kafkapubsub.producer;

import com.example.kafkapubsub.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    @KafkaListener(topics = "${kafka.consumer.topics.user.name}",
            groupId = "${kafka.consumer.topics.user.group}",
            containerFactory = "userKafkaListenerFactory")
    public void consumeUser(ConsumerRecord<String, User> record) {
        User user = record.value();
        System.out.println("User name : " + user.getFullname());
    }
}
