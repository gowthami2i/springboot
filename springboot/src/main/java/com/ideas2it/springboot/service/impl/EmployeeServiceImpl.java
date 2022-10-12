package com.ideas2it.springboot.service.impl;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.Helper.TraineeHelper;
import com.ideas2it.springboot.Helper.TrainerHelper;
import com.ideas2it.springboot.dao.TraineeRepository;
import com.ideas2it.springboot.dao.TrainerRepository;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TraineeRepository traineeRepository;

    /**
     * method is used to add Trainer
     *
     * @param {@link String} employeeId
     * @param {@link Trainer} trainer Object
     * @return {@link }
     */
    @Override
    public Trainer addTrainer(TrainerDto trainerDto) {
        Trainer trainer = TrainerHelper.trainerDtoToTrainer(trainerDto);
        return trainerRepository.save(trainer);

    }

    @Override
    public Trainee addTrainee(TraineeDto traineeDto) {
        Trainee trainee = TraineeHelper.traineeDtoToTrainee(traineeDto);
        return traineeRepository.save(trainee);

    }

    @Override
    public List<TrainerDto> getAllTrainer() throws EmployeeNotFoundException {

        List<Trainer> trainers = trainerRepository.findByIsRemoved(false);
        if (trainers.isEmpty()) {
            throw new EmployeeNotFoundException("No Employee Found");
        } else {
            return trainers.stream().map(trainer -> TrainerHelper.trainerTOTrainerDto(trainer)).collect(Collectors.toList());
        }

    }

    @Override
    public List<TraineeDto> getAllTrainee() throws EmployeeNotFoundException {
        List<Trainee> trainees = traineeRepository.findByIsRemoved(false);
        if (trainees.isEmpty()) {
            throw new EmployeeNotFoundException("No Employee Found");
        } else {
            return trainees.stream().map(trainee -> TraineeHelper.traineeTOTraineeDto(trainee)).collect(Collectors.toList());
        }

    }

    @Override
    public Trainer getTrainer(int id) throws EmployeeNotFoundException {

        return trainerRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Trainer id not available"));

    }

    @Override
    public Trainee getTrainee(int id) throws EmployeeNotFoundException {

        return traineeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Trainee not found"));
    }

    @Override
    public Trainer updatedTrainerDetails(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    @Override
    public Trainee updatedTraineeDetails(Trainee trainee){
        return  traineeRepository.save(trainee);
    }

    @Override
    public Trainer deleteTrainerById(int trainerId) throws EmployeeNotFoundException {

        Trainer trainer = getTrainer(trainerId);
        trainer.setIsRemoved(true);
        return trainerRepository.save(trainer);

    }
    public Trainee deleteTraineeById(int id) throws EmployeeNotFoundException {
        Trainee trainee = getTrainee(id);
        trainee.setIsRemoved(true);
        return traineeRepository.save(trainee);

    }

    @Override
    public Map<String, Object> getTrainerObject(Trainer trainer) {
        List<Map<String, Object>> trainee = new ArrayList<>();
        Set<Trainee> list = trainer.getTraineeDetails();

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

    @Override
    public Map<String, Object> getTraineeObject(Trainee trainee) {
        List<Map<String, Object>> trainerList = new ArrayList<>();
        Set<Trainer> list = trainee.getTrainerDetails();
        for (Trainer trainer : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("TrainerId", trainer.getId());
            map.put("TrainerName", trainer.getFirstName());
            trainerList.add(map);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("traineeId", trainee.getId());
        map.put("TraineeName", trainee.getFirstName());
        map.put("Trainee email", trainee.getEmail());
        map.put("Trainee Blood Group", trainee.getBloodGroup());
        map.put("TraineePancard", trainee.getPanCard());
        map.put("Trainee Mobile Number", trainee.getMobileNumber());
        map.put("trainers", trainerList);
        return map;
    }

    @Override
    public boolean getTraineeId(int id) {
        return traineeRepository.existsById(id);
    }
    @Override
    public boolean getTrainerId(int id) {
        return trainerRepository.existsById(id);
    }


}