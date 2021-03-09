package com.hr.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.model.EmployeeData;
import com.hr.model.StateMachine;
import com.hr.repository.KafkaService;
import com.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    KafkaService kafkaService;
    @Override
    public void saveEmployee(EmployeeData employeeData) {
        employeeData.setStatus(StateMachine.ADDED.name());
        kafkaService.sendMessage(convertFromEmployeeToString(employeeData),employeeData.getEmployeeId());
    }

    @Override
    public void updateStatus(EmployeeData employeeData) {
        try {
            kafkaService.consume(convertFromEmployeeToString(employeeData),employeeData.getEmployeeId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String convertFromEmployeeToString(EmployeeData employeeData){
        ObjectMapper mapper = new ObjectMapper();
        String json="";
        try {
             json = mapper.writeValueAsString(employeeData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
