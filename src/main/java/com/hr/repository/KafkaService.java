package com.hr.repository;

import com.hr.model.EmployeeData;

import java.io.IOException;

public interface KafkaService {
        void sendMessage(String message,String employeeId) ;
        void consume(String messag,String employeeIde) throws IOException;
    }
