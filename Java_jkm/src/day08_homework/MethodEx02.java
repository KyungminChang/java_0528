package day08_homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("배열 크기 입력 : ");
		Scanner scan = new Scanner(System.in);
		int size=scan.nextInt();
		int [] arr = createArray(size);
		System.out.println(Arrays.toString(arr));
		int [] arr2 = new int[size];
		createArray2(arr2, size);
		System.out.println(Arrays.toString(arr2));
		
	}
	public static int [] createArray(int size) {
		if(size <0) {
			return null;
		}
		int [] arr = new int[size];
		return arr;
		//return new int [size];
	}
	public static void createArray2(int [] arr, int size) {
		//=을 통해 기본형 변수나 참조형 변수를 재할당하면 main에 있는 원본이 바뀌지 않는다
		arr = new int [size];
	}
}
