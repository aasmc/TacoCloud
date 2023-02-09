package ru.aasmc.tacocloud.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderSubmitMessageHandler implements GenericHandler<EmailOrder> {
    private final RestTemplate rest;
    private final ApiProperties apiProps;

    @Autowired
    public OrderSubmitMessageHandler(RestTemplate rest, ApiProperties apiProps) {
        this.rest = rest;
        this.apiProps = apiProps;
    }

    @Override
    public Object handle(EmailOrder payload, MessageHeaders headers) {
        rest.postForObject(apiProps.getUrl(), payload, String.class);
        return null;
    }
}
