package day24;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1 + 2 의 결과를 출력하기위해 다음과 같이 작성했다.
		 * 원인 : 리턴값이 없는 객체 메소드를 int 주소에 저장하려했다
		 * 결과 : int를 지운다*/
		sum(1,2);
	}
	public static void sum (int num1, int num2) {
		System.out.println(num1+num2);
	}
}
