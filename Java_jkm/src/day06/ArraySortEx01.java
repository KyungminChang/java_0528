package day06;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {1,3,5,7,9,2,4,6,8,10};
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j = 0; j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int tmp= 0;
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=tmp;
				}
			}
			
		}
		for(int tmp : arr) {
			System.out.print(tmp);
		}
	}

}
