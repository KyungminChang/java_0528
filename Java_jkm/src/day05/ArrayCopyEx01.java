package day05;

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = new int[] {5,4,3,2,1};
		int [] arr2 = new int[arr1.length];
		for(int i = 0;i<arr1.length;i++)
		{
			arr2[i] = arr1[i];
		}
		for(int i = 0;i<arr1.length;i++)
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		//System.arraycopy를 이용한 배열 복사
		//src : 복사할 배열, srcPos : 복사할 배열의 시작번지
		//dest : 복사된 배열, destPos : 복사된 배열의 시작번지
		//length : 복사할 개수
		//System.arraycopy(src, srcPos, dest, destPos, length)를 이용하여 복사
		//-얕은 복사
		int [] arr3 = new int[arr1.length];
		System.arraycopy(arr1, 1, arr3, 0, arr1.length-1);
		for(int i =0;i<arr3.length;i++)
		{
			System.out.print(arr3[i]+ " ");
		}

	}

}
