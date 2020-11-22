package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public UserDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/pgh";
			String id = "root";
			String pw = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("db 연동 성공");
		}catch(Exception e) {
			System.out.println("db 연동 실패");
			e.printStackTrace();
		}
	
	}
	
	public int login(String userID, String userPassword) {
		
		String sql = "select password from user where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			System.out.println("select 시도");
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					System.out.println("로그인 성공");
					return 1; //로그인 성공
				}	
				else
					System.out.println("비밀번호가 틀림");
					return 0; // 비밀번호 불일치
			}
			System.out.println("아이디가 없음");
			return -1; //아이디가 없음
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs != null) rs.close();	
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return -2; // 데이터 베이스 오류
	}
	
	public void join(String id, String pw , String name, String email, String gender) {
		
		String sql = "insert into user(id, password, name, email,gender) values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, gender);
			
			int n = pstmt.executeUpdate();
			if(n==1) {
			System.out.println("회원가입 성공");
			}else
				System.out.println("회원가입 실패임");
		}catch(Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
