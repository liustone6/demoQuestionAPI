package com.hellouniverse.demo.handler;

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

    public DemoEntity getEntityById(@NonNull final String id) {
        return demoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(String.format("No Record found for id: %s", id)));
    }
}
