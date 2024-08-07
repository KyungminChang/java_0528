package db.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class dbEx02 {
	
	public static Statement st = null;
	public static Connection con = null;
	public static void main(String[] args) {
		//MySQL 설치 시 port 번호를 수정하지 않았다면 3306
		String db = "student"; //연결할 db를 선택
		String url = "jdbc:mysql://localhost:3306/student";
		String id = "root";
		String pw = "root";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e){
				
		} catch (ClassNotFoundException e){
				System.out.println("드라이버를 찾을 수 없습니다.");
				return;
		}
//		if(updateStudent(1, 1, 4, 3, 3, 3, "김철수")) {
//			System.out.println("수정했습니다.");
//		} else {
//			System.out.println("수정하지 못했습니다.");
//		}
		if(deleteStudent(1, 1, 4)) {
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("삭제하지 못했습니다.");
		}
		ArrayList<Student> list = selectStudent();
		if(list == null) {
			System.out.println("검색 중 문제가 발생했습니다.");
			return;
		}
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(Student std : list) {
			System.out.println(std);
		}
	}
	
	
		/*
		insertStudent(2, 2, 1, "배철수");
		insertStudent(2, 2, 2, "박영희");
		
		*/
//	}
	public static ArrayList<Student> selectStudent() {
		if(con == null) {
			return null;
		}
		String sql = "select studentNum, grade, class, num, name from student";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Student> list = new ArrayList<Student>();
			while(rs.next()){
					int studentNum = rs.getInt(1);
					int grade = rs.getInt(2);
					int classNum = rs.getInt(3);
					int num = rs.getInt(4);
					String name = rs.getString(5);
					Student std = new Student(studentNum, grade, classNum, num, name);
					list.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
		
	}
	public static boolean deleteStudent(int grade, int classNum, int num) {
		if(con == null) { 
			return false;
		}
		String sql = "delete from student "
				+ "where grade = "+grade+" and class = "+classNum+" and num = "+num;
	
		try {
			st = con.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	public static boolean updateStudent(int oldGrade, int oldClass, int oldNum,
			int newGrade, int newClass, int newNum, String newName) {
		if(con == null) { 
			return true;
		}
		String pattern = "update student set grade = {0}, clss={1}, num = {2}, name=\"{3}\" "
				+ "where grade = {4} and class = {5} and num = {6}";
		String sql = MessageFormat.format(pattern, newGrade, newClass, newNum, newName, oldGrade, oldClass, oldNum);
		try {
			st = con.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			return true;
		}
	}
	public static boolean insertStudent(int grade, int classNum, int num, String name) {
		if(con == null) {
			return false;
		}
		String sql = "insert into student(grade, class, num, name)"
				+ " values("+grade+", "+classNum+", "+num+", '"+name+"')";
		try {
			st = con.createStatement();
			st.execute(sql);//정수값을 리턴. 반영된 행의 숫자가 리턴
			return st.execute(sql) != false;
		} catch (SQLException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			return false;
		}
	}
}


