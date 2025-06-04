//package com.neliomscv.hrworker.listeners;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.neliomscv.hrworker.entities.Worker;
//import com.neliomscv.hrworker.repositories.WorkerRepository;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WorkerEventListener {
//
//    private final WorkerRepository workerRepository;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public WorkerEventListener(WorkerRepository workerRepository) {
//        this.workerRepository = workerRepository;
//    }
//
//    @KafkaListener(topics = "worker-events", groupId = "hr-worker-group")
//    public void handleWorkerEvent(String message) throws JsonProcessingException {
//        Worker worker = objectMapper.readValue(message, Worker.class);
//        workerRepository.save(worker);
//        System.out.println("Worker salvo no banco: " + worker.getName());
//    }
//}
