package chap02;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateTest {
	public static void main(String[] args) {
		
		int year = 2019;
		int month = 2;
		int dayOfMonth = 20;
		
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		System.out.println(date.toString());
		
		// 객체상태가 변경되지 않음. 즉 plusDays는 접근자 메서드임
		date.plusDays(1);
		System.out.println(date.toString());
		
		// 접근자 메소드는 새로운 객체로 리턴 받아야 됨
		date = date.plusDays(1);
		System.out.println(date.toString());
		
		
		while(date.getMonthValue() == month) {
			System.out.printf("%4d", date.getDayOfMonth());
			date = date.plusDays(1);
		}
		System.out.println();
		
		DayOfWeek weekday = date.getDayOfWeek();
		System.out.println("weekday=" + weekday);
		
		int value = weekday.getValue();
		System.out.println("value=" + value);
	}
}
