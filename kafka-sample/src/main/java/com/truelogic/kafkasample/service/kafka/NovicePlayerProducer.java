package com.truelogic.kafkasample.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.truelogic.kafkasample.domain.Player;

@Service
public class NovicePlayerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(NovicePlayerProducer.class);

    @Value("${kafka.topic.novice-players}")
    private String topic;
    
    @Autowired
    private KafkaTemplate<String, Player> kafkaTemplate;

    public void send(Player data){
    	LOGGER.info("Sending data='{}' to topic='{}'", data, topic);
    	
        Message<Player> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        
        kafkaTemplate.send(message);
    }
}
