package com.ideas2it.springboot.Helper;

import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainer;


public class TrainerHelper {



     public static TrainerDto trainerTOTrainerDto (Trainer trainer) {
            TrainerDto trainerDto = new TrainerDto();

            trainerDto.setFirstName(trainer.getFirstName());
            trainerDto.setLastName(trainer.getLastName());
            trainerDto.setExperience(trainer.getExperience());
            trainerDto.setId(trainer.getId());
            trainerDto.setProject(trainer.getProject());
            trainerDto.setAadharNumber(trainer.getAadharNumber());
            trainerDto.setDateOfBirth(trainer.getDateOfBirth());
            trainerDto.setEmail(trainer.getEmail());
            trainerDto.setMobileNumber(trainer.getMobileNumber());
            trainerDto.setPanCard(trainer.getPanCard());
            trainerDto.setBloodGroup(trainer.getBloodGroup());
            trainerDto.setDateOfJoinning(trainer.getDateOfJoinning());



            return trainerDto;
        }
        public static Trainer trainerDtoToTrainer(TrainerDto trainerDto) {
            Trainer trainer = new Trainer();
            trainer.setFirstName(trainerDto.getFirstName());
            trainer.setLastName(trainerDto.getLastName());
            trainer.setExperience(trainerDto.getExperience());
            trainer.setId(trainerDto.getId());
            trainer.setProject(trainerDto.getProject());
            trainer.setAadharNumber(trainerDto.getAadharNumber());
            trainer.setDateOfBirth(trainerDto.getDateOfBirth());
            trainer.setEmail(trainerDto.getEmail());
            trainer.setMobileNumber(trainerDto.getMobileNumber());
            trainer.setPanCard(trainerDto.getPanCard());
            trainer.setBloodGroup(trainerDto.getBloodGroup());
            trainer.setDateOfJoinning(trainerDto.getDateOfJoinning());

            return trainer;

        }
}
