package day04;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		char ch = 'a';
		while(ch!='y')
		{	
			System.out.print("문자를 입력하세요" );
			ch = scan.next().charAt(0);

		}
	}

}
