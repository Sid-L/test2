package com.EmployeeSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

<<<<<<< HEAD
@Entity
public class Employee {
	
=======

@Entity
public class Employee {
>>>>>>> e80da568a28bd6530bcbae25e2f7302cb0999bd9
	@Id
    private int employeeId;
    private int workHours;
    private int overtimeHours;


    public Employee(int employeeId, int workHours, int overtimeHours) {
        this.employeeId = employeeId;
        this.workHours = workHours;
        this.overtimeHours = overtimeHours;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }
}
