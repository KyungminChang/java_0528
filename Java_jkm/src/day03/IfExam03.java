package day03;
import java.util.Scanner;

public class IfExam03 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		double result;
		char ch;
		System.out.println("두 정수와 산술 연산자를 입력하세요 :");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
		if(ch == '+')
		{
			result = num1 + num2;
			System.out.println(": " + (int)result);
		}
		else if(ch == '-')
		{
			result = num1 - num2;
			System.out.println(": " + (int)result);
		}
		else if(ch == '*')
		{
			result = (double)num1 * num2;
			System.out.println(": " + (int)result);
		}
		else if(ch == '/')
		{
			result = num1 / num2;
			System.out.println(": " + (int)result);
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
		}
	}

}
