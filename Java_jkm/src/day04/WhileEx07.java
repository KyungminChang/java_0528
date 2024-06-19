package day04;

import java.util.Scanner;

public class WhileEx07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int j = scan.nextInt();
		while(i <= j)
		{
			if(j%i ==0) 
			count ++;
			i++;
		}
		System.out.println(count);
		if(count == 2)
		{
			System.out.println("소수입니다.");
		}
		else System.out.println("소수가 아닙니다.");
		
	}

}
