package db.day01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day02.ex01.dao.StudentDAO;
import lombok.AllArgsConstructor;
import lombok.Data;

public class dbEx01 {
	private static StudentDAO studentDao;
	public static PreparedStatement ps = null;
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
		}
		
	}
		public static void init() {
			String resource = "db/day02/ex01/config/mybatis-config.xml";
			InputStream inputStream;
			SqlSession session;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				session = sessionFactory.openSession(true);
				studentDao = session.getMapper(StudentDAO.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*
		insertStudent(2, 2, 1, "배철수");
		insertStudent(2, 2, 2, "박영희");
		
		if(updateStudent(1, 1, 4, 3, 3, 3, "김철수")) {
			System.out.println("수정했습니다.");
		} else {
			System.out.println("수정하지 못했습니다.");
		}
		
		if(deleteStudent(1, 1, 4)) {
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("삭제하지 못했습니다.");
		}*/
//		ArrayList<Student> list = selectStudent();
//		if(list == null) {
//			System.out.println("검색 중 문제가 발생했습니다.");
//			return;
//		}
//		if(list.size() == 0) {
//			System.out.println("검색 결과가 없습니다.");
//			return;
//		}
//		for(Student std : list) {
//			System.out.println(std);
//		}
//	}
//	public static ArrayList<Student> selectStudent() {
//		if(con == null) {
//			return null;
//		}
//		String sql = "select studentNum, grade, class, num, name from student";
//		try {
//			ps = con.prepareStatement(sql);	
//			ResultSet rs = ps.executeQuery();
//		
//			ArrayList<Student> list = new ArrayList<Student>();
//		while(rs.next()) {
//				int studentNum = rs.getInt(1);
//				int grade = rs.getInt(2);
//				int classNum = rs.getInt(3);
//				int num = rs.getInt(4);
//				String name = rs.getString(5);
//				Student std = new Student(studentNum, grade, classNum, num, name);
//				list.add(std);
//		}
//	}
//	}
	public static boolean deleteStudent(int grade, int classNum, int num) {
		if(con == null) { 
			return false;
		}
		String sql = "delete from student "
				+ "where grade = ? and class = ? and num = ?";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, grade);
			ps.setInt(2, classNum);
			ps.setInt(3, num);
			return ps.executeUpdate() !=0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean updateStudent(int oldGrade, int oldClass, int oldNum,
			int newGrade, int newClass, int newNum, String newName) {
		if(con == null) { 
			return false;
		}
		String sql = "update student set grade = ?, clss=?, num = ?, name=? "
				+ "where grade = ? and class = ? and num = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, newGrade);
			ps.setInt(2, newClass);
			ps.setInt(3, newNum);
			ps.setString(4, newName);
			ps.setInt(5, oldGrade);
			ps.setInt(6, oldClass);
			ps.setInt(7, oldNum);
			ps.executeUpdate();//정수값을 리턴. 반영된 행의 숫자가 리턴
			return ps.executeUpdate() !=0;
		} catch (SQLException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			return false;
		}
	}
	public static boolean insertStudent(int grade, int classNum, int num, String name) {
		if(con == null) {
			return false;
		}
		String sql = "insert into student(grade, class, num, name)"
				+ " values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, grade);
			ps.setInt(2, classNum);
			ps.setInt(3, num);
			ps.setString(4, name);
			ps.executeUpdate();//정수값을 리턴. 반영된 행의 숫자가 리턴
			return ps.executeUpdate() !=0;
		} catch (SQLException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			return false;
		}
	}
}

@Data
@AllArgsConstructor
class Student2{
	private int studentNum;
	private int grade, classNum, num;
	private String name;
	@Override
	public String toString() {
		return "" + studentNum + " : ["+ grade + "학년" + classNum + "반" + num + "번" +
				name + "이름]" + "";
	}
}


