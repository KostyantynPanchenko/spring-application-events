package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSpringEventPublisher.class);
    private final ApplicationEventPublisher applicationEventPublisher;
    
    public CustomSpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    public void doStuffAndPublishAnEvent(final String message) {
        LOGGER.info("Publishing custom event. ");
        CustomEvent customSpringEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    @Override
    public String toString() {
        return "*** CustomSpringEventPublisher ***";
    }
}
