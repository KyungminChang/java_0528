package day02;

public class ConditionalOperatorEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건 연산자
		// num가 짝수이면 짝수 홀수이면 홀수
		int num = 4;
		String str = num % 2 == 0 ? "짝수" : "홀수" ; 
		System.out.println(num + "은 " + str + "입니다.");
		
	}

}
