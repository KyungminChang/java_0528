package day03;

public class SwitchEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		
		switch (num) {
		case 3, 4, 5 :
			System.out.println("봄");
		break;
		case 6, 7, 8 :
			System.out.println("여름");
		break;
		case 9, 10, 11 :
			System.out.println("가을");
		break;
		case 1, 2, 12 :
			System.out.println("겨울");
		break;
		default : 
			System.out.println("잘못된 월");
		}
	}

}
