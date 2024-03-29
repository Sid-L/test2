package com.EmployeeSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeSystem.dto.Register_Update_Dto;
import com.EmployeeSystem.dto.Get_Form;
import com.EmployeeSystem.dto.Post_Form;
import com.EmployeeSystem.dto.Put_Form;
import com.EmployeeSystem.service.Attendance_Service;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/dto")
public class Register_Update_Controller {
	
	private final Attendance_Service attendance_service;
	
	public Register_Update_Controller(Attendance_Service attendance_service)
	{
		this.attendance_service = attendance_service;
	}
	
	@GetMapping
	public String diaryList(
			@ModelAttribute Get_Form form,
			Model model)
	{
		List<Register_Update_Dto> list = attendance_service.findList(form);
		model.addAttribute("list", list);
		model.addAttribute("getForm", form);
		return "list";
	}
	
	/*@GetMapping
	public String registerUpdateList(Model model)
	{
		return "list";
	}*/
	
	@GetMapping("/form")
	public String formPage(Model model)
	{
		return "form";
	}
	
	@PostMapping(path= {"/insert","/form","/update"},params="back")
	public String backPage(Model model)
	{
		return "redirect:/dto";
	}
	
	//登録
	@PostMapping(path="/insert",params="insert")
	public String insert(@Valid @ModelAttribute Post_Form form,
			BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error","パラメータエラーが発生しました。");
			return "form";
		}
		int count = attendance_service.insert(form);
		model.addAttribute("post_Form",form);
		return "redirect:/dto";
	}
	
	//更新
	@PostMapping(path="/update",params="update")
	public String update(@ModelAttribute Put_Form form,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error", "パラメータエラーが発生しました。");
			return "form";
		}
		int count = attendance_service.update(form);
		return "redirect:/dto";
	}
	
	@PostMapping("/form")
	public String formPage(@ModelAttribute Put_Form form,Model model)
	{
		model.addAttribute("put_Form",form);
		
		if(form.isUpdateFlag())
		{
			model.addAttribute("update",true);
		}
		else
		{
			model.addAttribute("update",false);
		}
		return "form";
	}
	
	
	//勤怠情報一覧（日別）が実装済みの場合、以降の処理は全て消してください。
	@GetMapping("/{id}")
	public String showUpdate(@PathVariable int employees_id, Model model)
	{
		Optional<Register_Update_Dto> diaryOpl = Optional.ofNullable(attendance_service.findById(employees_id));
		if(diaryOpl.isPresent())
		{
			model.addAttribute("dto",diaryOpl.get());
			return "detail";
		}
		else
		{
			model.addAttribute("error","対象データが存在しません");
			return "detail";
		}
	}
	
	//削除
	@GetMapping("/delete")
	public String delete(@RequestParam int employees_id,Model model)
	{
		int count = attendance_service.delete(employees_id);
		return "redirect:/dto";
	}
}
