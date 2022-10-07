package com.ideas2it.springboot.dao;

import com.ideas2it.springboot.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

}
