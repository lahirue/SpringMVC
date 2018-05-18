package org.iconnectel.inodz.controllers;

import org.iconnectel.inodz.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lahirue on 5/18/18.
 */
@Controller
public class HomeController {

	/**
	 * This method will return a value without having a view
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String callMVC() {
		return "Hello First SPRING MVC";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String callHome(Model model) {
		Employee employee = new Employee(1,"Lahiu");
		model.addAttribute("emp1",employee);
		return "home";
	}
}
