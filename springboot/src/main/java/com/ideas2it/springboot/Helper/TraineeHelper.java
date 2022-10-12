package com.ideas2it.springboot.Helper;

import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;

import java.util.*;

public class TraineeHelper {
    public static TraineeDto traineeTOTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();

        traineeDto.setFirstName(trainee.getFirstName());
        traineeDto.setLastName(trainee.getLastName());
        traineeDto.setTask(trainee.getTask());
        traineeDto.setId(trainee.getId());
        traineeDto.setSkillSet(trainee.getSkillSet());
        traineeDto.setAadharNumber(trainee.getAadharNumber());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setEmail(trainee.getEmail());
        traineeDto.setMobileNumber(trainee.getMobileNumber());
        traineeDto.setPanCard(trainee.getPanCard());
        traineeDto.setBloodGroup(trainee.getBloodGroup());
        traineeDto.setDateOfJoinning(trainee.getDateOfJoinning());

        return traineeDto;
    }

    public static Trainee traineeDtoToTrainee(TraineeDto traineedto) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(traineedto.getFirstName());
        trainee.setLastName(traineedto.getLastName());
        trainee.setSkillSet(traineedto.getSkillSet());
        trainee.setId(traineedto.getId());
        trainee.setTask(traineedto.getTask());
        trainee.setAadharNumber(traineedto.getAadharNumber());
        trainee.setDateOfBirth(traineedto.getDateOfBirth());
        trainee.setEmail(traineedto.getEmail());
        trainee.setMobileNumber(traineedto.getMobileNumber());
        trainee.setPanCard(traineedto.getPanCard());
        trainee.setBloodGroup(traineedto.getBloodGroup());
        trainee.setDateOfJoinning(traineedto.getDateOfJoinning());

        return trainee;
    }
 /*   public Map<String, Object> getTraineeObject(Trainee trainee) {
        TraineeDto trainee1 = TraineeHelper.traineeTOTraineeDto(trainee);
        trainee1.getTrainerDtoList();
        Set<TrainerDto>trainer =trainee1.getTrainerDtoList();




        return map;
        for()
    }*/
}
