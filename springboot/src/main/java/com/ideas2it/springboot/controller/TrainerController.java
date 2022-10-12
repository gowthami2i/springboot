package com.ideas2it.springboot.controller;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.Helper.TraineeHelper;
import com.ideas2it.springboot.Helper.TrainerHelper;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;
import org.apache.catalina.Session;
import org.apache.catalina.filters.ExpiresFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainer")
@ControllerAdvice
public class TrainerController {
    @Autowired
    public EmployeeService employeeServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(Trainer.class);


    /**
     * method is used to get a request a data the user
     *
     * @param {@link Scanner}scanner object
     * @param {@link EmployeeService} employeeServiceImpl Object
     * @return {@link Trainer} trainer object
     */
    @PostMapping("/add_trainer")
    public String insertTrainer(@RequestBody TrainerDto trainerDto) throws Exception {
        Trainer trainer = employeeServiceImpl.addTrainer(trainerDto);
        if (null != trainer) {
            return "Insert Successfully";
        } else {
            return "not Inserted";
        }
    }

    @GetMapping(path = "/get_trainers")
    public List<TrainerDto> getTrainer() throws Exception {
        //List<Map<String, Object>> trainerList = new ArrayList<>();
        return employeeServiceImpl.getAllTrainer();

    }


    @GetMapping("/get_trainer/{id}")
    public Map<String, Object> getTrainerById(@PathVariable int id) throws Exception {
        int trainerId = id;
        Map<String, Object> getTrainer = null;
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);
        if (!trainer.getIsRemoved()) {

            getTrainer = employeeServiceImpl.getTrainerObject(trainer);

            if (null != getTrainer) {
                return getTrainer;
            } else {
                return getTrainer;
            }
        } else {
            throw new EmployeeNotFoundException(" Trainer not Active");
        }
    }

    @PutMapping("/update_trainer")
    public String updateTrainerById(@RequestBody Trainer trainer) throws Exception {
        int trainerId = trainer.getId();
        Trainer trainer1 = employeeServiceImpl.getTrainer(trainerId);

        if (null != trainer1) {
            Trainer trainer2 = employeeServiceImpl.updatedTrainerDetails(trainer);
            if (null != trainer2) {
                return "Updated SuccessFully";
            } else {
                return "Not Updated";
            }
        } else {
            throw new RuntimeException("Trainer id not found");
        }
    }

    @DeleteMapping("/remove_trainer/{id}")
    public String removeTrainerById(@PathVariable int id) throws Exception {
        boolean isChecked = employeeServiceImpl.getTrainerId(id);
        if (isChecked) {
            Trainer trainer = employeeServiceImpl.deleteTrainerById(id);

            if (trainer.getIsRemoved()) {
                return "deleted Sucessfully";
            } else {
                return " Trainer Id is not Active";
            }
        } else {
            return "Trainer Id not available";
        }
    }

    @PutMapping("/assign_trainer/{trainerId}/{traineeId}")
    public String assignTrainer(@PathVariable("trainerId") int assignTrainerId,
                                @PathVariable("traineeId") int assignTraineeId) throws Exception {
        int trainerId = assignTrainerId;
        int traineeId = assignTraineeId;
        List<TraineeDto> list = employeeServiceImpl.getAllTrainee();
        List<Trainee> traineeList = list.stream().map(trainee -> TraineeHelper.traineeDtoToTrainee(trainee))
                                                            .collect(Collectors.toList());
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);

        if (trainer != null) {

            for (Trainee retriveTrainee : traineeList) {

                if (retriveTrainee.getId() == traineeId) {
                    trainer.getTraineeDetails().add(retriveTrainee);
                }

                trainer = employeeServiceImpl.updatedTrainerDetails(trainer);
            }

            if (null != trainer) {
                return ("Assigned Successful");
            } else {
                return ("notAssigned");
            }

        } else {
            throw new EmployeeNotFoundException("no Trainer");
        }

    }

    @PutMapping("/unAssign_trainer/{trainerId}/{traineeId}")
    public String unAssignTrainer(@PathVariable int trainerId, @PathVariable int traineeId) throws Exception {

        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);
        if (null != trainer) {
            Set<Trainee> trainee = trainer.getTraineeDetails();
            List<Trainee> traineeList = new ArrayList<>(trainee);

            for (Trainee trainee1 : traineeList) {
                if (trainee1.getId() == traineeId) {
                    trainee.remove(trainee1);
                }
            }
            trainer = employeeServiceImpl.updatedTrainerDetails(trainer);

            if (null != trainer) {
                return ("UnAssigned Successful");
            } else {
                return ("notAssigned");
            }
        } else {
            return "no trainer";
        }

    }


    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public String exceptionHandler(EmployeeNotFoundException e) {
        return e.getMessage();
    }
}
