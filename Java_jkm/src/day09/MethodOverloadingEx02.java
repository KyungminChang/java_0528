package day09;

public class MethodOverloadingEx02 {
	/*메서드 오버로딩 조건
	 * 1. 매개변수의 개수가 다름
	 * 2. 매개변수의 타입이 다름 */
	public static void main(String[] args) {
		

	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static double sum(double num1, double num2 ) {
		return num1 +num2;
	}
	
	public static int sum(int num1, int num2, int num3) {
		return num1+ num2+ num3;
	}

}
