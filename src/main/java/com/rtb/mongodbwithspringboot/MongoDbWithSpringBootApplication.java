package com.rtb.mongodbwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.rtb.mongodbwithspringboot.repository")
public class MongoDbWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbWithSpringBootApplication.class, args);
    }

}
