package day05;

public class ArrayEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int[3];
		int min = 1, max = 10;
		
		for(int i=0;i<array.length;i++)
		{
			int random = (int)(Math.random()*(max-min+1)+min);
			array[i]=random;
			System.out.println(array[i]);
		}
		
	}

}
