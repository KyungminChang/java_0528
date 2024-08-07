package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/*문자열을 입력받아 exit가 아니면 입력한 문자열을 출력하고, exit 이면 종료하는 코드를 작성하려고 했다.
		 * 원인 : 1. res가 false 이기 때문에 반복문 실행이 되지않음
		 * 		 2. 문자열을 ==비교함
		 * 		 3. countinue를 만나면 다시 조건문이 실행되지 않고 반복문이 다시 실행되므로 
		 * 해결방법 : while의 조건식을 true로 만듦
		 * 			==를 equals로 수정
		 * 			조건문의 실행문을 break로
		 * */
		Scanner scan = new Scanner(System.in);
		boolean res = false;
		while(true) {
			System.out.println("문자열 입력 : ");
			String str = scan.next();
			System.out.println(str);
			if(str.equals("exit")) {
				break;
			}else {
				System.out.println(str.length());
			}
			
		}

	}

}
