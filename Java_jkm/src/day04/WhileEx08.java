package day04;
import java.util.Scanner;
public class WhileEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int gcd = 0;
		int num1 , num2;
		System.out.println("1번 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		System.out.println("2번 정수를 입력하세요 : ");
		num2 = scan.nextInt();
		int i = 1;
		while(i<=num2) {
			if(num1%i == 0 && num2%i == 0)
			{gcd = i;}
			i++;
		}
		System.out.println(gcd);
	}

}
