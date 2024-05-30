package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score1, score2;
		double avg;
		String str1;
		Scanner scan = new Scanner(System.in);
		System.out.println("과목 1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.println("과목 2 성적 입력 : ");
		score2 = scan.nextInt();		
		/*avg = (score1 + score2) / 2.0;
		str1 = avg>=60 && (score1 >= 40 && score2 >=40) ? "합격" : "불합격"; 
		System.out.println("결과 : " + str1);
		*/
		int sum = score1 + score2;
		avg = (double)sum / 2; 
		boolean isFail = score1 < 40 || score2 < 40;
		String result = avg >= 60 && !isFail ? "합격" : "불합격";
		
		System.out.println(result);
	}

}
