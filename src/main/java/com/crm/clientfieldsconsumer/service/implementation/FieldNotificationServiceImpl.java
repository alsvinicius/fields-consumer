package com.crm.clientfieldsconsumer.service.implementation;

import com.crm.clientfieldsconsumer.entity.FieldNotificationEntity;
import com.crm.clientfieldsconsumer.repository.FieldNotificationRepository;
import com.crm.clientfieldsconsumer.service.FieldNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldNotificationServiceImpl implements FieldNotificationService {

    @Autowired
    private FieldNotificationRepository repository;

    @Override
    public FieldNotificationEntity create(FieldNotificationEntity field) {
        FieldNotificationEntity created = repository.save(field);

        return created;
    }
}
