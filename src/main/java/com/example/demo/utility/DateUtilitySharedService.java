package com.example.demo.utility;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtilitySharedService {
	
	public Date mergeDate(Date date,Date time) {
		Calendar mergeCarender = Calendar.getInstance();
		Calendar timeCalender = Calendar.getInstance();
		mergeCarender.setTime(date);
		timeCalender.setTime(time);
		mergeCarender.add(Calendar.HOUR,timeCalender.get(Calendar.HOUR));
		mergeCarender.add(Calendar.MONTH,timeCalender.get(Calendar.MONTH));
		
		return mergeCarender.getTime();
	}
}
