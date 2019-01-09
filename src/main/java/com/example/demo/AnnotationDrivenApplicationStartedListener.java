package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenApplicationStartedListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationDrivenApplicationStartedListener.class);

    @Async
    @EventListener(value = ApplicationStartedEvent.class)
    public void handleContextStart(ApplicationStartedEvent event) {
        LOGGER.info("Handling context started event.");
        LOGGER.info("Event class = '{}'", event.getClass());
    }
}
