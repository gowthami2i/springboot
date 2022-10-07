package com.ideas2it.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * <h1>Trainee </h1>
 * Trainee class is an pojo class.
 * Creating Trainee Particular data in the program
 *
 * @author Gowtham P
 * @version java 1.0
 */
@Entity
@Table(name = "trainees")
public class Trainee extends Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "skill_set")
    private String skillSet;

    @Column(name = "no_Of_Task")
    private int task;


    //@ManyToMany(targetEntity = Trainer.class,cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @ManyToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Trainer> trainer;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getTask() {
        return task;
    }

    public void setTrainerDetails(List<Trainer> trainer) {
        this.trainer = trainer;
    }

    public List<Trainer> getTrainerDetails() {
        return trainer;
    }


}