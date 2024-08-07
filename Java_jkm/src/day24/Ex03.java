package day24;

public class Ex03 {

	public static void main(String[] args) {
		int num = 2;
		/*짝수라고 판별해야하는데 짝수, 홀수 모두 출력이 된
		 * 원인 : if문의 조건식 뒤에 ;이 있어 실행문이 실행되지 않는 경우
		 * 해결방법 : ; 제거
		 * 
		 */
		if(num % 2 == 0);{
			System.out.println("짝수");
		}
		if(num % 2 !=0); {
			System.out.println("홀수");
		}

	}

}
