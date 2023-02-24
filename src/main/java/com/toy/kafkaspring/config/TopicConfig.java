package com.toy.kafkaspring.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value("${kafka.topic.dto.name}")
    public String dtoName;
    @Value("${kafka.topic.dto.partitions}")
    public int dtoPartitions;
    @Value("${kafka.topic.dto.replicas}")
    public int dtoReplicas;


    @Value("${kafka.topic.string.name}")
    public String stringName;
    @Value("${kafka.topic.string.partitions}")
    public int stringPartitions;
    @Value("${kafka.topic.string.replicas}")
    public int stringReplicas;

    @Bean
    public NewTopic stringTopic() {
        return topicBuilder(stringName, stringPartitions, stringReplicas);
    }

    @Bean
    public NewTopic dtoTopic() {
        return topicBuilder(dtoName, dtoPartitions, dtoReplicas);
    }

    public NewTopic topicBuilder(String name, int partitions, int replicas) {
        return TopicBuilder.name(name)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }

}
