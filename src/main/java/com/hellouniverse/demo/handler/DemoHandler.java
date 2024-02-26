package com.hellouniverse.demo.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hellouniverse.demo.data.model.DemoEntity;
import com.hellouniverse.demo.data.repository.DemoRepository;
import com.hellouniverse.demo.exception.ResourceNotFoundException;

import lombok.NonNull;

public class DemoHandler {

    @Autowired
    private DemoRepository demoRepository;

    public String handle() {
        System.out.println("handle request using DemoHandler.");
        return "Hello Universe!";
    }

    public DemoEntity getEntityById(@NonNull final Long id) {
        return demoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("No Record found for id: %s", id)));
    }

    public List<DemoEntity> listEntities() {
        return (List<DemoEntity>) demoRepository.findAll();
    }

    public DemoEntity saveEntity(@NonNull final DemoEntity entity) {
        return demoRepository.save(entity);
    }

    public void deleteEntityById(@NonNull final Long entityId){
        demoRepository.deleteById(entityId);
    }
}
