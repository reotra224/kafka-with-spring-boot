package gn.traore.kafka.springwithkafka.config;

import gn.traore.kafka.springwithkafka.model.Employe;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConfig {

    @Bean
    ConsumerFactory<String, Employe> consumerFactory() {
        Map<String, String> configConsumer = new HashMap<>();
        configConsumer.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configConsumer.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group-1");
        JsonDeserializer<Employe> jsonDeserializer = new JsonDeserializer<>(Employe.class);
        jsonDeserializer.setUseTypeHeaders(false);
        return new DefaultKafkaConsumerFactory(configConsumer, new StringDeserializer() , jsonDeserializer);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, Employe> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Employe> kafkaListenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return kafkaListenerContainerFactory;
    }

    @Bean
    ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProducer = new HashMap<>();
        configProducer.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configProducer.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProducer.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProducer);
    }

    @Bean
    KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
