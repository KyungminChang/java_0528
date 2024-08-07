package day20;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ipEx01 {

	public static void main(String[] args) {
		String add;
		//xxx.xxx.xxx.xxx : Ipv4
		try {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			String add1 = InetAddress.getLocalHost().getHostAddress();
			System.out.println(add1);
			add = InetAddress.getLocalHost().getHostAddress();
			InetAddress [] list = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(list));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
