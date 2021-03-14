package com.example.demo.form.space;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.example.demo.RegexpMessage;
import com.example.demo.form.Groups;

import lombok.Data;

@Data
public class SpaceListForm {
	@Min(value = 1950,message = RegexpMessage.YEAR,
		groups = {Groups.CountInMonthGroup.class,Groups.CountInDayGroup.class,Groups.CountInWeekGroup.class,Groups.ListInDayGroup.class})
	@Max(value = 9999,message = RegexpMessage.YEAR,
		groups = {Groups.CountInMonthGroup.class,Groups.CountInDayGroup.class,Groups.CountInWeekGroup.class,Groups.ListInDayGroup.class})
	private Integer year;
	
	@Min(value = 1,message = RegexpMessage.MONTH,
		groups = {Groups.CountInMonthGroup.class,Groups.CountInDayGroup.class,Groups.CountInWeekGroup.class,Groups.ListInDayGroup.class})
	@Max(value = 12,message = RegexpMessage.MONTH,
		groups = {Groups.CountInMonthGroup.class,Groups.CountInDayGroup.class,Groups.CountInWeekGroup.class,Groups.ListInDayGroup.class})
	private Integer month;
	
	@Min(value = 1,message = RegexpMessage.WEEK, groups = {Groups.CountInWeekGroup.class})
	@Max(value = 6,message = RegexpMessage.WEEK,groups = {Groups.CountInWeekGroup.class})
	private Integer weekCount;
	
	@Min(value = 1,message = RegexpMessage.DAY, groups = {Groups.CountInDayGroup.class,Groups.ListInDayGroup.class})
	@Max(value = 31,message = RegexpMessage.DAY,groups = {Groups.CountInDayGroup.class,Groups.ListInDayGroup.class})
	private Integer day;
}
