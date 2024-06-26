package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/*리스트에 문자열을 5개 입력받아 저장하는 예제
		 * */
		Scanner scan = new Scanner(System.in);
		
		List<String> list = new ArrayList<String>();
		System.out.print("문자열을 5개 입력하세요 : ");
		for(int i=1;i<=5;i++) {
			String tmp= scan.next();
			list.add(tmp);
		}
		System.out.println(list);
		/*문자열 A를 입력받아 리스트에 A를 포함하는 문자열들을 출력하는 예제 */
		//1. 문자열 A를 입력을 받아 변수에 저장
		System.out.println("문자열 입력 : ");
		String search = scan.next();
		//2,반복문을 이용하여 전체 탐색 : 향상된 for문 이용하는게 좋음
		for(String tmp : list) {
			if(tmp.contains(search)) {
				System.out.println(tmp);
			}
		}
			//2-1. 리스트에서 꺼낸 문자열에 문자열 A가 포함되어 있으면 문자열을 출력
	}

}
