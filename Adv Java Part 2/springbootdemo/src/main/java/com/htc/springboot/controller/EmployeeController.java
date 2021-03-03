package com.htc.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htc.springboot.model.Employee;
import com.htc.springboot.service.EmployeeService;
@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService empService ;

	//	@GetMapping("/addEmployeeForm")
	//	public String addEmployeeForm(){
	//		return "addEmployeeForm";
	//	}
	//	
	//	@PostMapping("/addEmployee")
	//	public String addEmployee(){
	//		return "addedSuccessfully";
	//	}
	//	

	
	//@RequestMapping(value="/addUserForm", method=RequestMethod.GET)
	@GetMapping("/addEmployeeForm")
	public String showEmployeeForm(Model model) 
	{
		model.addAttribute("emp", new Employee());
		return "addEmployeeForm";
	}
	

	@PostMapping("/addEmployee")  // spring 4.x onwards
	public String addEmployee(@ModelAttribute(name="emp") Employee emp, RedirectAttributes attrs) 
	{
		System.out.println(emp.toString());
		boolean result = empService.addEmployee(emp);
		System.out.println(result);
		if(result)
		{
			//return "addEmpSuccess";   //RequestDispatcher.forward(req, res);
			attrs.addFlashAttribute("empname", emp.getEname());
			return "redirect:/empSuccess";
		}
		else
			//throw new RuntimeException("Testing Exception handling In Spring");
			return "addEmployeeForm";
	}
	
	@GetMapping("/empSuccess")
	public String addEmpSuccess() {
		return "addEmpSuccess";
	}
	
	
	@RequestMapping(value="/searchEmpForm", method=RequestMethod.GET)
	public ModelAndView searchEmpForm() {
		ModelAndView mv = new ModelAndView("searchEmpForm", "emp", new Employee());
		return mv;
	}
	
	
	@RequestMapping(value="/listEmps", method=RequestMethod.GET)
	public ModelAndView listUsers() {
		List<Employee> empList = empService.getEmployees();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listEmps");
		mv.addObject("empList", empList);
		return mv;
	}
	
	@GetMapping(value="/getEmployee", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee getEmployee(@RequestParam(name="empno") int empno) {    //@PathVariable(name="empno")
		System.out.println(empno);
		
		Employee emp = empService.getEmployee(empno);
		System.out.println(emp.toString());
		return emp;
	}
	
	
	//update get
	@GetMapping("/updateEmployee")
	public String updateEmp(Model model) {
		model.addAttribute("emp", new Employee());
		return "updateEmployee";
	}
	
	@PostMapping(value="/updateEmp")
	public String updateEmp(@ModelAttribute(name="emp") Employee emp,RedirectAttributes attrs){
		boolean result = empService.updateEmployee(emp);
		if(result){
			attrs.addFlashAttribute("empname", emp.getEname());
			return "redirect:/empUpdateSuccess";
		}
		else
			return "updateEmployee";
	}
	
	@GetMapping("/empUpdateSuccess")
	public String empUpdateSuccess() {
		return "updateEmpSuccess";
	}
	
	
//	//search
//	@GetMapping(value="/searchEmp")
//	public String searchEmployee()
//	{
//		return "search";
//	}
//
//	//listAllEmp
//	@GetMapping(value="/listEmp")
//	public String listEmployee()
//	{
//		return "list";
//	}

}
