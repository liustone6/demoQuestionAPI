package com.hellouniverse.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellouniverse.demo.data.model.DemoEntity;
import com.hellouniverse.demo.handler.DemoHandler;

@RestController
public class DemoController {

    @Autowired
    private DemoHandler demoHandler;

    @RequestMapping("/demo")
    public String demo() {
        return demoHandler.handle();
    }

    @GetMapping("/demo/{id}")
    public DemoEntity getEntityById(@PathVariable final String id) {
        return demoHandler.getEntityById(id);
    }
}
