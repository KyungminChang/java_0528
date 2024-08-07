package day24;

public class Ex04 {

	public static void main(String[] args) {
		int score = 80;
		/*A를 판별하는 코드를 작성했는데, A가 아닌 경우에도 A가 출력
		 *원인 : 조건식의 || 가 첫번째 조건식을 만족하거나 두 번째 조건식을 만족하면 실행되는 or 연산자이기 때문에  
		 *해결 방안 : && and 연산자로 변경*/
		
		//if(score <= 90);
		
		if(score >= 90 || score <=100) {
			System.out.println("A");
		}
		

	}

}
