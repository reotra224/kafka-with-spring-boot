package gn.traore.kafka.springwithkafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @KafkaListener(topics = "test1", groupId = "test-group-1")
    public void onMessage(ConsumerRecord<String, String> messageRecord) {
        System.out.println("==========================================================");
        System.out.println("Key => " + messageRecord.key() + " : " + "Value => " + messageRecord.value());
    }
}
