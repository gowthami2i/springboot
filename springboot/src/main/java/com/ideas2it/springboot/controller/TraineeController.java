package com.ideas2it.springboot.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

import com.ideas2it.springboot.service.EmployeeService;
import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.Helper.TraineeHelper;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;

@RestController
@RequestMapping("/employee_management")
@Validated
public class TraineeController {

    public final EmployeeService employeeServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(Trainer.class);

    public TraineeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    /**
     * method is used to get a request a data the user
     *
     * @param {@link Scanner}scanner object
     * @param {@link EmployeeService} employeeServiceImpl Object
     * @return {@link Trainer} trainer object
     */
    @PostMapping("/trainee")
    public String insertTrainee(@Valid @RequestBody TraineeDto traineeDto) throws Exception {
        Trainee trainee = employeeServiceImpl.addTrainee(traineeDto);
        if (null != trainee) {
            return "Insert Successfully";
        } else {
            return "not Inserted";
        }

    }

    @GetMapping("/trainees")
    public List<TraineeDto> getTrainees() throws Exception {
        return employeeServiceImpl.getAllTrainee();
    }

    @GetMapping("/trainee/{id}")
    public Map<String, Object> getTraineeById(@PathVariable int id) throws Exception {
        int traineeId = id;
        Map<String, Object> getTrainee = null;
        Trainee trainee = employeeServiceImpl.getTrainee(traineeId);
        if (!trainee.getIsRemoved()) {

            getTrainee = employeeServiceImpl.getTraineeObject(trainee);

            if (null != getTrainee) {
                return getTrainee;
            } else {
                return getTrainee;
            }
        } else {
            throw new EmployeeNotFoundException(" Trainee not Active");
        }
    }

    @PutMapping("/trainee")
    public String updateTraineeById(@RequestBody TraineeDto updateTrainee) throws Exception {
        Trainee trainee = TraineeHelper.traineeDtoToTrainee(updateTrainee);
        int traineeId = trainee.getId();
        Trainee trainee1 = employeeServiceImpl.getTrainee(traineeId);

        if (null != trainee1) {
            Trainee trainee2 = employeeServiceImpl.updatedTraineeDetails(trainee);
            if (null != trainee2) {
                return "Updated SuccessFully";
            } else {
                return "Not Updated";
            }
        } else {
            throw new EmployeeNotFoundException("Trainee id not found");
        }
    }

    @DeleteMapping("/trainee/{id}")
    public String removeTraineeById(@PathVariable int id) throws Exception {
        boolean isChecked = employeeServiceImpl.getTraineeId(id);
        if (isChecked) {
            Trainee trainee = employeeServiceImpl.deleteTraineeById(id);

            if (!trainee.getIsRemoved()) {
                return "deleted Sucessfully";
            } else {
                return " Trainee Id is not Active";
            }
        } else {
            return "Trainee Id not available";
        }
    }

}



