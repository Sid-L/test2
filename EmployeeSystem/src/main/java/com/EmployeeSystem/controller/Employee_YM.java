package com.EmployeeSystem.controller;

public class Employee_YM {
    private int employeeId;
    private int workHours;
    private int overtimeHours;

    public Employee_YM(int employeeId, int workHours, int overtimeHours) {
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
