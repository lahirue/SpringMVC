package org.iconnectel.inodz.controllers;

import org.iconnectel.dao.EmployeeDAO;
import org.iconnectel.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lahirue on 5/23/18.
 */

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * Save an employee
	 */
	@PostMapping("/employee")
	public EmployeeDTO createEmployee (@Validated @RequestBody EmployeeDTO employeeDTO) {
		return employeeDAO.save(employeeDTO);
	}

	/**
	 * get all employees
	 */
	@GetMapping("/employee")
	public List<EmployeeDTO> getAllEmployees () {
		System.out.println("XXXXXXXXXXXXXXXXXSSSSSSSSSSSSSSSS");
		return employeeDAO.findAll();
	}

	/**
	 * get Employee by id
	 */
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "id") Long id){
		EmployeeDTO employeeDTO = employeeDAO.findOne(id);

		if (employeeDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(employeeDTO);
	}

	/**
	 * Update the employee
	 */
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee (@PathVariable(value = "id") Long id,@Validated @RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO employeeDTO1 = employeeDAO.findOne(id);

		if (employeeDTO1 == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDTO1.setUserName(employeeDTO.getUserName());
		employeeDTO1.setAge(employeeDTO.getAge());
		EmployeeDTO updatedEmp = employeeDAO.save(employeeDTO1);
		return ResponseEntity.ok().body(updatedEmp);
	}

	/**
	 * Delete employee
	 */
	@DeleteMapping("/employee/{id}")
	public  ResponseEntity<EmployeeDTO> deleteEmployeeById (@PathVariable(value = "id") Long id) {
		EmployeeDTO employeeDTO = employeeDAO.findOne(id);

		if (employeeDTO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().build();

	}

}
