package day04;

public class WhileEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = 0;
		while(i<11)
		{
			if(i%2 == 0)
			j+=i;
			
			i++;
		}
		System.out.println(j);
	}

}
