package com.hellouniverse.demo.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hellouniverse.demo.data.model.Question;
import com.hellouniverse.demo.data.model.VoteRequest;
import com.hellouniverse.demo.data.repository.DemoRepository;
import com.hellouniverse.demo.exception.ResourceNotFoundException;

import lombok.NonNull;

public class DemoHandler {

    @Autowired
    private DemoRepository demoRepository;

    public Question createQuestion(@NonNull final Question inputQuestion) {
        inputQuestion.setVotes(new HashMap<>());
        return demoRepository.save(inputQuestion);
    }

    public Question getQuestionById(@NonNull final Long inputId) {
        return demoRepository.findById(inputId).orElseThrow(
            () -> new ResourceNotFoundException(String.format("Question not found for id %d", inputId)));
    }

    public List<Question> getAllQuestions() {
        return (List<Question>) demoRepository.findAll();
    }

    public Question vote(@NonNull final Long id, @NonNull final VoteRequest request) {
        final Question question = getQuestionById(id);
        final String user = request.getUserName();
        final int votingScore = request.getVotingScore();

        if(question.getVotes().containsKey(user)) {
            // throw an exception for duplication
        }

        question.getVotes().put(user, votingScore);
        final long currScore = question.getScore();
        question.setScore(currScore + votingScore);

        return demoRepository.save(question);
    }

   // public Question updateQuestion(@NonNull final Question inputQuestion, @NonNull final Long id) {
        //
    //}

    /* 
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

    public DemoEntity updateEntity(@NonNull final DemoEntity entity, @NonNull final Long id) {
        Optional<DemoEntity> dbrecordOptional = demoRepository.findById(id);

        if(!dbrecordOptional.isPresent()) {
            throw new ResourceNotFoundException(String.format("No Record found for id: %s", id));
        }
        DemoEntity dbRecord = dbrecordOptional.get();
        dbRecord.setName(entity.getName());
        dbRecord.setDescription(entity.getDescription());
        dbRecord.setSubEntities(entity.getSubEntities());

        return demoRepository.save(dbRecord);
    }

    public void deleteEntityById(@NonNull final Long entityId){
        demoRepository.deleteById(entityId);
    }
    */
}
