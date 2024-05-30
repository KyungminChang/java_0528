package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("성적을 입력하세요. ");
		int num = scan.nextInt();
		char grade;
		if(num > 100 || num < 0)
		{
			System.out.println("잘못된 성적입니다.");
		}
		else if(num >=90 && num <= 100) {
			grade = 'A';
			System.out.println(grade);
		}
		else if(num >=80 && num < 90) {
			grade = 'B';
			System.out.println(grade);
		}
		else if(num >=70 && num < 80) {
			grade = 'C';
			System.out.println(grade);
		}
		else if(num >=60 && num < 70) {
			grade = 'D';
			System.out.println(grade);
		}
		else if(num < 60) {
			grade = 'F';
			System.out.println(grade);
		}
	}

}
