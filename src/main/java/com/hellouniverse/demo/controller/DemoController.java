package com.hellouniverse.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellouniverse.demo.data.model.DemoEntity;
import com.hellouniverse.demo.handler.DemoHandler;

@RestController
public class DemoController {

    @Autowired
    private DemoHandler demoHandler;

    /* 
    @RequestMapping("/demo")
    public String demo() {
        return demoHandler.handle();
    }
    */

    @GetMapping("/demo/{id}")
    public DemoEntity getEntityById(@PathVariable final Long id) {
        return demoHandler.getEntityById(id);
    }

    @GetMapping("/demo")
    public List<DemoEntity> listEntities() {
        return demoHandler.listEntities();
    }

    @PostMapping("/demo")
    public DemoEntity saveEntity(@RequestBody DemoEntity demoEntity) {
        return demoHandler.saveEntity(demoEntity);
    }

    @DeleteMapping("/demo/{id}")
    public String deleteEntityById(@PathVariable("id") Long entityId) {
        demoHandler.deleteEntityById(entityId);
        return "Deleted Successfully";
    }
}
