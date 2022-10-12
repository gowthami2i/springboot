package com.ideas2it.springboot.dao;

import com.ideas2it.springboot.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

    List<Trainee> findByIsRemoved(boolean isRemoved);
}
