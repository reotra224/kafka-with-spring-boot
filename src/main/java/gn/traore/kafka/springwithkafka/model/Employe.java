package gn.traore.kafka.springwithkafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Employe implements Serializable {
    private String name;
    private String departement;
    private Double salary;
}
