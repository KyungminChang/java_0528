package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		/*리스트에 숫자들을 저장하고, 저장된 숫자들을 정렬하는 코드를 작성하세요.*/

		List<Integer> list = new ArrayList<Integer>();
		
		String[] nums = {"1", "7", "8", "9", "2", "10"};
		for(int i = 0;i<nums.length;i++) {
			int number = Integer.parseInt(nums[i]);
			list.add(number);
		}
		list.sort(null);
		System.out.println(list);
		list.sort(Collections.reverseOrder());
		//Collections.reverse(); => 요소들을 역순으로 배치
		Collections.sort(list, (i1, i2)-> i2 -i1);
		System.out.println(list);
	}

}
