package day03;

public class SwitchEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 3;
		switch(num % 2) {
		case 0:
			System.out.println("짝수");
			break;
		default : 
			System.out.println("홀수");
		}
	}

}
