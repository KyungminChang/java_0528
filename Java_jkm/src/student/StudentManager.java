package student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import day21.socket2.Contact;
import program.Program;

public class StudentManager implements Program {
	
	private List<Student> list = new ArrayList<Student>();
	private Scanner scan = new Scanner(System.in);
	private Object index;
	@Override
	public void run() {
		
		int menu;
		
		do {
			printMenu();
			
			menu = nextInt();
			
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu!=1);
	}
	
	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못 입력하면 (문자열) 정수의 가장 작은 수를 반환
	 * @return 입력한 정수 혹은 정수의 가장 작은 수
	 */
	@Override
	public void printMenu() {
		System.out.println(
				"메뉴\n"
				+ "1. 학생 관리\n"
				+ "2. 과목 관리\n"
				+ "3. 종료"
				+ "메뉴 선택 : ");
	}
	
	public int nextInt() {
		try {
			return scan.nextInt();
		} catch(InputMismatchException e){
			scan.nextLine();//잘못 입력한 값을 입력 버퍼에 비워줌
			return Integer.MIN_VALUE;//int의 가장 작은 수를 리턴
		}
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default :
			
		}
	}

	
	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);
		}while(menu != 5);
	}
	private void printStudentMenu() {
		System.out.print(
				"학생 관리 메뉴\n"
				+ "1. 학생 추가\n"
				+ "2. 학생 수정\n"
				+ "3. 학생 삭제\n"
				+ "4. 학생 조회\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}
	private void runStudentMenu(int menu) {
		switch(menu) {
		case 1:
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studentSearch();
			break;
		case 5:
			prev();
			break;
		default :
			
		}
	}

	private void studentInsert() {
		// 학생을 추가하는 기능을 구현하세요.
		Student std = inputStudentExpand();
		if(list.contains(std)) {
			System.out.println("이미 등록된 학년, 반, 번호입니다.");
			return;
		}
		list.add(std);
		System.out.println("학생이 추가되었습니다.");
	}
	/**
	 * 학년 반 번호 이름을 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return 학년, 반, 번호, 이름이 있는 만들어진 학생 객체
	 */
	public Student inputStudent() {
		System.out.println("학년, 반, 번호, 이름을 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade, classNum, num, "");
	}
	/**
	 * 학년 반 번호를 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return
	 */
	public Student inputStudentExpand() {
		Student std = inputStudent();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setName(name);
		return std;
	}

	private void studentUpdate() {
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);
		}while(menu!=5);
		
	}
	private void printStudentUpdateMenu() {
		System.out.println("학생 수정 메뉴\n"
				+ "1. 학생 정보 수정\n"
				+ "2. 성적 추가\n"
				+ "3. 성적 수정\n"
				+ "4. 성적 삭제\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	private void runStudentUpdateMenu(int menu) {
		
	}


	private void studentDelete() {
	
		Student std = inputStudent();
		if(list.remove(std)) {
			
			System.out.println("명단을 삭제했습니다.");
			return;
		}
		System.out.println("명단을 삭제하지 못했습니다.");
	}



	private void studentSearch() {
		Student std = inputStudent();
		
		//리스트에서 객체와 일치하는 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 0보다 작으면 객체에 null을 저장
		if(index < 0) {
			std = null;
		}
		//아니면 객체에 번지에 있는 객체를 가져옴=
		else {
			std = list.get(index);
			
		}
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다");
			return;
		}
		std.print();
	}

	private void prev() {
		// TODO Auto-generated method stub
		
	}

	private void subject() {
		int menu;
		do {	
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu();
			
		}while(menu!=5);
	}
	
	private void printSubjectMenu() {
		System.out.println("과목 관리 메뉴\n"
				+ "1. 과목 추가\n"
				+ "2. 과목 수정\n"
				+ "3. 과목 삭제\n"
				+ "4. 과목 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
		
	}

	private void runSubjectMenu() {
		// TODO Auto-generated method stub
		
	}

	private void exit() {
		
	}
	

}
