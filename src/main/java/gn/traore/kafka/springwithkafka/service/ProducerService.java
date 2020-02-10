package gn.traore.kafka.springwithkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import gn.traore.kafka.springwithkafka.model.Employe;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @KafkaListener(topics = "test5", groupId = "test-group-1")
    public void onMessage(ConsumerRecord<String, Employe> messageRecord) {
        // Employe employe = getEmploye(messageRecord.value());
        System.out.println("==========================================================");
        System.out.println("Key => " + messageRecord.key() + " : " + "Value => " + messageRecord.value());
    }

    private Employe getEmploye(String jsonEmploye) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(jsonEmploye, Employe.class);
    }
}
