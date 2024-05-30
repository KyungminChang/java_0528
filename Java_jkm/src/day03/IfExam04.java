package day03;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1;
		System.out.println("숫자를 입력하세요. ");
		num1 = scan.nextInt();
		if(num1%3 == 0)
		{
			System.out.println("3의 배수입니다.");
		}
		else{
			System.out.println("3의 배수가 아닙니다.");
		}

	}

}
