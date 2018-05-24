package org.iconnectel.dao;

import org.iconnectel.dto.EmployeeDTO;
import org.iconnectel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lahirue on 5/23/18.
 */
@Service
public class EmployeeDAO {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Save employee
	 * @param employeeDTO
	 * @return
	 */
	public EmployeeDTO save (EmployeeDTO employeeDTO) {
		return employeeRepository.save(employeeDTO);
	}

	/**
	 * Find all employees
	 * @return
	 */
	public List<EmployeeDTO> findAll () {
		return employeeRepository.findAll();
	}

	/**
	 * Find an object by id
	 * @param id
	 * @return
	 */
	public EmployeeDTO findOne (Long id) {
		return  employeeRepository.findById(id).get();
	}

	/**
	 * Delete a given employee
	 * @param employeeDTO
	 */
	public void delete (EmployeeDTO employeeDTO) {
		employeeRepository.delete(employeeDTO);
	}


}
