package day05;

import java.util.Scanner;

public class ArrayEx02 {
	public static void main(String[] args) {
		int [] scores1 = new int[3];
		int sum = 0;
		double avg;
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 3명의 점수를 입력하세요.");
		for(int i=0;i<scores1.length;i++)
		{
			System.out.println("학생" +(i+1) +"의 성적 : ");
			scores1[i] = scan.nextInt();
			sum += scores1[i];
			
		}
		for(int i=0;i<scores1.length;i++)
		{
			System.out.println("학생" +(i+1) + "의 성적 :  "+ scores1[i]);
		}
		avg = sum /(double)scores1.length;
		System.out.println("세 학생의 평균은" + avg + " 입니다.");
	}
}
