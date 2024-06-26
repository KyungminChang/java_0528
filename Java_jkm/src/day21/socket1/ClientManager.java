package day21.socket1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ClientManager implements Program{
	private Scanner scan = new Scanner(System.in);
	private String fileName = "src/day21/socket1/client.txt";
	private List<String> list = new ArrayList<String>();
	private String ip = "192.168.30.207";
	private int port = 5001;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 속담 추가");
		System.out.println("2. 속담 삭제");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 :");
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			delete();
			break;
		case 3:
			print();
			break;
		}
	}

	private void insert() {
		//속담 입력
		System.out.print("속담 : ");
		scan.nextLine();
		String contents = scan.nextLine(); 
		//입력된 속담인지 확인해서 없으면 추가 후 알림
		if(!list.contains(contents.trim())) {
			list.add(contents.trim());
		}
	}
	private void delete() {
		print();
		
		System.out.print("삭제할 속담 선택 : ");
		int index = scan.nextInt() -1;
		try { 
			list.remove(index);			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 속담을 선택했습니다.");
		}
		
		
	}
	private void print() {
		if(list.size() == 0) {
			System.out.println("등록된 속담이 없습니다.");
			return;
		}
		for(int i = 0; i<list.size();i++) {
			System.out.println(i+1 + "." + list.get(i));
		}
		
	}



	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		int menu = 1;
		load();
		do {
			printMenu();
		
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
			
		}while(menu != 4);
		save();
		list.add("가는 말이 고와야 오는 말이 곱다.");
		list.add("누워서 떡 먹기.");
		list.add("윗 물이 맑아야 아랫물이 맑다.");
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
