package day02;

public class ConditionalOperatorEx01 {
	public static void main(String []args) {
		int age = 20;
		String result = (age>=19) ? "성인" : "미성년자";
		System.out.println(age + "살은 " + result + "입니다.");
	}
}
