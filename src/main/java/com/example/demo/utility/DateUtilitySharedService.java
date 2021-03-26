package com.example.demo.utility;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class DateUtilitySharedService {
	//java.util.Calendarの月(month)は、0から始まることに留意すること
	//java.util.Calendarの週は日曜日(1)から始まる
	
	
	@Data
	public class BetoweenDate{
		private Date startDate;
		private Date finifhDate;
	}
	
	public BetoweenDate getBetoweenDateInDay(int year,int month,int day) {
		BetoweenDate betoweenDate = new BetoweenDate();
		Calendar calendar = Calendar.getInstance();
		
		//始まりを求める
		calendar.set(year,month - 1,day);
		betoweenDate.setStartDate(calendar.getTime());
		
		//終わりを求める
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.SECOND, -1);
		betoweenDate.setFinifhDate(calendar.getTime());
		
		return betoweenDate;
	}
	
	public BetoweenDate getBetoweenDateInMonth(int year,int month) {
		BetoweenDate betoweenDate = new BetoweenDate();
		Calendar calendar = Calendar.getInstance();
		
		//始まりを求める
		calendar.set(year, month - 1,1);
		betoweenDate.setStartDate(calendar.getTime());
		
		//終わりを求める
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.SECOND, -1);
		betoweenDate.setFinifhDate(calendar.getTime());
		
		return betoweenDate;
	}
	
	public BetoweenDate getBetoweenDateInWeek(int year,int month,int weekCount) {
		BetoweenDate betoweenDate = new BetoweenDate();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1,1);
		
		//第weekCount週目の範囲にある日付にする
		for(int i = 1;i <= weekCount;i++) 
			calendar.add(Calendar.DAY_OF_MONTH, 7);
		
		//始まりを求める
		int differenceUntilStartOfWeek = 1 - calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DAY_OF_MONTH, differenceUntilStartOfWeek);
		betoweenDate.setStartDate(calendar.getTime());
		
		//終わりを求める
		calendar.add(Calendar.DAY_OF_MONTH,7);
		calendar.add(Calendar.SECOND, -1);
		betoweenDate.setFinifhDate(calendar.getTime());
		
		return betoweenDate;
	}
	
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
