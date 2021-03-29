package com.example.demo.utility;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DateUtilitySharedServiceTest {
	@Autowired
	DateUtilitySharedService dateUtilitySharedService;
	
	@Test
	void getBetoweenDateInDayTest() {
		DateUtilitySharedService.BetoweenDate betoweenDate = 
				dateUtilitySharedService.getBetoweenDateInDay(2021,3,28);
		
		//betoweenDate.startDateの検証
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(betoweenDate.getStartDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(28, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
		
		//betoweenDate.startDateの検証
		calendar.setTime(betoweenDate.getFinifhDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(28, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(59, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(59, calendar.get(Calendar.SECOND));
	}
	
	@Test
	void getBetoweenDateInMonthTest() {
		DateUtilitySharedService.BetoweenDate betoweenDate = 
				dateUtilitySharedService.getBetoweenDateInMonth(2021,3);
		
		//betoweenDate.startDateの検証
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(betoweenDate.getStartDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
		
		//betoweenDate.startDateの検証
		calendar.setTime(betoweenDate.getFinifhDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(59, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(59, calendar.get(Calendar.SECOND));
	}
	
	@Test
	void getBetoweenDateInWeekTest() {
		/*///////////////////////////////////////////////////////////////
		//   テストケース１
		*////////////////////////////////////////////////////////////////
		DateUtilitySharedService.BetoweenDate betoweenDate = 
				dateUtilitySharedService.getBetoweenDateInWeek(2021,3,1);
		
		//betoweenDate.startDateの検証
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(betoweenDate.getStartDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(2, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(28, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
		
		//betoweenDate.startDateの検証
		calendar.setTime(betoweenDate.getFinifhDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(6, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(59, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(59, calendar.get(Calendar.SECOND));
		
		/*///////////////////////////////////////////////////////////////
		//   テストケース2
		*////////////////////////////////////////////////////////////////
		betoweenDate = dateUtilitySharedService.getBetoweenDateInWeek(2021,3,5);
		
		//betoweenDate.startDateの検証
		calendar.setTime(betoweenDate.getStartDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(3, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(28, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
		
		//betoweenDate.startDateの検証
		calendar.setTime(betoweenDate.getFinifhDate());
		Assertions.assertEquals(2021, calendar.get(Calendar.YEAR));
		Assertions.assertEquals(4, calendar.get(Calendar.MONTH) + 1);
		Assertions.assertEquals(3, calendar.get(Calendar.DAY_OF_MONTH));
		Assertions.assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		Assertions.assertEquals(59, calendar.get(Calendar.MINUTE));
		Assertions.assertEquals(59, calendar.get(Calendar.SECOND));
	}
}
