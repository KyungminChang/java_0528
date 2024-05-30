package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		if(age >= 19) {
			System.out.println("성인");
		}
		else {
			System.out.println("미성년자");
		}
	}

}
