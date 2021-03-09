package com.hr.service;

import com.hr.model.EmployeeData;

public interface EmployeeService {
    void saveEmployee(EmployeeData employeeData);
    void updateStatus(EmployeeData employeeData);
}
