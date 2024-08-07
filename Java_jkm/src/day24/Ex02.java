package day24;

public class Ex02 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		double res = (double)num1/num2;
		/*1/2 =0.5 가 출력되지 않음
		 *원인 : num1/num2는 정수형으로 나타나기 때문에
		 *해결방법 : num1/num2를 실수 자료형인 double 타입으로 형변환 해줘야한다.*/
		System.out.println(num1 + " / " + num2 + " = " + res);

	}

}
