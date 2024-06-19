package day05;

public class RandomEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min =1, max = 7;
		int random = (int)(Math.random() * (max - min +1) + min);
		System.out.println("랜덤 수 : " + random);
	}

}
