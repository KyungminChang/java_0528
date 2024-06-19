package day08;

import java.util.Arrays;

public class ArraySortEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = new String[] {"apple", "a", "zoo", "banana"};
		for(int i = 0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				//문자열.compareTo(문자열2) : 문자열1과 문자열 2를 알파벳순으로 배치했을 때 위치를 정수로 알려줌
				//같은 번지에 있는 문자들끼리 순서대로 비교
				//apple과 a를 비교하면 apple의 a와 a의 a를 비교하고 같으니까 다음 문자로 이동
				//apple의 p와 a의 다음이 없어서 a가 앞으로
				//같으면 0, 문자열 1이 앞이면 음수, 문자열 1이 뒤이면 양수
				if(arr[j].compareTo(arr[j+i])>0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
