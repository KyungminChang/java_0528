package day05;

public class StarEx04 {

	public static void main(String[] args) {
		char star = '*';
		for(int i = 1;i<=5;i++)
		{
			for(int j =1; j<=5-i;j++)
			{
				System.out.print(" ");
			}
			for(int j =1; j<=i;j++)
				
			{
				System.out.print(star);	
			}
			for(int j =1; j<=i-1;j++)
			{
				System.out.print(star);	
			}
			System.out.print("\n");
		}

	}

}