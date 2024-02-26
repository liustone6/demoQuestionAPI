package com.hellouniverse.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellouniverse.demo.data.model.Question;
import com.hellouniverse.demo.data.model.VoteRequest;
import com.hellouniverse.demo.handler.DemoHandler;

@RestController
public class DemoController {

    @Autowired
    private DemoHandler demoHandler;

    /**
     * Create API
     */
    @PutMapping("/questions")
    public Question createQuestion(@RequestBody Question inputQuestion) {
        //TODO: define a request data type
        // handler to create the entity in DB
        //TODO: logging / metrics
        return demoHandler.createQuestion(inputQuestion);
    }


     /**
      * Get API
    */
    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable("id") Long id) {
        return demoHandler.getQuestionById(id);
    }

    /**
     * List API
     */
    @GetMapping("/questions")
    public List<Question> listQuestions() {
        return demoHandler.getAllQuestions();
    }

    /**
     * update API
     */
    //@PostMapping("/questions/{id}/vote")
    //public Question voteForQuestion(@PathVariable)

    // vote API
    @PostMapping("/questions/{id}/vote") 
    public Question voteForQuestion(@PathVariable("id") Long id, @RequestBody VoteRequest voteRequest) {
        return demoHandler.vote(id, voteRequest);
    }
    



/**

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

    @PutMapping("/demo/{id}")
    public DemoEntity updateEntity(@RequestBody DemoEntity demoEntity, @PathVariable("id") Long entityId) {
        return demoHandler.updateEntity(demoEntity, entityId);
    }

    @DeleteMapping("/demo/{id}")
    public String deleteEntityById(@PathVariable("id") Long entityId) {
        demoHandler.deleteEntityById(entityId);
        return "Deleted Successfully";
    }
    */
}
