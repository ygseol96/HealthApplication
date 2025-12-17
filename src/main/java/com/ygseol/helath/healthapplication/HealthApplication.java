package com.ygseol.helath.healthapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthApplication {
         final static Logger logger = LoggerFactory.getLogger(HealthApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);
        logger.info("Application Started!!!!");

    }

}
