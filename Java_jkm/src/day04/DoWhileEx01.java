package day04;

import java.util.Scanner;

public class DoWhileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		char ch;
		do {
			System.out.println("문자를 입력하세요 ");
			ch = scan.next().charAt(0);
		}while(ch != 'y');

	}

}
