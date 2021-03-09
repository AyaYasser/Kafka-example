package com.hr.api;

import com.hr.model.EmployeeData;
import com.hr.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employee")
//@Api(value = "Employee REST Endpoint", description = "Employee services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/add")
    public int addNewEmployee(@RequestBody EmployeeData employeeData) {
        employeeService.saveEmployee(employeeData);
        return 0;
    }
    @PostMapping(value = "/update")
    public int updateEmployeeStatus(@RequestBody EmployeeData employeeData) {
        employeeService.updateStatus(employeeData);
        return 0;
    }

}
