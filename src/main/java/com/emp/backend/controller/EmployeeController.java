package com.emp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.backend.dto.EmployeeDTO;
import com.emp.backend.dto.EmployeeLoginDTO;
import com.emp.backend.dto.LoginMessage;
import com.emp.backend.entity.EmployeeEntity;
import com.emp.backend.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/add")
	public ResponseEntity<EmployeeDTO> saveDetails(@RequestBody EmployeeDTO dto) {
		EmployeeDTO entity2 = service.saveDetails(dto);
		return new ResponseEntity<>(entity2, HttpStatus.CREATED);

	}

	@PutMapping("/updateEmployee/{Id}")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity entity ,@PathVariable ("Id") Long Id) {
		return service.updateDetails(entity, Id);
		

	}
	

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody EmployeeLoginDTO loginDTO) {
//		Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);

		LoginMessage message= service.employeeLogin(loginDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping("/getEmployee/{Id}")
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("Id") Long Id)

	{
		EmployeeEntity eEntity = service.getEmployee(Id);

		return new ResponseEntity<>(eEntity, HttpStatus.OK);

	}

	@DeleteMapping("/deleteEmployee/{Id}")
	public void deleteEmployee(@PathVariable("Id") Long Id) {
		service.deleteEmployee(Id);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<EmployeeEntity>> getAll() {

		List<EmployeeEntity> entities = service.getAllEmployee();

		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

	@GetMapping("/getEmployeeByName/{fristName}/{lastName}")
	public ResponseEntity<EmployeeEntity> getByNames(@PathVariable("fristName") String fristName,
			@PathVariable("lastName") String lastName) {

		EmployeeEntity entities = service.findByFristnameAndLastname(fristName, lastName);
		return new ResponseEntity<>(entities, HttpStatus.OK);

	}
}