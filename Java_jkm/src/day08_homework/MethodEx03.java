package day08_homework;

import java.util.Arrays;

public class MethodEx03 {

	public static void main(String[] args) {
		/*1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요.
		 * 단, 메서드를 이용*/
		/*int [] arr = new int [3];
		int max =9,min=1, random=0;
		
		createRandomArray2(arr, max, min);
		for(int tmp : arr)
		{
			System.out.println(tmp);
		}*/
		int size = 5;
		System.out.println(random(9,1));
		int []arr = createRandomArray(size, 1, 9);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void createRandomArray2(int[] arr, int max, int min) {
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (int)(Math.random()*((max - min +1)+min));
		}
	}
	public static int random(int min, int max) {
		if(min>max) {
			int tmp =min;
			min = max;
			max = tmp;
		}
		int random = (int)(Math.random() * (max - min +1) +min);
		return random;
		//return (int)(Math.random() * (max - min +1) +min);
	}
	public static int [] createRandomArray(int size, int min, int max) {
		if(size<0) {
			return null;
		}
		int [] arr =new int [size];
		for(int i=0;i<size;i++)
		{
			arr[i] = random(min, max);
		}
		return arr;
	}

}
