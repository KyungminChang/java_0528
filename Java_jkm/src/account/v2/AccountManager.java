package account.v2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;


public class AccountManager implements Program {
	private Scanner scan = new Scanner(System.in);
	private AccountBook ab = new AccountBook();
	private String fileName = "src/account/v2/data.txt";
	private void printBar() {
		System.out.println("-------------------------------");
		
	}
	@Override
	public void printMenu() {
		System.out.print(
				  "--------메뉴---------\n"
				+ "1. 내역 입력\n"
				+ "2. 내역 수정\n"
				+ "3. 내역 삭제\n"
				+ "4. 내역 조회\n"
				+ "5. 종료\n"
				+ "-------------------\n"
				+ "메뉴 선택 : ");
		
	}

	@Override
	public void run() {
		int menu =1;
		load(fileName);
		do {
			printMenu();
			
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("메뉴는 정수입니다. 올바른 메뉴를 입력하세요");
			} catch (Exception e) {
				System.out.println("예외 발생");
			}
			
		}while(menu != 5);
		save(fileName);
		
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			exit();
			break;
		default:
			wrongMenu();
		}
		
	}

	private void insert() {
		// TODO Auto-generated method stub
		Item item = inputItem();
		if(item == null) {
			printBar();
			System.out.println("날짜를 잘못 입력했습니다.");
			return;
		}
		if(ab.insert(item)) {
			System.out.println("내역을 추가했습니다.");
		} else {
			System.out.println("잘못 입력된 내용이 있어서 내역을 추가하지 못했습니다.");
		}
	}
	private Item inputItem() {
		printBar();
		System.out.print("날짜 : ");
		String date = scan.next();
		System.out.print("수입/지출 : ");
		String type = scan.next();
		System.out.println("분류 목록");
		//수입 지출에 따라 분류를 출력하기 위해 타입에 맞는 카테고리를 선택 type.equals("수입")? AccountBook.incomeCategoryList : AccountBook.expensesCategoryList;
		List<String> tmpList = type.equals("수입")? AccountBook.incomeCategoryList : AccountBook.expensesCategoryList; 
		for(String category : tmpList) {
			System.out.println(category);
		}
		System.out.print("분류 : ");
		String category = scan.next();
		System.out.print("금액 : ");
		int amount = scan.nextInt();
		System.out.print("내용 : ");
		scan.nextLine();
		String contents = scan.nextLine();
		try {
			return new Item(date, type, category, amount, contents);
		} catch (ParseException e) {
			return null;
		}
	}


	private void update() throws ParseException {
		//1. 검색
		//날짜 입력
		System.out.println("날짜 : ");
		String date = scan.next();
		//날짜에 맞는 내역을 가져옴
		List<Item> selectList = null;
		selectList = ab.selectList(date);
		
		ab.search(selectList, p->true);
		//2. 수정할 내역 선택
		printBar();
		System.out.print("내역 선택 : ");
		int index = scan.nextInt() - 1;
		Item oldItem = selectItemByIndex(selectList, index);
		
		if(oldItem==null) {
			System.out.println("잘못된 번호를 입력했습니다.");
			return;
		}
		if(ab.delete(oldItem)){
			System.out.println("내역을 삭제했습니다.");
		} else{
			System.out.println("잘못된 값을 입력해서 내역을 수정하지 못했습니다.");
		}
		//정렬
		Collections.sort(selectList);
		printBar();
		System.out.println("내역을 수정했습니다.");
		
	}

	private Item selectItemByIndex(List<Item> selectList, int index) {
		try {
			return selectList.get(index);
		} catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
	}
	private void delete() throws ParseException {
		System.out.println("날짜 : ");
		String date = scan.next();
		//날짜에 맞는 내역을 가져옴
		List<Item> selectList = null;
		selectList = ab.selectList(date);
		
		ab.search(selectList, p->true);
		//2. 수정할 내역 선택
		printBar();
		System.out.print("내역 선택 : ");
		int index = scan.nextInt() - 1;
		//선택한 번호가 유요한 번호인지 체크
		Item oldItem = selectItemByIndex(selectList, index);
		if(ab.delete(oldItem)) {
			System.out.println("내역을 수정했습니다.");
		}else {
			System.out.println("잘못된 값을 입력해서 내역을 수정하지 못했습니다.");
		}
	}

	private void search() {
		ab.search(i->true);
	}

	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다.");
		printBar();
		
	}

	private void wrongMenu() {
		printBar();
		System.out.println("잘못된 메뉴를 선택했습니다.");
		
	}
	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(ab);
		} catch (Exception e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			ab = (AccountBook)ois.readObject();
		} catch (Exception e) {
		} 
	}

}
