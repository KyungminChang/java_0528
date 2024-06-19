package day08;

public class MethodEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*매개변수의 이름과 인수의 이름이 같지 않아도 상관없다.*/
		int a = 1, b = 2;
		int num1 = 1, num2 = 2;
		
		System.out.println(sum(a,b));
		System.out.println(sum(1,2));
		System.out.println(sum(num1,num2));
		
		System.out.println("num1 : "+ num1 + ", num2 : "+ num2);
		swap(num1,num2);
		System.out.println("num1 : "+ num1 + ", num2 : "+ num2);
		

	}
	public static int sum(int num1, int num2)
	{
		return num1+num2;
	}
	//복사본을 이용하기 때문에 매개변수의 값이 매서드 안에서 바뀌어도 메서드를 호출한 곳에서는 안 바뀜
	public static void swap(int num1, int num2)
	{
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}

}
