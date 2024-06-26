package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

	public class ClientManager implements Program {
	private Scanner scan = new Scanner(System.in);
	private String fileName = "src/day21/socket2/client.txt";
	private int port = 5001;
	private String ip = "192.168.30.207";
	private List<String> list = new ArrayList();
	private int menu = 0;
	@Override
	public void printMenu() {
		System.out.print("메뉴\n" 
				+"1. 연락처 추가\r\n"
				+"2. 연락처 수정\r\n"
				+"3. 연락처 삭제\r\n"
				+"4. 연락처 확인\r\n"
				+"5. 프로그램 종료\r\n"
				+"메뉴 선택\r"
				);
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1 : 
			break;
		case 2 : 
			break;
		case 3 : 
			break;
		case 4 : 
			break;
		}
		
	}

	@Override
	public void run() throws Exception {
		printMenu();
		try {
			menu = scan.nextInt();
			runMenu(menu);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	public void load() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<String>)ois.readObject();
		} catch (Exception e) {
			load(fileName);
		}
	}
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				list = (List<String>)ois.readObject();
			} catch (Exception e) {
				System.out.println("불러오기에 실패했습니다.");
			} 
	}
	public void save() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			
		} finally { 
			save(fileName);
		}
	}
	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(list);
			} catch (Exception e) {
				
			}
	}

}
