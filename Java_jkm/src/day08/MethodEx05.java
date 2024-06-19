package day08;

import java.util.Scanner;

public class MethodEx05 {

	public static void main(String[] args) {
		/* 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단 메서드를 이용하여
		 */
		int [] arr = new int [] { 1, 4, 6, 7, 9, 10};
		int num = 6;
			if(content(arr, num)) {
				System.out.println(num + "는 있는 정수입니다.");
			}
			else {
				System.out.println(num + "는 없는 정수입니다.");
			}
		}
	
	public static boolean content(int []arr, int num) {
		boolean result;
		
		if(arr == null)
		{
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp)
			{
				return true;
			}
		}
		return false;
		
	}
}
