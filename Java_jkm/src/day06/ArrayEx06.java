package day06;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/*4과목의 성적을 입력받아 배열에 저장하고, 과락이 없고  평균이 60점이 넘으면 Pass 아니면 Fail 출력*/
		int [] arr = new int [4];
		Scanner scan = new Scanner(System.in);
		int score = 0, sum = 0;
		double avg = 0;
		for(int i = 0;i<arr.length;i++)
		{
			System.out.print("과목 "+(i+1) + " 성적을 입력하세요. :");
			score = scan.nextInt();
			arr[i] = score;
		}
		for(int tmp : arr)
		{
			sum += tmp;
		}
		avg = (double)sum / arr.length;
		boolean isFail = false;
			
			for(int tmp : arr)
				if(tmp <40) {
					isFail = true;
					break;
				}
				else {
					isFail = false;
				}
		if(!isFail && avg>=60)
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}

}
