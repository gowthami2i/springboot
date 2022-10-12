package com.ideas2it.springboot.dao;

import com.ideas2it.springboot.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    List<Trainer> findByIsRemoved(boolean isRemoved);


}
