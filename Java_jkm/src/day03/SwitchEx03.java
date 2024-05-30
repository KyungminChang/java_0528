package day03;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		double result;
		switch (operator) {
		case '+' :
			result = num1+num2;
			System.out.println("" + num1 +  operator + num2 + " = " + result);
			break;
		case '-' :
			result = num1-num2;
			System.out.println("" + num1 +  operator + num2 + " = " + result);
			break;
		case '*' :
			result = num1*num2;
			System.out.println("" + num1 +  operator + num2 + " = " + result);
			break;
		case '/' :
			result = (double)num1/num2;
			System.out.println("" + num1 +  operator + num2 + " = " + result);
			break;
		case '%' :
			result = (double)num1%num2;
			System.out.println("" + num1 +  operator + num2 + " = " + result);
			break;
			
		default : 
			System.out.println(operator  + " 는 산술연산자가 아닙니다. ");
			
	}
	}
}
