package com.EmployeeSystem.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.EmployeeSystem.entity.AttendanceAL;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AttendanceALService extends IService<AttendanceAL> {
	List<AttendanceAL> attendanceALList(Integer employeesId, Integer deptId, String employeesName, Integer applyId, String start, String end);
}
