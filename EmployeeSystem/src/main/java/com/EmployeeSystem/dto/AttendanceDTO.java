package com.EmployeeSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class AttendanceDTO {
	private String CALENDAR_DATE;
	private String WEEKDAY;
	private String START_TIME;
	private String END_TIME;
	private double REST_HOURS_DAY;
	private double WORKING_HOURS_DAY;
	private double OVERTIME_HOURS_DAY;
	private String WORK_CONTENT;
	private String STATUS_NAME;
	private String UPDATE_USERID;
	private String  PLUS_CONTENT;
	private Integer HOLIDAY_FLG;
	private Integer APPLY_ID; 
	private Integer id;
    private String date;
    private String action;
	 
	}
