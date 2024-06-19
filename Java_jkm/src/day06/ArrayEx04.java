package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4자리 정수를 입력받아 입력받은 정수를 역순으로 배열에 저장하고, 출력하는 코드
		int arr[] = new int [4];
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("4자리 정수를 입력하세요 : ");
		num = scan.nextInt();
		if(num<1000 && num >9999)
		{
			System.out.println("4자리 정수가 아닙니다.");
		}
		else {
				int tmp = num;
				int i= 0;
				while(tmp !=0) {
					arr[i++] = tmp %10;
					tmp = tmp/10;
			}
				for(int tmp2 : arr)
				{
					System.out.print(tmp2);
				}
		}
		
	}

}
