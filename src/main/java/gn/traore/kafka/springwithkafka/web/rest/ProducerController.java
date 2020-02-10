package gn.traore.kafka.springwithkafka.web.rest;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send/{message}/{topic}")
    public String send(@PathVariable String message,
                       @PathVariable String topic) {
        kafkaTemplate.send(new ProducerRecord<>(topic, topic, message));
        return "Message send...";
    }

    /*@GetMapping("/publish/{page}/{topic}")
    public String publish(@PathVariable String page,
                       @PathVariable String topic) {
        kafkaTemplate.send(new ProducerRecord<>(topic, topic, message));
        return "Message send...";
    }*/
}
