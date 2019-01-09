package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomEventListener.class);

    @Async
    @EventListener(value = CustomEvent.class)
    public void handleCustomEvent(CustomEvent customEvent) {
        LOGGER.info("Handling custom event.");
        LOGGER.info("Object = '{}'", customEvent.getSource());
    }
}
