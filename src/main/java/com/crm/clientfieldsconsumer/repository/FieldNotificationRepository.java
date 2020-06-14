package com.crm.clientfieldsconsumer.repository;

import com.crm.clientfieldsconsumer.entity.FieldNotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FieldNotificationRepository extends MongoRepository<FieldNotificationEntity, String> {
}
