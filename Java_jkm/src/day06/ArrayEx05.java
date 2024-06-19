package day06;

public class ArrayEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//100이하의 소수를 찾는 예제 : 에라토스테네스의 체
		int [] arr = new int[101]; // x : 1, o : 0
		arr[1] = 1;
		//2부터 에라토스테네스의 체를 이용하여 배열에 x 체크
		//2부터 100까지 x체크 안된 수를 출력
		
		for(int i=2;i<arr.length;i++)
		{	
			if(arr[i] ==1 ) {
				continue;
			}
			else {
			for(int j =2*i;j<arr.length;j+=i) {
				arr[j] = 1;
				}
			}
		}
		for(int i = 1;i<arr.length;i++)
		{
			if(arr[i] ==0) {
				System.out.print(" ," + i);
			}
			
		}
		//	1 		2 	3	4 			5 
		//arr[1] arr[2] arr[3] arr[4] arr[5]
	}

}
