package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1;
		System.out.println("숫자를 입력하세요. ");
		num1 = scan.nextInt();
		/*if(num1 % 6 == 0 )
		{
			System.out.println("6배수 입니다.");
		}
		else if(num1 % 3 == 0 )
		{
			System.out.println("3배수 입니다.");
		}
		
		else if(num1 % 2 == 0 )
		{
			System.out.println("2배수 입니다.");
		}
		*/
		if(num1 % 2 == 0 && num1 % 3 !=0 )
		{
			System.out.println("2배수 입니다.");
		}
		else if(num1 % 3 == 0 && num1 % 2 !=0 )
		{
			System.out.println("3배수 입니다.");
		}
		
		else if(num1 % 2 == 0 && num1 % 3 ==0)
		{
			System.out.println("6배수 입니다.");
		}
		
		
	}

}
