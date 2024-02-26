package com.hellouniverse.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.hellouniverse.demo.data.model.Question;

public interface DemoRepository extends CrudRepository<Question, Long> {

}
