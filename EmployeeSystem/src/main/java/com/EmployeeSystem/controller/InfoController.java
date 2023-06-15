package com.EmployeeSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EmployeeSystem.entity.Info;
import com.EmployeeSystem.service.InfoService;
import com.EmployeeSystem.dto.InfoForm;

@Controller
@RequestMapping("/empl")
public class InfoController {

	@Autowired
	private InfoService infoService;

	@GetMapping("/Reg")
	public String displayId(Model model) {
		InfoForm infoForm = new InfoForm();
		infoForm.setId(infoService.getNewId());
		model.addAttribute("infoForm", infoForm);

		return "employeeInfo/infoAdd";
	}

	@GetMapping("Upd/{employees_Id}")
	public String displayAll(@PathVariable("employees_Id") int employees_Id, Info info, Model model) {
		InfoForm infoForm = infoService.getInfo(employees_Id);
		model.addAttribute("infoForm", infoForm);

		return "employeeInfo/infoUpdate";
	}

	@PostMapping("/add")
	public String addInfo(@ModelAttribute InfoForm infoForm, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("errors", result.getAllErrors());

			return "employeeInfo/infoAdd";
		}
		infoService.addInfo(infoForm);

		return "employeeInfo/backPage";
	}

	@PostMapping("/update")
	public String updateInfo(@Validated InfoForm infoForm, BindingResult result, Model model) {
		if (result.hasErrors()) {

			model.addAttribute("errors", result.getAllErrors());

			return "employeeInfo/infoUpdate";
		}
		infoService.updateInfo(infoForm);
		
		return "employeeInfo/backPage";

	}

}