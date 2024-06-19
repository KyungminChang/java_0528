package day04;

public class NestedForEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, i, count = 0;
		for(num = 2; num <= 100; num ++)
		{
			for(i=1, count = 0; i<= num; i++)
			{
				if(num % 1 == 0)
				{
					count ++;
				}
					if(count == 2)
						
					{
						System.out.print(num + ", ");
					}
				}
			}
		}
}