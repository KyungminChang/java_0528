package day04;
import java.util.Scanner;
public class BreakEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("문자 입력 : ");
			ch = scan.next().charAt(0);
			if(ch == 'y')
			{
				break;
			}
		}
	}

}
