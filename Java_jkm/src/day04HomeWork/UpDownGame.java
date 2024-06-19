package day04HomeWork;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* 1~100 사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을 작성하세요.
		 * 예(랜덤한 수가 30)
		 * 정수 입력 : 50
		 * DOWN!
		 * 정수 입력 : 20
		 * UP!
		 * 정수 입력 : 30
		 * 정답입니다!
		 */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		System.out.print("1~100 사이 정수 입력 : " );
		int insert = scan.nextInt();
		while(random != insert)
		{
			if(random < insert)
			{
				System.out.println("DOWN!");
			}
			else if(random > insert)
			{
				System.out.println("UP!");
			}
			System.out.print("정수 입력 : " );
			insert = scan.nextInt();
			
		}
		System.out.print("정답입니다!" );
	}

}
