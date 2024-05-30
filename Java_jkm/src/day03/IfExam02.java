package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int munth;
		System.out.println("월을 입력하세요.");
		munth = scan.nextInt();
		
		if(munth >=3 && munth <= 5)
		{
			System.out.println("봄");
		}
		else if(munth >=6 && munth <= 8)
		{
			System.out.println("여름");
		}
		else if(munth >=9 && munth <= 11)
		{
			System.out.println("가을");
		}
		else if(munth >=1 && munth < 3 || munth == 12)
		{
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월");
		}
	}

}
