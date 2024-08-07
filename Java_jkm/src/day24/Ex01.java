package day24;

public class Ex01 {

	public static void main(String[] args) {
		int num1 =4;
		double num2 = num1;
		
		//원인 : num2는 실수형인 double 자료형이기 때문에 정수형인 num3에 num2를 저장하기 위해서는 int타입으로 형변환해야한다.
		int num3 = (int)num2;

	}

}
