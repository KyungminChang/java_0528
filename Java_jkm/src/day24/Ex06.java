package day24;

public class Ex06 {

	public static void main(String[] args) {
		/*1부터 10까지 출력하는 코드를 작성하려고 했다.
		 * 원인: 조건식에 증감식이 없어 i가 0으로 고정되어 무한반복
		 * 해결방안 : 조건식에 i++을 추가한다
		 * */
		for(int i = 0;i<=10;) {
			System.out.println(i);
		}

	}

}
