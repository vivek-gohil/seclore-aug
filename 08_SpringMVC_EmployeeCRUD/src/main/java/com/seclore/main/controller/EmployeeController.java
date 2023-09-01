package com.seclore.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.main.domain.Employee;
import com.seclore.main.service.EmployeeServiceInterface;

@Controller
@RequestMapping("employeecrud")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeService;

	@RequestMapping("saveupdatedemployee")
	public String showHomePage(Employee employee) {
		boolean result = employeeService.updateEmployee(employee);
		System.out.println(result);
		return "redirect:/employeecrud/employees";
	}

	@RequestMapping("updateemployee/{employeeId}")
	public ModelAndView showUpdateEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.getSingleEmployee(employeeId);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("updateemployee");

		return modelAndView;
	}

	@RequestMapping("deleteemployee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		boolean result = employeeService.removeEmployee(employeeId);
		System.out.println(result);
		return "redirect:/employeecrud/employees";
	}

	@RequestMapping("saveemployee")
	public String saveEmployee(@Valid Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addnewemployee";
		} else {
			boolean result = employeeService.addNewEmployee(employee);
			System.out.println(result);
			return "redirect:employees";
		}
	}

	@RequestMapping("newemployee")
	public ModelAndView showAddNewEmployee() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("addnewemployee");
		return modelAndView;
	}

	@RequestMapping("employees")
	public ModelAndView showEmployeeHome() {
		List<Employee> employeeList = employeeService.getAllEmployees();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeList", employeeList);
		modelAndView.setViewName("employeehome");

		return modelAndView;
	}
}
