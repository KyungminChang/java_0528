package day02;

public class IncrementOperatorEx01 {
	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		++num1;
		num2++;
		System.out.println("num1 : "+ num1);
		System.out.println("num2 : "+ num2);
		
		//System.out.println("증가 전 num1 : "+ num1);
		//System.out.println("증가 전 num2 : "+ num2);
		num1++;
		System.out.println("증가 전 num1 : "+ ++num1);
		System.out.println("증가 전 num2 : "+ num2++);
		num2++;
		System.out.println("증가 전 num1 : "+ num1);
		System.out.println("증가 전 num2 : "+ num2);
	}
}
