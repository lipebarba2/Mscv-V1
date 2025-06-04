package com.neliomscv.hrworker.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neliomscv.hrworker.entities.Worker;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public WorkerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void notifyWorkerChange(Worker worker) throws JsonProcessingException {
        String message = new ObjectMapper().writeValueAsString(worker);

        kafkaTemplate.send("worker-events", message);

    }
}
