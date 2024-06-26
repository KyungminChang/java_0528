package day20.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx01 {

	public static void main(String[] args) {
		String ip = "192.168.30.207";//서버 IP
		int port = 5001;
		Scanner scan = new Scanner(System.in);
		//1. 소켓을 생성하고 대기
		System.out.println("[서버 연결 요청]");
		try(Socket socket = new Socket(ip, port)) {
			System.out.println("[서버 연결 완료]");
			//서버로 문자열 전송
			System.out.println("[전송 요청]");
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			System.out.print("전송할 내용 : ");
			String send = scan.nextLine();
			oos.writeUTF(send);
			oos.flush();
			System.out.println("[전송 완료]");
			
			//서버에서 문자열 수신
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String reseive = ois.readUTF();
			System.out.println("서버 : " + reseive);
			System.out.println("[수신 완료]");
			oos.close();
			ois.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
