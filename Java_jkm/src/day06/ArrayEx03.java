package day06;

public class ArrayEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [10];
		for (int i=1;i<=9;i++)
		{
			int j=2;
			arr[i] = i*j;
			System.out.println(j + " X " + i + "= " + arr[i]);
		}
		
		int arr2[]= new int [10];
		for(int i=0;i<9;i++)
		{	
			int j =2;
			arr[i] = (i+1)*j;
			System.out.println(j + " X " + (i+1) + "= " + arr[i]);
			
		}
	}

}
