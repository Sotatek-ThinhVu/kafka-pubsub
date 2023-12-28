package com.example.kafkapubsub.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MessageRequest {
    private String message;
    public String message(){
        return message;
    }
}
