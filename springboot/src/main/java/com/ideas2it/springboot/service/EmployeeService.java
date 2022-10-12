package com.ideas2it.springboot.service;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;

import java.util.List;
import java.util.Map;

/**
 * <h1>EmployeeServiceImpl</h1>
 * <p>
 * collects the returning object from EmployeeController
 * and send to the EmployeeDeoImpl class and vise versa
 *
 * @author Gowtham P
 * @version java 1.0
 */
public interface EmployeeService {

    /**
     * method is used to add Trainer
     *
     * @param {@link String} employeeId
     * @param {@link Trainer} trainer Object
     * @return {@link  }
     */

    Trainer addTrainer(TrainerDto trainerDto);

    Trainee addTrainee(TraineeDto traineeDto);

    List<TrainerDto> getAllTrainer() throws EmployeeNotFoundException;

    List<TraineeDto> getAllTrainee() throws EmployeeNotFoundException;

    Trainer getTrainer(int id) throws EmployeeNotFoundException;

    Trainee getTrainee(int id) throws EmployeeNotFoundException;

    Trainer updatedTrainerDetails(Trainer trainer);

    Trainee updatedTraineeDetails(Trainee trainee);

    Trainer deleteTrainerById(int trainerId) throws EmployeeNotFoundException;

    Map<String, Object> getTrainerObject(Trainer trainer);


    Map<String, Object> getTraineeObject(Trainee trainee);




    Trainee deleteTraineeById(int id)throws EmployeeNotFoundException;

    boolean getTraineeId(int id);

    boolean getTrainerId(int id);
}
