package day02;

public class ComparisonOperatorEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 20;
		System.out.println("" + num1 + "<" + num2 + " : " + (num1<num2));
		System.out.println("" + num1 + ">" + num2 + " : " + (num1>num2));
		System.out.println("" + num1 + "<=" + num2 + " : " + (num1<=num2));
		System.out.println("" + num1 + ">=" + num2 + " : " + (num1>=num2));
		System.out.println("" + num1 + "==" + num2 + " : " + (num1==num2));
		System.out.println("" + num1 + "!=" + num2 + " : " + (num1!=num2));
		
		String str1 = "abc", str2 = "abc", str3 = new String("abc");
		System.out.println("" + str1 + "==" + str2 + " : " + (str1==str2));
		//같은 리터럴을 저장하기 때문에 주소가 같음
		System.out.println("" + str1 + "==" + str2 + " : " + (str1==str3));
		//str3은 리터럴이 아닌 방법으로 저장하기 때문에 주소가 다름
		System.out.println("" + str2 + "==" + str2 + " : " + (str2==str3));
		//str3은 리터럴이 아닌 방법으로 저장하기 때문에 주소가 다름
		//문자열은 equals를 이용하여 비교해야 함.
		System.out.println("" + str1 + "==" + str2 + " : " + (str1.equals(str2)));
		System.out.println("" + str1 + "==" + str2 + " : " + (str1.equals(str3)));
		System.out.println("" + str2 + "==" + str2 + " : " + (str2.equals(str3)));
		
		
	}

}
