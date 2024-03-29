package com.hellouniverse.demo.data.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entity_id")
    private Long id;
    @Column(name = "entity_name")
    private String name;
    @Column(name = "entity_discription")
    private String description;

    @OneToMany(mappedBy = "entity")
    private List<DemoSubEntity> subEntities;
}
