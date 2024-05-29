package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 콘솔창에서 원하는 값을 읽어와서 변수에 저장하는 예제
		 * println(값) : 값을 출력하고 엔터
		 * print(값) : 값을 출력
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요. ");
		int num = scan.nextInt();
		System.out.println(num);
		
		System.out.print("실수를 입력하세요. ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.println("문자열(단어)를 입력하세요 : ");
		String str1 = scan.next();
		System.out.println("단어 : " + str1);
		
		scan.nextLine();
		System.out.print("문자열(문장)를 입력하세요 : ");
		String str2 = scan.nextLine();//엔터까지 한 문장을 가져와서 엔터 전까지 저장 함
		System.out.println("문장 : " + str2);
		/*next()를 통해서 문자열을 가져오고, String 클래스에서 제공하는 charAt(번지) 기능을 통해
		 * 0번지 (첫번째) 글자를 가져옴*/
		System.out.println("문자를 입력하세요 : ");
		char ch = scan.next().charAt(0);
		System.out.println("문자 : " + ch);
		
	}

}
