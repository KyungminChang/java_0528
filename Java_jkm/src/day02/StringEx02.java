package day02;

public class StringEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = 1 +"안녕2";
		String str2 = "1안녕" + 2;
		
		System.out.println(str1);
		System.out.println(str2);
		String str3 = 1 + 2 + "3";
	//정수 1과 2가 더해진 후 문자열 3과 더해지기 때문에 3 + "3"이 되고 결국 "33"이 됨
		String str4 = "1" + 2 + 3;
	//문자열 1과 정수 2가 더해진 후 정수 3이 더해지기 때문에 "12" + 3이 되고, 결국 "123"이 됨
		System.out.println(str3);
		System.out.println(str4);
		
	}

}
