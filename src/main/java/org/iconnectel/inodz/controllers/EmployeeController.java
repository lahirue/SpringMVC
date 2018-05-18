package org.iconnectel.inodz.controllers;

import org.iconnectel.inodz.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lahirue on 5/18/18.
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {

	@RequestMapping("{employeeId}")
	public String details(Model model, @PathVariable("employeeId") int id) {
		// add some logics
		Employee employee = new Employee(id, "Jeewan");
		model.addAttribute("emp3", employee);
		return "employee/details";
	}

	@RequestMapping("")
	public String requestDetails(Model model, @RequestParam("employeeName") String name) {
		// this will just get the request param and create a user.
		//add more logics
		Employee employee = new Employee(41, name);
		model.addAttribute("emp3", employee);
		return "employee/details";
	}
}
