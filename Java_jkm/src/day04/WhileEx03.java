package day04;

public class WhileEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		int j = 1;
		while(i<10)
		{
			while(j<10) {
				System.out.println(i + " * " + j + " = " + i*j);
				j++;
			}
			j=1;
			i++;
		}
		
	}

}
