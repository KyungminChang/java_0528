package day11;

public class Student {
	private String schoolName;
	protected String name;
	public int age;
	public String birthday;
	
	public void print(){
		System.out.println("학교 : " + schoolName);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("생일 : " + birthday);
	}
}
