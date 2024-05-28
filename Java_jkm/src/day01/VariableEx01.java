package day01;

public class VariableEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char ch1; //문자형 변수 ch1을 선언
		char ch2 = 'A';
		//문자형 변수 ch3 과 ch4를 선언
		
		char ch3, ch4;
		char ch5 ='+', ch6 = '\\';
		System.out.println(ch2);
		System.out.println(ch6);
		System.out.println(ch5);
		
		long num1 = 1234567890123L;//정수값이 int형으로 표현되지 않으면 접미사를 반드시 붙여야 함
		float num2 = 3.14f;//3.14는 double이기 때문에 반드시 접미사를 붙여야 함
		double num3 = 3.14;
		boolean isEven = true; // true, false는 소문자만 가능
	}

}
