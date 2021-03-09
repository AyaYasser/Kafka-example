package com.hr.repository.impl;

import com.hr.repository.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.IOException;

@Service
public class KafkaServiceImpl implements KafkaService {

    private static final String TOPIC = "employees";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message,String employeeId) {
        System.out.println(String.format("#### -> Producing message -> %s", message));
        ListenableFuture<SendResult<String, String>> record= this.kafkaTemplate.send(TOPIC,employeeId, message);
        System.out.println(String.format("#### -> After Producing message -> %s", message));
    }

    @Override
    @KafkaListener(topics = TOPIC ,groupId = TOPIC)
    public void consume(String message,String employeeId)  {
        System.out.println(String.format("#### -> Consumed message -> %s", message));
    }
}
