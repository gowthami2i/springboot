package com.ideas2it.springboot.Helper;

import com.ideas2it.springboot.dao.TraineeRepository;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.dto.TrainerResponseDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;

import java.util.HashSet;
import java.util.Set;


public class TrainerHelper {


    public static TrainerDto trainerTOTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();

        trainerDto.setFirstName(trainer.getFirstName());
        trainerDto.setLastName(trainer.getLastName());
        trainerDto.setExperience(trainer.getExperience());
        trainerDto.setId(trainer.getId());
        trainerDto.setProject(trainer.getProject());
        trainerDto.setAadharNumber(String.valueOf(trainer.getAadharNumber()));
        trainerDto.setDateOfBirth(trainer.getDateOfBirth());
        trainerDto.setEmail(trainer.getEmail());
        trainerDto.setMobileNumber(String.valueOf(trainer.getMobileNumber()));
        trainerDto.setPanCard(trainer.getPanCard());
        trainerDto.setBloodGroup(trainer.getBloodGroup());
        trainerDto.setDateOfJoinning(trainer.getDateOfJoinning());
        Set<Trainee> trainee = trainer.getTraineeDetails();
      //  trainerDto.setTraineeDtoList(traineeToTraineeList(trainee));

        return trainerDto;
    }

    public static Set<TrainerResponseDto> traineeToTraineeList(Set<Trainee> trainee) {
        Set<TrainerResponseDto> trainee1 = new HashSet<>();
        for (Trainee trainee2 : trainee) {
            TrainerResponseDto trainerResponseDto = new TrainerResponseDto();
            trainerResponseDto.setTrainerName(trainee2.getFirstName());
            trainerResponseDto.setTrainerId(trainee2.getId());

        }
        return trainee1;
    }

    public static Trainer trainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setExperience(trainerDto.getExperience());
        trainer.setId(trainerDto.getId());
        trainer.setProject(trainerDto.getProject());
        trainer.setAadharNumber(Long.valueOf(trainerDto.getAadharNumber()));
        trainer.setDateOfBirth(trainerDto.getDateOfBirth());
        trainer.setEmail(trainerDto.getEmail());
        trainer.setMobileNumber(Long.valueOf(trainerDto.getMobileNumber()));
        trainer.setPanCard(trainerDto.getPanCard());
        trainer.setBloodGroup(trainerDto.getBloodGroup());
        trainer.setDateOfJoinning(trainerDto.getDateOfJoinning());

        return trainer;

    }
}
