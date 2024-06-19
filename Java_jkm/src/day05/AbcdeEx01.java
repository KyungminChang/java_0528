package day05;

public class AbcdeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char ch = 'a';
		for(int i = 1;i<=26;i++)
		{
			for(int j =0; j<i;j++)
			{
				ch += j;
				System.out.print(ch);
				ch ='a';
			}
			System.out.print("\n");
		}*/
		char ch1, ch2;
		for(ch1= 'a'; ch1 <= 'z';ch1++ )
		{
			for(ch2= 'a'; ch2 <=ch1; ch2++)
			{
				System.out.print(ch2);
			}
			System.out.println();
		}
		
		int [] arr = new int[] {1,2,3,4,5};

		for(int tmp : arr){

		System.out.println(tmp);

		}

	}

}
