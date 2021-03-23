package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.EmployeesEntity;
import kinoxp.com.demo.model.WorkShiftsEntity;
import kinoxp.com.demo.repositories.EmployeeRepository;
import kinoxp.com.demo.repositories.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class WorkScheduleRestController {

    @Autowired
    WorkShiftRepository workShiftRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/workShifts")
    public List<WorkShiftsEntity> findAllWorkShifts() {
        return workShiftRepository.findAllWorkShifts();
    }

    @GetMapping("/employees")
    public List<EmployeesEntity> findAllEmployees() {
        return employeeRepository.findAllEmps();
    }
}
