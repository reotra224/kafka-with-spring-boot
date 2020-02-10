package gn.traore.kafka.springwithkafka.web.rest;

import gn.traore.kafka.springwithkafka.model.Employe;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/send/{message}/{topic}")
    public String send(@PathVariable String message,
                       @PathVariable String topic) {
        kafkaTemplate.send(new ProducerRecord<>(topic, topic, message));
        return "Message send...";
    }

    @GetMapping("/publish/{name}/{topic}")
    public String publish(@PathVariable String name,
                       @PathVariable String topic) {
        kafkaTemplate.send(new ProducerRecord<>(topic, topic, new Employe(name, "Informatique", 150.0)));
        return "Employee send...";
    }
}
