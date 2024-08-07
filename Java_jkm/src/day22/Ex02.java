package day22;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/*정수로 이루어진 문자열에서 각 정수들의 합을 구하는 코드를 작성하세요*/
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 문장 입력 : ");
		String str = scan.nextLine();
		System.out.println(str);
		String[] words = str.split(" ");
		System.out.println("단어의 개수 : " + words.length);
		int sum = parseInt(words);
		System.out.println(sum);
	}
	/*위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는 코드를 메소드로 만들어 보세요*/
	private static int parseInt(String [] words) {
		
		int sum = 0;
		for(int i=0;i<words.length;i++) {
			int number = Integer.parseInt(words[i]);
			
			sum +=number;
		}
		return sum;
	}

}
