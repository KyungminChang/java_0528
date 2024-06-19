package day14;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class PhoneManager implements Program {
	
	private Contact [] list = new Contact[10];
	private int count;
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 5;
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			expend();
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
			System.out.println("잘못된 메뉴입니다.");
		}
	}



	private void expend() {
		//다 찼는지 확인해서 안 찼으면 종료
		if(list.length > count) {
			return;
		}
		Contact[] tmp = new Contact[list.length +10];
		System.arraycopy(list, 0, tmp, 0, list.length);
		list = tmp;
		//찼으면 10개를 추가
	}

	private void search() {
		System.out.println("검색할 이름을 작성하세요(전체 검색 : 엔터");
		scan.nextLine();
		String name = scan.nextLine();
		printContact(name);
	}

	private void delete() {
		System.out.println("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		if(!printContact(name)){
			return;
		};
		int index =scan.nextInt() - 1;
		if(!checkContact(name, index)) {
			System.out.println("잘못 선택했습니다.");
			return;
			
		}
		if(index != count) {
			Contact [] tmp = new Contact[list.length];
			System.arraycopy(tmp, index+1, list, index, count - index);
		}
		//중간 삭제 
		list[count] = null;
		System.out.println("연락처를 삭제했습니다.");
		
		return;
	}

	@Override
	public void run() throws Exception {
		String fileName = null;
		//불러오기
		load(fileName);
		int menu = EXIT + 1;
		do {
			printMenu();
			
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("메뉴를 잘못 입력했습니다.");
				scan.next();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Arrays.toString(list));
			
		}while(menu != EXIT);{
			
		}
		//저장하기
		//save(fileName)
		
	}
	
	private void insert() throws Exception{
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.println("번호 : ");
		String number = scan.nextLine();
		//입력한 정보를 이용하여 객체를 생성
		Contact contact = new Contact(name, number);
		//연락처 리스트에 입력한 번호 객체가 있는지 없는지 확인해서
		int index = indexOf(contact);
		if(index >= 0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		list[count] = contact;
		count++;
		System.out.println("등록이 완료되었습니다.");
	}

	

	private void update() throws Exception {
		scan.nextLine();// 공백 처리
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//연락처 리스트에서 이름과 일치하는 연락처를 번지 + 1과 함께 출력
		if(!printContact(name)) {
			return;
		}
		//번호 선택
		int index =scan.nextInt() -1;
		//번호가 올바르지 않으면 잘못 선택했습니다 하고 종료
		boolean res = checkContact(name, index);
		if(!res) {
			System.out.println("잘못 선택했습니다.");
			return;
		}
		scan.nextLine();
		System.out.println("이름 : ");
		String newName = scan.nextLine();
		System.out.println("번호 : ");
		String newNumber = scan.nextLine();
		
		Contact contact = new Contact(newName, newNumber);
		//생성된 객체가 중복된 번호이면 안내문구 출력하고 아니면 객체를 추가
		if(indexOf(contact) >=0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		list[index] = contact;
		
	}
	private int indexOf(Contact contact) {
		return indexOf(-1, contact);
	}
	private int indexOf(int index, Contact contact) {
		if(list == null || count == 0) {
			return -1;
		}
		for(int i = 0;i<count;i++) {
			if(i == index) {
				continue;
			}
			if(list[i].equals(contact)) {
				return i;
			}
		}
		return -1;
	}



	private boolean checkContact(String name, int index) {
		if(list==null || count == 0) {
			return false;
		}
		if(index < 0 || index >= count) {
			return false;
		}
			
		return list[index].getName().contains(name);
	}

	private boolean printContact(String name) {
		if(list == null || count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return false;
		}
		int sameCount = 0;//이름과 일치하는 연락처 개수 => 없는 경우 안내문구를 위해
		for(int i = 0;i<count;i++) {
			if(list[i].getName().equals(name)) {
				System.out.println(i+1+list[i].toString());
				sameCount++;
			}
		}
		if(sameCount == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return false;
		}
		System.out.println(Arrays.toString(list));
		return true;
	}

	@Override
	public void load(String fileName) {
		if(fileName == null) {
			System.out.println("불러올 파일이 없습니다.");
			Contact list [] = new Contact[1];
			return;
		}
		//추후 파일 입력 출력을 배우면 불러오는 기능을 구현
	}
	
}
