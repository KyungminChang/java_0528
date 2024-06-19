package day13;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);//연도를 추출
		int month = cal.get(Calendar.MONTH);//월을 추출. 0~11
		int date = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "년 " + (month+1) + "월 " + date + "일 ");
	}

}
