package day15;

import java.util.HashSet;

public class Ex03 {

	public static void main(String[] args) {
		/*1~10사이의 랜덤한 수 6개를 중복되지 않게 생성해서 저장하고 출력하는 코드를 작성하세요.
		 *set을 활용
		 *size() 
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		int max = 10, min = 1;
		while(set.size()<6) {
			int random = (int)(Math.random()*(max-min+1)+min);
			set.add(random);
		}
		System.out.println(set);
		
	}

}
