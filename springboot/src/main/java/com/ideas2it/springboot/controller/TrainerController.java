package com.ideas2it.springboot.controller;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;
import org.apache.catalina.Session;
import org.apache.catalina.filters.ExpiresFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainer")
@ControllerAdvice
public class TrainerController {

    public final EmployeeService employeeServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(Trainer.class);

    public TrainerController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    /**
     * method is used to get a request a data the user
     *
     * @param {@link Scanner}scanner object
     * @param {@link EmployeeService} employeeServiceImpl Object
     * @return {@link Trainer} trainer object
     */
    @PostMapping("/add_trainer")
    public String insertTrainer(@RequestBody Trainer trainer) throws Exception {
        boolean isChecked = employeeServiceImpl.addTrainer(trainer);
        if (isChecked) {
            return "Insert Successfully";
        } else {
            return "not Inserted";
        }
    }

    @GetMapping(path = "/get_trainers")
    public List<Map<String, Object>> getTrainer() throws Exception {
        List<Map<String, Object>> trainerList = new ArrayList<>();
        List<Trainer> trainers = employeeServiceImpl.getAllTrainer();
        for (Trainer trainer : trainers) {
            Map<String, Object> trainer1 = employeeServiceImpl.getTrainerObject(trainer);
            trainerList.add(trainer1);
        }

        if (null != trainerList) {
            return trainerList;
        } else {
            return null;
        }
    }


    @GetMapping("/get_trainer/{id}")
    public Map<String, Object> getTrainerById(@PathVariable int id) throws Exception {
        int trainerId = id;
        Map<String, Object> getTrainer = null;
        Trainer trainer = employeeServiceImpl.getTrainer(trainerId);
        if (null != trainer) {
            getTrainer = employeeServiceImpl.getTrainerObject(trainer);
            if (null != getTrainer) {
                return getTrainer;
            } else {
                return getTrainer;
            }
        } else {
            throw new EmployeeNotFoundException(" ");
        }
    }

    @PutMapping("/update_trainer")
    public String updateTrainerById(@RequestBody Trainer trainer) throws Exception{
        int trainerId = trainer.getId();
        Trainer trainer1 = employeeServiceImpl.getTrainer(trainerId);
        boolean isChecked = false;
        if (null != trainer1) {
            Trainer trainer2 = employeeServiceImpl.updatedTrainerDetails(trainer);
            if (null != trainer2) {
                return "Updated SuccessFully";
            } else {
                return "Not Updated";
            }
        } else {
            throw new RuntimeException("");
        }
    }
    @PutMapping("/assign_trainer/{trainerid}/{traineeid}")
    public String assigntrainer(@PathVariable int trainerid,
                                @PathVariable String traineeid) throws Exception {
        int id = trainerid;
        String id1 = traineeid;
        List<Trainee> list = employeeServiceImpl.getAllTrainee();
        Trainer trainer = employeeServiceImpl.getTrainer(id);
        if (trainer != null) {
            String[] traineesId = id1.split(",");
            int id2 = 0;
            Trainer trainer1 = null;
            boolean isChecked = false;
            for (int i = 0; i < traineesId.length; i++) {
                id2 = Integer.valueOf(traineesId[i]);

                for (Trainee retriveTrainee : list) {

                    if (retriveTrainee.getId() == id2) {
                        trainer.getTraineeDetails().add(retriveTrainee);
                    }
                    trainer1 = employeeServiceImpl.updatedTrainerDetails(trainer);
                }
            }
            if (null != trainer1) {
                return ("Assigned Successful");
            } else {
                return ("notAssigned");
            }

        } else {
            return ("no trainee");
        }

    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public String exceptionHandler(EmployeeNotFoundException e) {
        return "Employeeid not found";
    }
}
