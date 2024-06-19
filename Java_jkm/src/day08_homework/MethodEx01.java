package day08_homework;

import java.util.Arrays;

public class MethodEx01 {

	public static void main(String[] args) {
		/*배열에 랜덤으로 1~9 사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요
		 * 단, 메서드 이용
		 * MethodEx02, MethodEx02, day08.MethodEx05를 합친 예제*/
		int size = 6, min =1, max=45;
		int [] arr = createRandomArray(size,min,max);
		System.out.println(Arrays.toString(arr));

	}
	public static int random(int min, int max) {
		if(min>max) {
			int tmp =min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min +1) +min);
	}
	public static boolean contains(int [] arr, int count, int num)
	{
		if(arr==null) {
			return false;
		}
		if(count>arr.length)
		{
			count = arr.length;
		}
		
		for(int i=0;i<count;i++) {
			if(arr[i]==num) {
				return true;
			}
		}
		return false;
	}
	public static int [] createRandomArray(int size, int min, int max) {
		if(size <0) {
			return null;
		}
		if(min >max)
		{
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(size >= max-min+1)
		{
			return null;
		}
		
		int count = 0;//저장된 숫자의 개수
		int [] arr = new int [size];
		while(count<size) {
			int random = random(min,max);
			if(!contains(arr, count, random)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
}
