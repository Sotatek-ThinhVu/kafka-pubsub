package com.example.kafkapubsub.controller;

import com.example.kafkapubsub.model.User;
import com.example.kafkapubsub.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("")
    public ResponseEntity<String> producerUserToKafka(@RequestBody User user){
        producerService.producerUser(user);
        return ResponseEntity.ok("OKKEY");
    }
}
