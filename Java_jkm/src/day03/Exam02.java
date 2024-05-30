package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int score1, score2, score3, totalScore;
		double average;
		System.out.print("학생1 성적 입력 : ");
		score1 = scan.nextInt();
		System.out.print("학생2 성적 입력 : ");
		score2 = scan.nextInt();
		System.out.print("학생3 성적 입력 : ");
		score3 = scan.nextInt();
		totalScore = score1  + score2 + score3;
		average = totalScore / 3.0 ;
		System.out.println("총점 : " + totalScore + "평균 : " + average);
		
	}

}
