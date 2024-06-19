package day09;

import java.util.Scanner;

public class StudentEx01 {
	/*학생 성적을 관리하기 위한 프로그램 예제 : 국어, 영어, 수학*/
	public static void main(String[] args) {
		/*다음 메뉴가 출력되도록 코드를 작성하세요. 
		 * 메뉴
		 * 1. 학생 등록
		 * 2. 성적 수정
		 * 3. 성적 확인
		 * 4. 종료
		 * 메뉴 선택 : 
		 * */
		Scanner scan = new Scanner(System.in);
		int select=0;
		int stdCount =0;//저장된 학생 수
		Student [] std  = new Student[10];
		int index;
		do {
			printMenu();
			select = scan.nextInt();
				switch(select)
				{
					case 1 : 
						
						//학년, 반, 번호, 이름을 입력받고
						//입력받은 정보를 이용하여 학생 객체를 생성
						//생성한 학생 객체를 배열에 저장하고
						//저장된 학생수를 1 증가
						stdCount = insertStudent(std,scan,stdCount);
						
					case 2:
	                    updateStudent(std,stdCount,scan);
	                case 3:
	                	printStudent(std,stdCount,scan);
					case 4 : 
						System.out.println("프로그램 종료입니다.");
						break;
					default : 
						System.out.println("잘못된 메뉴입니다.");
				}
		}while(select!=4);

	}
	public static void printMenu() {
		System.out.println("메뉴 ");
		System.out.println("1. 학생 등록 ");
		System.out.println("2. 성적 수정 ");
		System.out.println("3. 성적 확인 ");
		System.out.println("4. 종료 ");
		System.out.print("메뉴 선택 : ");
	}
	public static void runMenu(int select)
	{
		//String [] arr = 
	}
	public static int indexOf(Student[] list, int count, Student std) {
		if(list == null || std == null) {
			return -1;	
		}
		//학년이 같고 반이 같고 번호가 같으면 i를 리턴
		for(int i = 0;i<count;i++) {
			if(std.getGrade() != list[i].getGrade()) {
				continue;
			}
			if(std.getClassNum() != list[i].getClassNum()) {
				continue;
			}
			if(std.getNum() != list[i].getNum()) {
				continue;
			}
			return i;
		}
		return -1;
	}
	public static Student inputStudent(Scanner scan) {
		System.out.print("학년 : ");
        int grade = scan.nextInt();
        System.out.print("반 : ");
        int classNum = scan.nextInt();
        System.out.print("번호 : ");
        int num = scan.nextInt();
		return new Student(grade,classNum,num,"");
	}
	public static int insertStudent(Student [] list, Scanner scan, int studentCount) {
		if(studentCount == list.length)
		{
			System.out.println("다 찼습니다.");
			return studentCount;
		} 
		
		Student temp = inputStudent(scan);
		System.out.print("이름 : ");
		String name = scan.next();
		temp.setName(name);
		int index = indexOf(list, studentCount, temp);
		if(index != -1) {
			System.out.println("이미 등록된 학생입니다.");
			return studentCount;
		}
		list[studentCount] = temp;
		return studentCount +1;
	}
	public static void updateStudent(Student [] list,  int studentCount, Scanner scan) {
		Student temp = inputStudent(scan); 
        int index = indexOf(list, studentCount, temp);
        if(index == -1) {
        	System.out.println("일치하는 학생이 없습니다.");
        	return;
        }
        System.out.print("국어 성적 : ");
        int kor = scan.nextInt();
        System.out.print("영어 성적 : ");
        int eng = scan.nextInt();
        System.out.print("수학 성적 : ");
        int math = scan.nextInt();
        //std[index].updateScore(kor,eng,math);
       
        list[index].updateScore(kor, eng, math);
	}
	public static void printStudent(Student [] list,  int studentCount, Scanner scan) {
		Student temp = inputStudent(scan); 
		int index = indexOf(list, studentCount, temp);
		if(index == -1) {
		System.out.println("일치하는 학생이 없습니다.");
			return ;
		}
		list[index].print();
	}
	/*
	public static Student findStudent(Student[] std, int grade, int classNum, int num) {
        for (Student student : std) {
            if (student != null &&
                student.getGrade() == grade &&
                student.getClassNum() == classNum &&
                student.getNum() == num) {
                return student;
            }
        }
        return null;
    }*/
}

class Student{
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	public Student() {}
	/*기능 : 국어, 영어, 수학 성적이 주어지면 변경하는 메소드*/
	public Student(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void updateScore(int kor, int eng, int math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	public void print() {
		System.out.println(grade+ "학년" +  classNum+ " 반" +num +" 번호" + name);
		System.out.println("국어" +  kor+ " 영어" +eng +" 수학" + math);
	}
	
}

