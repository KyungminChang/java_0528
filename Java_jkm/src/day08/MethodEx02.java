package day08;

public class MethodEx02 {

	public static void main(String[] args) {
		/* 두 수의 최대 공약수와 최소 공배수를 구하는 코드를 작성하세요. 단, 메서드 이용*/
		int num1=24, num2=44;
		boolean isDivisor;
		isDivisor = isDivisor(num1 ,num2);
		
		System.out.println(isDivisor);
		System.out.println(gcd(num1, num2));
		System.out.println(lcm(num1, num2));
		System.out.println(lcm2(num1, num2));
	}
	public static boolean isDivisor (int num1, int num2)
	{	
		return num1%num2==0;
	}
	public static int gcd (int num1, int num2)
	{	
		if(num1>num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		for(int i=num1;i>=1;i--)
		{
			//i가 공약수이면
			if(isDivisor(num1, i)&&isDivisor(num2,i)) {
				return i;
			}
		
		}
		int gcd=0;
		return gcd;
	}
	public static long lcm (int num1, int num2) {
		for(int i=num1; i<num1*num2;i+=num1)
		{
			if(isDivisor(i,num2)) {
				return i;
			}
		}
		return num1*num2;	
	}
	public static long lcm2(int num1, int num2) {
		return num1 * num2 / gcd(num1,num2);
	}
}
