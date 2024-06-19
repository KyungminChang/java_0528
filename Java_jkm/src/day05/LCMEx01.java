package day05;

public class LCMEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lcm, num1 = 70000, num2 = 830000;
		/*for(int i=1;i>0;i++)
		{
			if (i % num1 == 0 && i%num2 == 0)
			{
				lcm = i;
				System.out.println(lcm);
				break;
			}
		}*/
		int tmp;
		if (num1 < num2)
		{
			tmp = num1;
			num1 =num2;
			num2= tmp;
		}
		for(int j = num1; ;j+=num1)
		{
			
			if (j%num2 == 0)
			{
				lcm = j;
				System.out.println(lcm);
				break;
			}
		}
	}

}
