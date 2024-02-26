package com.hellouniverse.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.hellouniverse.demo.data.model.DemoEntity;

public interface DemoRepository extends CrudRepository<DemoEntity, Long> {

}
