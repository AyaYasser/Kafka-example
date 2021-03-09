package com.hr;

import com.hr.model.EmployeeData;
import com.hr.model.StateMachine;
import com.hr.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class HrApplicationTests {
	@Autowired
	EmployeeService employeeService;
	private static final String TOPIC = "employees";


	@Test
	public void addEmployeeTest(){
		employeeService.saveEmployee(constructEmployeeData());
	}
	@Test
	public void updateStatusTest(){
		employeeService.updateStatus(constructEmployeeData());
	}
	private EmployeeData constructEmployeeData(){
		EmployeeData employeeData=new EmployeeData();
		employeeData.setEmployeeId("123456");
		employeeData.setContractInfo("ABCD");
		employeeData.setName("Aya Yasser");
		employeeData.setStatus(StateMachine.IN_CHECK.name());
		return employeeData;
	}

}
