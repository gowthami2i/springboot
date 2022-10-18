package com.ideas2it.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.Helper.TrainerHelper;
import com.ideas2it.springboot.dto.AssociationDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employee_management")
@Validated
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
    @PostMapping("/trainer")
    public String insertTrainer(@ModelAttribute Model model) throws Exception {
        return "login.html";
    }

    @GetMapping(path = "/trainers")
    public Model getTrainer(Model model) throws Exception {
        model.addAttribute(employeeServiceImpl.getAllTrainer());
        return model;

    }


    @GetMapping("/trainer/{id}")
    public Trainer getTrainerById(@PathVariable int id) throws Exception {
        int trainerId = id;
        Trainer getTrainer = null;
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);
        if (!trainer.getIsRemoved()) {

            getTrainer = employeeServiceImpl.getTrainer(trainerId);

            if (null != getTrainer) {
                return getTrainer;
            } else {
                return getTrainer;
            }
        } else {
            throw new EmployeeNotFoundException(" Trainer not Active");
        }
    }

    @PutMapping("/trainer")
    public String updateTrainerById(@RequestBody TrainerDto updateTrainer) throws Exception {
        Trainer trainer = TrainerHelper.trainerDtoToTrainer(updateTrainer);
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

    @DeleteMapping("/trainer/{id}")
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

    @PutMapping("/assign_trainer")
    public String assignTrainer(@RequestBody AssociationDto assign) throws Exception {

        int trainerId = assign.getTrainerId();
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);
        if (null != trainer) {
            List<Integer> assignTraineeId = assign.getTraineeId();

            Trainee trainee = null;
            for (Integer id : assignTraineeId) {
                trainee = employeeServiceImpl.getTrainee(id);
            }
            if (trainee != null) {

                trainer.getTraineeDetails().add(trainee);
                trainer = employeeServiceImpl.updatedTrainerDetails(trainer);

                if (null != trainer) {
                    return ("Assigned Successful");
                } else {
                    return ("notAssigned");
                }

            } else {
                throw new EmployeeNotFoundException("no Trainee");
            }

        } else {
            throw new EmployeeNotFoundException("no Trainer");
        }
    }

    @PutMapping("/unAssign_trainer")
    public String unAssignTrainer(@RequestBody AssociationDto unAssign) throws Exception {

        int trainerId = unAssign.getTrainerId();
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);

        if (null != trainer) {
            List<Integer> unAssignTraineeId = unAssign.getTraineeId();
            Trainee trainee = null;
            for (Integer traineeId : unAssignTraineeId) {
                trainee = employeeServiceImpl.getTrainee(traineeId);
            }
            if (null != trainee) {

                trainer.getTraineeDetails().remove(trainee);


                trainer = employeeServiceImpl.updatedTrainerDetails(trainer);

                if (null != trainer) {
                    return ("UnAssigned Successful");
                } else {
                    return ("notAssigned");
                }
            } else {
                return "no trainee";
            }

        } else {
            throw new EmployeeNotFoundException("no Trainer");
        }
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public String exceptionHandler(EmployeeNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
}
