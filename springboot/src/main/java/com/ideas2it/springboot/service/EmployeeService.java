package com.ideas2it.springboot.service;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;

import java.util.List;
import java.util.Map;

/**
 * <h1>EmployeeServiceImpl</h1>
 *
 * collects the returning object from EmployeeController
 * and send to the EmployeeDeoImpl class and vise versa
 *
 *
 * @author  Gowtham P
 * @version java 1.0
 *
 */
public interface EmployeeService {

    /**
     * method is used to add Trainer
     * @param {@link String} employeeId
     * @param {@link Trainer} trainer Object
     * @return {@link  }
     */
    boolean addTrainer(Trainer trainer);

    boolean addTrainee(Trainee trainee);

    List<Trainer> getAllTrainer();

    List<Trainee> getAllTrainee();

    Trainer getTrainer(int id);

    Trainee getTrainee(int id);
    Trainer updatedTrainerDetails(Trainer trainer);

    Map<String, Object> getTrainerObject(Trainer trainer);

    //  String deleteTrainerById(int id);
}
