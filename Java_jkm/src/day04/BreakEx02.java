package day04;

public class BreakEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 8, num2 = 12;
		
		double gcd = num1;
		while(gcd>0) {
			if(num1%gcd == 0 && num2%gcd ==0) {
				break;
			}
			gcd--;
		}
		System.out.println(gcd);
	}

}
