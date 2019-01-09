package com.example.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringApplicationEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationEventsApplication.class, args);
    }

    @Component
    static class CommandLineAppStartupRunner implements CommandLineRunner {
        private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
        private final CustomSpringEventPublisher customSpringEventPublisher;
        
        @Autowired
        CommandLineAppStartupRunner(final CustomSpringEventPublisher customSpringEventPublisher) {
            this.customSpringEventPublisher = customSpringEventPublisher;
        }
        
        @Override
        public void run(String...args) throws Exception {
            LOGGER.info("Application started with command-line arguments: {}.\nTo kill this application, press Ctrl + C.", Arrays.toString(args));
            customSpringEventPublisher.doStuffAndPublishAnEvent("This is custom message");
        }
    }
}

