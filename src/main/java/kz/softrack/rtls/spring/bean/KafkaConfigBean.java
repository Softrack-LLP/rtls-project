package kz.softrack.rtls.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.KafkaContainer;

import javax.annotation.PreDestroy;

/**
 * Created by aigerim on 11/3/18.
 */
@Service
public class KafkaConfigBean {

    private KafkaContainer kafkaContainer;

    @Autowired
    public KafkaConfigBean() {
        kafkaContainer = new KafkaContainer();
        kafkaContainer.start();
    }

    public KafkaContainer getInstance() {
        return kafkaContainer;
    }

    @PreDestroy
    public void close() {
        kafkaContainer.stop();
    }

}
