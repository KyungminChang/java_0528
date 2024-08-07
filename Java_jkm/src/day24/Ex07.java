package day24;

public class Ex07 {

	public static void main(String[] args) {
		/*1부터 10까지의 합을 구하려고 했다
		 * 원인 : 반복문의 조건식 뒤에 ;이 붙어 반복문의 실행문이 실행되지 않은채로 조건식대로 i가 11까지 10번 증가함
		 * 해결방안 : ; 지우기*/
		int i;
		int sum = 0;
		for (i=1;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1부터 10까지 합 : " + sum);
	}

}
