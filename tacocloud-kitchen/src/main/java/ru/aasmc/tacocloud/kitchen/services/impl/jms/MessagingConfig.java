package ru.aasmc.tacocloud.kitchen.services.impl.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import ru.aasmc.tacocloud.kitchen.model.TacoOrder;

import java.util.HashMap;

@Profile({"jms-listener", "jms-template"})
@Configuration
public class MessagingConfig {

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        HashMap<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("order", TacoOrder.class);
        converter.setTypeIdMappings(typeIdMappings);
        return converter;
    }

}
