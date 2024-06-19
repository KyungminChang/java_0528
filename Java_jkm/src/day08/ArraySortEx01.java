package day08;

import java.util.Arrays;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 버블정렬 시간 복잡도는 O(n) = n의 2제곱 
		int [] arr = new int[] {1,6,3,2,9,10,4,5};
		
		for(int i = 0;i<arr.length-1;i++)
		{
			for(int j =0;j<arr.length-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
