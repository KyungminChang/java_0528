package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args){
		/*
		 * 주민번호를 입력받아 입력받은 주민번호의 생일을 출력하는 코드를 작성하세요. 000101-3012141 => 2000-01-01
		 * 000101-2012141 =>1900-01-01
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요.");
		String joomin = scan.next();
		// 주민번호 형식이 맞는지 확인
		boolean res = checkNum(joomin);
		if(!res) {
			System.out.println("주민번호 형식에 맞지 않습니다.");
			return;
		}
		// 성별번호를 이용해서 19 또는 20을 계산
		int gen;
		switch (joomin.charAt(7)) {
		case '1', '2':
			gen = 19;
			String birth = gen + joomin.substring(0, 6);
			String result = convert1(birth);
			System.out.println(result);
			break;
		case '3', '4':
			gen = 20;
			birth = gen + joomin.substring(0, 6);
			try {
				result = convert2(birth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("잘못된 주민번호입니다.");
				return;
			}
			System.out.println(birth);
			break;
		default :
			System.out.println("외계인입니다.");
			break;
		}
		
		
	}

	private static String convert1(String birth) {
		//birth에서 yyyy, MM, dd을 문자열로 추출
		String year = birth.substring(0,4);
		String month = birth.substring(4,6);
		String day = birth.substring(6);
		return year + "-" + month + "-" + day;
		
	}
	
	private static String convert2(String birth) throws ParseException {
		//yyyyMMdd문자열을 날짜 객체로 변환
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date date = format1.parse(birth);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		//변환된 날짜 객체를 yyyy-MM-dd형태로 변환
		return format2.format(date);
	}


	private static boolean checkNum(String joomin) {
		
		
//		   if(joomin.matches(joomin)) { // // }
		 		 
		return true;
	}
}
