package day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import program.Program;

public class ContactManager implements Program{
	
	private List<Contact> list = new ArrayList<Contact>();
	private Scanner scan = new Scanner(System.in);
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	@Override
	public void printMenu() {
		System.out.println("----------------");
		System.out.println("메뉴\n"
				+ "1. 연락처 추가\n"
				+ "2. 연락처 수정\n"
				+ "3. 연락처 삭제\n"
				+ "4. 연락처 검색\n"
				+ "5. 프로그램 종료.\n"
				+ "메뉴 선택 : ");
		
	}

	

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		String fileName = "src/day17/contact.txt";
		
		
		load(fileName);
		
		int menu = INSERT;
		
		do {
			//메뉴 출력
			printMenu();
			try {
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴 실행
			runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();//입력 버퍼에 남은 값들을 비워 줌
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu!=EXIT);
		save(fileName);
	}
	
	@Override 
	public void save(String fileName) {
		//run()메소드에 추가한 샘플 데이터들을 이용해서 파일에 저장하는 코드를 작성하세요.
		try(FileOutputStream fos = new FileOutputStream(fileName);
	        ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis)){
				list = (List<Contact>)ois.readObject();
			} catch (Exception e) {
				System.out.println("불러오기 실패했습니다.");
			} 
	}
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
			break;
		}
		
	}



	private void update() {
		System.out.print("수정할 이름을 입력하세요. : ");
		scan.nextLine();
		String name = scan.nextLine();
		//이름과 포함된 연락처들을 리스트(A)로 받음
		List<Contact> tmps = list.stream()
             			.filter(c->c.getName().contains(name))
         				.collect(Collectors.toList());
		//검색 결과가 없는 경우
		if(tmps.size()==0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		//받은 리스트를 이용하여 출력(번호와 함께)
		for(int i = 0; i<tmps.size();i++) {
			System.out.println(i+1 +". " + tmps.get(i));
		}
		//번호를 선택
		System.out.println("번호 : ");
		int index = scan.nextInt()-1;
		//번호가 0미만이고 A.size()보다 크면 안내문구 출력 후 종료
		if(index<0 || index >= tmps.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//아니면 해당 객체를 가져옴
		Contact tmp = tmps.get(index);
		//이름, 번호를 입력받음
		
		System.out.print("수정할 이름을 입력하세요. : ");
		scan.nextLine();
		String newName = scan.nextLine();
		System.out.print("수정할 번호를 입력하세요. : ");
		String newNumber = scan.nextLine();
		//list에서 tmp를 제거한 리스트(원본은 그대로이어야 함)B를 가져옴
		List<Contact> copyList = list.stream().filter(c->c.equals(tmp)).collect(Collectors.toList());
		
		long count = copyList.stream().filter(c->c.getNumber().equals(newNumber)).count();
		
		if(count!=0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		
		list.remove(tmp);
		Contact newContact = new Contact(newNumber, newName);
		list.add(newContact);
		
		//리스트 B에 있는 연락처 중에서 입력한 번호와 같은 번호가 있는지 확인해서
		//있으면 안내문구 출력 후 종료
		//없으면 tmp를 제거 후 이름, 번호를 이용하여 객체 생성
		//리스트에 추가
		
	}



	private void delete() {
		//이름을 받고
		System.out.print("삭제할 이름을 입력하세요. : ");
		scan.nextLine();
		String name = scan.nextLine();
		//이름과 포함된 연락처들을 리스트(A)로 받음
		List<Contact> tmps = list.stream()
             			.filter(c->c.getName().contains(name))
         				.collect(Collectors.toList());
		//검색 결과가 없는 경우
		if(tmps.size()==0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		//받은 리스트를 이용하여 출력(번호와 함께)
		for(int i = 0; i<tmps.size();i++) {
			System.out.println(i+1 +". " + tmps.get(i));
		}
		//번호를 선택
		System.out.println("번호 : ");
		int index = scan.nextInt()-1;
		//번호가 0미만이고 A.size()보다 크면 안내문구 출력 후 종료
		if(index<0 || index >= tmps.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//아니면 해당 객체를 가져옴
		Contact tmp = tmps.get(index);
		//리스트에서 해당 객체와 같은 객체를 제거
		list.remove(tmp);
		
	}



	private void insert() {
		//이름, 번호를 입력
		System.out.print("이름을 입력하세요. :");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("번호를 입력하세요. :");
		String number = scan.nextLine();
		//등록된 번호가 있으면 이미 등록된 번호가 있습니다. 라고 출력하고 종료
		long count = list.stream().filter(c->c.getNumber().equals(number)).count();
		if(count>0)
		{
			System.out.println("이미 등록된 번호가 있습니다.");
			return;
		}
		Contact c = new Contact(name, number);
		
		//없으면 이름, 번호를 이용해서 객체를 생성한 후 리스트에 추가
		
		list.add(c);
		
		
	}



	private void search() {
		//원하는 단어를 입력하면 입력한 단어가 포함된 연락처를 콘솔에 출력하는 기능을 구현해보세요.
		System.out.print("검색할 단어를 입력하세요. : ");
		scan.nextLine();
		String search= scan.nextLine();
		
		long count =list.stream().filter(c->c.getName().contains(search)).count();
		if(count == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		
		list.stream().filter(c->c.getName().contains(search))
		.forEach(c->System.out.println(c));
		
	}
}
