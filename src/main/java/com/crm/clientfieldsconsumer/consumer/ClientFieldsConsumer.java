package com.crm.clientfieldsconsumer.consumer;

import com.crm.clientfieldsconsumer.dto.ClientFieldDTO;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class ClientFieldsConsumer {

    private static final Logger LOGGER = getLogger(ClientFieldsConsumer.class.getName());

    @KafkaListener(topics = {"field-created","field-deleted","field-updated"}, groupId = "client-fields-consumer")
    public void consume(ClientFieldDTO field){
        LOGGER.info(String.format("$$ -> Consumed Message -> %s",field.getName()));
    }
}