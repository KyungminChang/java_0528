package day05;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~10 사이의 랜덤한 수 3개를 저장하고 출력하는 예제
		int min=1, max=10, i=0;
		int num = 0;
		
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [3];
		num = scan.nextInt();
		
		/*for (i=0; i<arr.length;i++)
		{
			int random = (int)(Math.random()*(max - min+1)+min);
			arr[i] = random;
			System.out.println(arr[i]);
			
			if(arr[i] == num)
			{
				break;
			}
		}
		if(i<arr.length)
		{
			System.out.println(num + "는 있습니다");
		}
		else
		{
			System.out.println(num + "는 없습니다");
		}*/
		boolean result = false;
		for(i=0;i<arr.length;i++)
		{
			arr[i] = (int)(Math.random()*(max - min+1)+min);
		}
		for(int tmp : arr)
		{
			System.out.println(tmp);
			if(tmp == num)
			{
				result = true;
				break;
			}
		}
		if(result == true)
		{
			System.out.println(num + "는 있습니다");
		}
		else
		{
			System.out.println(num + "는 없습니다");
		}

	}

}
