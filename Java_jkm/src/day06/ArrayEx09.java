package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] list = {"dog", "cat", "java", "cup", "computer"};
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요
		Scanner sc = new Scanner(System.in);
		
		for(int tmp = 0; tmp<list.length;tmp++)
		{
			String str = sc.next();
			if(list[tmp].equalsIgnoreCase(str))
			{
				System.out.println("리스트에 있습니다.");
			}
			else if(list[tmp++].equalsIgnoreCase(str))
			{
				System.out.println("리스트에 있습니다.");
			}
			else {
				System.out.println("리스트에 없습니다.");
			}
		}
	}

}
