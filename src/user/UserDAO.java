package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.Board;

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
	
	//mysql에서 auto increment 쓰지않고 회원 no 숫자 1씩 증가시키기
	public int next() {
		
		String sql = "select no from user order by no desc";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			
			return 1; // 게시글이 하나도 없어서 첫번째 게시물인 경우
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1; // 데이터베이스 오류
	}
	
	public int login(String userID, String userPassword) {
		String sql = "select password from user where id = ?";	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}	
				else
					return 0; // 비밀번호 불일치
			}
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
	
	public int join(User user) {
		
		String sql = "insert into user values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, next());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getEmail());
			
			return pstmt.executeUpdate();
			
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
		return -1; //데이터 베이스 오휴
	}
	
	public int update(User user) {
		
		String sql = "update user set name = ? , password =? , email =? where id =? ";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return -1;
	}
	
	public User userDetail(String id) {
		
		String sql = "select * from user where id= ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setEmail(rs.getString(5));
				return user;
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int delete(String id) {
		
		String sql ="delete from user where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return -1;
		
	}
	
}
