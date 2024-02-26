package com.hellouniverse.demo.data.model;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "createdBy")
    private String userName;
    @Column(name = "score")
    private Long score;
    @Column(name = "votes")
    private Map<String, Integer> votes;


    @Column(name = "answers")
    private List<String> answers;  // TODO: create Answer entity

}
