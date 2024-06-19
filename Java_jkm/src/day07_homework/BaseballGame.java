package day07_homework;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		// 랜덤한 수를 생성(중복되지 않게 1~9사이의 3개의 수)
		//반복문을 이용하여 정수 3개를 입력 받은 후 판별 (다 맞출 때까지)
		
		int [] list = new int[3];
		int count = 0;
		int max = 9, min = 1;
		int random, i;
		while(count < 3) {
			random = (int)(Math.random()*((max -min +1 )+ min));
			for(i=0;i<count; i++)
			{
				if(list[i] == random)
				{
					break;
				}
			}
			if(i== count) {
				list[count] = random;
				count++;
			}
			
			
		}
		System.out.println(Arrays.toString(list));
		Scanner scan = new Scanner(System.in);
		//입력 안내문구 출력
		
		int [] user = new int [3];
		int s=0, b=0;
				//3개를 입력
				//결과 판별 후 출력
				//첫번 째 랜덤수와 첫번째 입력값이 같으면 스트라이크 또는 볼로 판별
				//첫번 째 랜덤수와 두번째 입력값이 같으면 스트라이크 또는 볼로 판별
				//첫번 째 랜덤수와 세번째 입력값이 같으면 스트라이크 또는 볼로 판별
					//두번 째 랜덤수와 첫번째 입력값이 같으면 스트라이크 또는 볼로 판별
					//두번 째 랜덤수와 두번째 입력값이 같으면 스트라이크 또는 볼로 판별
					//두번 째 랜덤수와 세번째 입력값이 같으면 스트라이크 또는 볼로 판별
				//세번 째 랜덤수와 첫번째 입력값이 같으면 스트라이크 또는 볼로 판별
				//세번 째 랜덤수와 두번째 입력값이 같으면 스트라이크 또는 볼로 판별
				//세번 째 랜덤수와 세번째 입력값이 같으면 스트라이크 또는 볼로 판별
		do{
			
		s=0;
		b=0;
		System.out.print("입력 : ");
		
		for(int j = 0;j<user.length;j++) {
			user[j] = scan.nextInt();
		}
		for(int p=0;p<list.length;p++) {
			for(int k =0;k<user.length;k++) {
				if(list[p]==user[k]) {
					if(p==k)
						{
						s++;
						}
					else {
						b++;
					}
				}
				
			}
		}
		if(s!=0)
		{
			System.out.print(s+ "S");
		}
		if(b!=0)
		{
			System.out.print(b+ "B");
		}
		if(s==0&&b==0)
		{
			System.out.print("O");
		}
		System.out.println();
		}while(s!=3);
		System.out.println("정답입니다");
		//위치가 같으면 스트라이크의 개수를 다르면 볼의 개수를 증가
	}

}
