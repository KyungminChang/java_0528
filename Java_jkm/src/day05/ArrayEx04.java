package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [3];
		for(int i = 0; i <arr.length ; i++)
		{
			arr[i] = scan.nextInt();
		}
		for(int i = 0; i<arr.length;i++)
		{
			System.out.println(arr[arr.length-1 -i] + " ");
		}
		
		for(int i = arr.length-1; i>=0;i--)
		{
			System.out.println( arr[i] + " ");
		}

	}

}
