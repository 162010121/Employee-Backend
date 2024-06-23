package com.emp.backend.service;

import java.util.List;

import com.emp.backend.dto.EmployeeDTO;
import com.emp.backend.dto.EmployeeLoginDTO;
import com.emp.backend.dto.EmployeeLogout;
import com.emp.backend.dto.LoginMessage;
import com.emp.backend.entity.EmployeeEntity;

public interface EmployeeService {
	
	
	public EmployeeDTO saveDetails(EmployeeDTO empDTO);

	//public EmployeeDTO updateDetails(EmployeeDTO empDTO, Long Id);
	
	public EmployeeEntity updateDetails(EmployeeEntity entity, Long id);


	public EmployeeEntity getEmployee(Long id);

	public void deleteEmployee(Long id);

	public List<EmployeeEntity> getAllEmployee();

	public EmployeeEntity findByFristnameAndLastname(String firstName, String lastName);
	
	public LoginMessage employeeLogin(EmployeeLoginDTO loginDTO);
	
	public String logout(EmployeeLogout logout);
	
	

}
