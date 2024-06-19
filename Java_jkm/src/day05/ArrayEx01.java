package day05;

public class ArrayEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//지역변수는 자동으로 초기화 된다(x)
		int score1, score2, score3,score4,score5;
		score1 =90;
		System.out.println(score1);
		//배열은 자동으로 자료형에 맞는 초기화가 된다(O)
		//배열은 참조형.
		int [] scores1 = new int [5];
		int scores2 [] = new int [5];
		//5개짜리 배열을 만들어서 1,2,3,4,5 순서대로 초기화
		int scores3 [] = new int [] {1,2,3,4,5};
		//scores1 배열에 0번지에 1, 1번지에 2, 2번지에 3, 3번지에 4, 4번지에 5를 저장

		
		for(int i=0;i<5;i++)
		{
			scores1[i]= i+1; 
			System.out.println(scores1[i]);
		}
		

		
		
	}

}
