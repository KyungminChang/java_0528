package day03;

import java.util.Scanner;

public class IfEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = scan.nextInt();
		
		if (num % 2 != 0) {
			System.out.println("홀수");
		}
		else {
			System.out.println("짝수");
		}
	}

}
