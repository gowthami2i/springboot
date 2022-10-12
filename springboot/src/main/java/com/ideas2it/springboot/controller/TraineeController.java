package com.ideas2it.springboot.controller;

import com.ideas2it.springboot.Exception.EmployeeNotFoundException;
import com.ideas2it.springboot.Helper.TraineeHelper;
import com.ideas2it.springboot.Helper.TrainerHelper;
import com.ideas2it.springboot.dto.TraineeDto;
import com.ideas2it.springboot.dto.TrainerDto;
import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public String insertTrainee( @Valid @RequestBody TraineeDto traineeDto) throws Exception {
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

    @PutMapping("/assign_trainee/{traineeid}/{trainerid}")
    public String assignTrainee(@PathVariable("traineeid") int assignTraineeId,
                                @PathVariable("trainerid") int assignTrainerId) throws Exception {

        List<TrainerDto> list = employeeServiceImpl.getAllTrainer();
        List<Trainer> trainerList = list.stream().map(trainer -> TrainerHelper.trainerDtoToTrainer(trainer))
                .collect(Collectors.toList());
        Trainee trainee = employeeServiceImpl.getTrainee(assignTraineeId);


        if (trainee != null) {

            for (Trainer retriveTrainer : trainerList) {

                if (retriveTrainer.getId() ==  assignTrainerId) {
                    System.out.println(retriveTrainer.getId()+retriveTrainer.getFirstName());
                    System.out.println(assignTrainerId);
                    trainee.getTrainerDetails().add(retriveTrainer);
                }
                 trainee = employeeServiceImpl.updatedTraineeDetails(trainee);

            }


            if (null != trainee) {
                return ("Assigned Successful");
            } else {
                return ("notAssigned");
            }

        } else {
            throw new EmployeeNotFoundException("no Trainee");
        }

    }


}



