package day12;

public class MathEx02 {

	public static void main(String[] args) {
		/*3.14를 소수점 2번째 자리에서 올림하는 코드를 작성하세여.*/
		double pi = 3.14;
		System.out.println(Math.ceil(change(pi))/10.0);
		
	}
	public static double change(double db) {
		db = db * 10;
		return db;
	}

}
