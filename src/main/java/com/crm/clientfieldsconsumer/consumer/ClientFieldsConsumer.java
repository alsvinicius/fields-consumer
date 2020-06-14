package com.crm.clientfieldsconsumer.consumer;

import com.crm.clientfieldsconsumer.dto.ClientFieldDTO;
import com.crm.clientfieldsconsumer.entity.FieldNotificationEntity;
import com.crm.clientfieldsconsumer.service.FieldNotificationService;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class ClientFieldsConsumer {

    @Autowired
    private FieldNotificationService fieldNotificationService;

    private static final Logger LOGGER = getLogger(ClientFieldsConsumer.class.getName());

    @KafkaListener(topics = {"field-created","field-deleted","field-updated"}, groupId = "client-fields-consumer")
    public void consume (
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(required = false, name= KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            @Payload(required = false) ClientFieldDTO field
    ){
        FieldNotificationEntity notification = new FieldNotificationEntity();
        notification.setFieldName(field.getName());
        notification.setOperation(topic.substring(topic.indexOf("-") + 1));
        fieldNotificationService.create(notification);

        LOGGER.info(String.format("$$ -> Consumed Message -> %s",field.getName()));
    }
}