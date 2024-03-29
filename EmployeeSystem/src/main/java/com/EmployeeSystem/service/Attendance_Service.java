package com.EmployeeSystem.service;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeSystem.dto.Register_Update_Dto;
import com.EmployeeSystem.dto.Get_Form;
import com.EmployeeSystem.dto.Post_Form;
import com.EmployeeSystem.dto.Put_Form;
import com.EmployeeSystem.repo.Register_Update_Repository;

@Service
@Transactional
public class Attendance_Service {
	private final Register_Update_Repository repository;
	
	public Attendance_Service(Register_Update_Repository repository)
	{
		this.repository = repository;
	}
	
	public List<Register_Update_Dto> findList(Get_Form form)
	{
		return repository.findList(form);
	}
	
	public int update(Put_Form form)
	{
		return repository.update(form);
	}
	
	public int insert(Post_Form form)
	{
		return repository.insert(form);
	}
	
	//勤怠情報一覧（日別）が実装済みの場合、以降の処理は全て消してください。
	public Register_Update_Dto findById(int employees_id)
	{
		try
		{
			return repository.findById(employees_id);
		}
		catch(IncorrectResultSizeDataAccessException e)
		{
			return null;
		}
	}
	
	public int delete(int emoloyees_id)
	{
		return repository.delete(emoloyees_id);
	}
}
