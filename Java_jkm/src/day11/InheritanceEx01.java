package day11;

public class InheritanceEx01 {

	public static void main(String[] args) {
		// 상속 예제
		HighSchoolStudent std = new HighSchoolStudent();
		std.print();
		std.setAge(10);
		std.print();
	}

}

class Student1{
	
	//학교명, 이름, 나이, 생일
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

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class HighSchoolStudent extends Student1{
	
	public void test() {
		//System.out.println(schoolName));//접근 제어자가 private이여서 자식 클래스에서 사용할 수 없다.
		System.out.println(name);//접근 제어자가 preotectesd이여서 자식 클래스에서 사용할 수 없다.
		System.out.println(age);//접근 제어자가 private이여서 자식 클래스에서 사용할 수 없다.
		System.out.println(birthday);//생일은 접근제어자가 public 이여서 자식 클래스에서 사용할 수 있다.
	}
	
}
/*class A{
	Student s1 = new Student();
	
}*/
