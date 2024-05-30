package day03;

public class NestedIfEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 18;
		if(num%3 ==0) {
			
			if(num%2 ==0) {
				System.out.println("6의 배수입니다.");
			}
			else {
				System.out.println("3의 배수입니다.");
			}
		}
	}

}
