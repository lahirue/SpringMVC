package org.iconnectel.inodz.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iconnectel.dto.UserDetails;
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

		try {
			UserDetails userDetails = new UserDetails();
			userDetails.setUserId(1);
			userDetails.setUserName("First User");

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();
		}catch (Exception ex) {
			System.out.println("ERROR :: " + ex);
		}




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
