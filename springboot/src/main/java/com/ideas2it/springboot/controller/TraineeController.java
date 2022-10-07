package com.ideas2it.springboot.controller;

import com.ideas2it.springboot.model.Trainee;
import com.ideas2it.springboot.model.Trainer;
import com.ideas2it.springboot.service.EmployeeService;
import org.apache.catalina.Session;
import org.apache.catalina.filters.ExpiresFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/trainee")
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
    @PostMapping("/add_trainee")
    public String insertTrainee(@RequestBody Trainee trainee) throws Exception {
        boolean isChecked = employeeServiceImpl.addTrainee(trainee);
        if (isChecked) {
            return "Insert Successfully";
        } else {
            return "not Inserted";
        }

    }

    @GetMapping("/get_trainees")
    public List<Trainee> getTrainees() {
        return employeeServiceImpl.getAllTrainee();
    }
    @GetMapping("/get_trainee/{id}")
    public Trainee getTraineeById (@PathVariable int id){
        return employeeServiceImpl.getTrainee(id);
    }
    //  @DeleteMapping("/remove_trainer/{id}")
    //public String removeTrainer(@PathVariable int id) {
    //  return employeeServiceImpl.deleteTrainerById(id);
    //}

}
