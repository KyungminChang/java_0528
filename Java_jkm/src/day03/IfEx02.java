package day03;

import java.util.Scanner;

public class IfEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = scan.nextInt();
		
		if (num % 2 != 0) {
			System.out.println("홀수");
		}
		//else는 현 위치에서 위에 있는 연결된 조건문들이 모두 거짓이면 
		else {
			System.out.println("짝수");
		}
	}

}