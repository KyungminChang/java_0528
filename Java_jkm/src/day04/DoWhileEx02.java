package day04;

import java.util.Scanner;

public class DoWhileEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 프로그램 실행");
			System.out.println("2. 프로그램 저장");
			System.out.println("3. 프로그램 불러오기");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택: ");
			i = scan.nextInt();
		}while(i !=4);
		if(i == 4)
		{
			System.out.println("프로그램울 종료합니다.");
		}
	}

}
