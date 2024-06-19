package day08;

public class MeThodEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*주어진 정수 num3가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 단, 메서드를 이용해서*/
		boolean result;
		int num3 = 70;
		isPrime(num3);
		
	}

	public static void isPrime(int num1) {
		/*boolean isPrime = true;
		// i : num에 나눌 값, for문을 한 바퀴 돌 때마다 1씩 증가한다.
        // 변수 i를 num/2만큼만 반복하게 해서 반복횟수를 줄인다.
		for(int i = 2; i <= num1/2; i++) {
        	// 순차적으로 i를 num에 나누어본다.
			if(num1%i == 0) {
            	// num이 i로 나눠져 나머지가 0이 되면 isPrime에 false(소수가 아님)을 입력한다.
				isPrime = false;
                // 이미 1과 자기자신 외에 다른 수로도 나눠져 합성수임을 알았으므로 더 이상 반복하지 않고 빠져나온다.
				break;
			}
		}*/
	
		int [] arr = new int[num1]; // x : 1, o : 0
		arr[1] = 1;
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
	}
	public static boolean isPrime2(int num) {
		if (num==1) {
			return false;
		}
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
	}
}
