package com.htc.springweb.controller;

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

import com.htc.springweb.model.Item;
import com.htc.springweb.service.ItemService;
@Controller
public class ItemController 
{
	@Autowired
	ItemService itemService ;

	@GetMapping("/addItemForm")
	public String showEmployeeForm(Model model) 
	{
		model.addAttribute("item", new Item());
		return "addItemForm";
	}
	

	@PostMapping("/addItem")  // spring 4.x onwards
	public String addEmployee(@ModelAttribute(name="item") Item item, RedirectAttributes attrs) 
	{
		System.out.println(item.toString());
		boolean result = itemService.addItem(item);
		System.out.println(result);
		if(result)
		{
			//return "addEmpSuccess";   //RequestDispatcher.forward(req, res);
			attrs.addFlashAttribute("itemDesc", item.getItemDesc());
			return "redirect:/itemSuccess";
		}
		else
			//throw new RuntimeException("Testing Exception handling In Spring");
			return "addItemForm";
	}
	
	@GetMapping("/itemSuccess")
	public String addEmpSuccess() {
		return "addItemSuccess";
	}
	
	
	@RequestMapping(value="/updateItemForm", method=RequestMethod.GET)
	public ModelAndView searchEmpForm() {
		ModelAndView mv = new ModelAndView("updateItemForm", "item", new Item());
		return mv;
	}
	

	//update get
	@GetMapping("/updateEmployee")
	public String updateEmp(Model model) {
		model.addAttribute("item", new Item());
		return "updateEmployee";
	}
	
	@PostMapping(value="/updateItem")
	public String updateEmp(@ModelAttribute(name="item")Item item,RedirectAttributes attrs){
		boolean result = itemService.updateItem(item);
		if(result){
			attrs.addFlashAttribute("itemDesc", item.getItemDesc());
			return "redirect:/itemUpdateSuccess";
		}
		else
			return "updateEmployee";
	}
	
	@GetMapping("/itemUpdateSuccess")
	public String empUpdateSuccess() {
		return "updateItemSuccess";
	}
	
	
	@RequestMapping(value="/listItems", method=RequestMethod.GET)
	public ModelAndView listUsers() {
		List<Item> itemList = itemService.getItems();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listItems");
		mv.addObject("itemList", itemList);
		return mv;
	}
	
	@GetMapping(value="/getItem", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Item getItem(@RequestParam(name="item") int itemCode) {    //@PathVariable(name="empno")
		System.out.println(itemCode);
		
		Item emp = itemService.getItem(itemCode);
		System.out.println(emp.toString());
		return emp;
	}
}
