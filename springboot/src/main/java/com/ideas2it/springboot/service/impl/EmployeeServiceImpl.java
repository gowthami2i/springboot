package com.ideas2it.springboot.service.impl;

import com.ideas2it.springboot.dao.TraineeRepository;
import com.ideas2it.springboot.dao.TrainerRepository;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>EmployeeServiceImpl</h1>
 * <p>
 * The EmployeeServiceImpl class is used to collect the returning object from EmployeeController
 * and send to the EmployeeDeoImpl class and vise versa
 *
 * @author Gowtham P
 * @version java 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired private TrainerRepository trainerRepository;
    @Autowired private TraineeRepository traineeRepository;

    /**
     * method is used to add Trainer
     *
     * @param {@link String} employeeId
     * @param {@link Trainer} trainer Object
     * @return {@link }
     */
    @Override
    public boolean addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return true;
    }
    @Override
    public boolean addTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
        return true;
    }

    @Override
    public List<Trainer> getAllTrainer() {
        return trainerRepository.findAll();
    }
    @Override
    public List<Trainee> getAllTrainee() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainer getTrainer(int id) {
        return trainerRepository.findById(id).get();
    }
    @Override
    public Trainee getTrainee(int id) {
        return traineeRepository.findById(id).get();
    }

    @Override
    public Trainer updatedTrainerDetails(Trainer trainer) {
         return trainerRepository.save(trainer);
    }
    @Override
    public Map<String, Object> getTrainerObject(Trainer trainer) {
        List<Map<String, Object>> trainee = new ArrayList<>();
        List<Trainee> list = trainer.getTraineeDetails();

        for (Trainee traineeList : list) {
            Map<String, Object> listTrainee = new HashMap<>();
            listTrainee.put("traineeId", traineeList.getId());
            listTrainee.put("Trainee Name", traineeList.getFirstName());
            trainee.add(listTrainee);

        }
        Map<String, Object> map = new HashMap<>();
        map.put("trainerId", trainer.getId());
        map.put("TrainerName", trainer.getFirstName());
        map.put("Trainer email", trainer.getEmail());
        map.put("Trainer Blood Group", trainer.getBloodGroup());
        map.put("Trainer Pancard", trainer.getPanCard());
        map.put("Trainer Mobile Number", trainer.getMobileNumber());

        map.put("trainees", trainee);
        return map;
    }

    //public String (int id) {
    //  repository.deleteById(id);
    //return"true";
    // }
}
