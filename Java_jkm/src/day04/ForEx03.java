package day04;
import java.util.Scanner;
public class ForEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for( ; ; )
		{
			System.out.println("문자를 입력하세요. ");
			char ch = scan.next().charAt(0);
			if(ch == 'y')
			{
				break;
			}
		}
	}

}
