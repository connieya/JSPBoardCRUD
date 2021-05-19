package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import board.Board;
import util.DBConnectionPool;

public class UserDAO {
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	//mysql에서 auto increment 쓰지않고 회원 no 숫자 1씩 증가시키기
	public int next() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no from user order by no desc";
		
		try {
			connection = ds.getConnection();
			 pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1; // 게시글이 하나도 없어서 첫번째 게시물인 경우
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (rs!=null) rs.close();} catch(Exception e) {}
			try{if (pstmt!=null) rs.close();} catch(Exception e) {}
			try{if (connection!=null) connection.close();} catch(Exception e) {}
		}
	
		return -1; // 데이터베이스 오류
	}
	
	public User login(String userID, String userPassword) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from user where id = ?";	
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return new User()
							.setEmail(rs.getString("email"))
							.setName(rs.getString("name")); //로그인 성공
				}	
				else
					return null; // 비밀번호 불일치
			}
			return null; //아이디가 없음
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs != null) rs.close();	
			if(pstmt !=null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{if (connection!=null) connection.close();} catch(Exception e) {}
			
		}
		
		return null; // 데이터 베이스 오류
	}
	
	public int join(User user) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into user values(?,?,?,?,?,?)";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
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
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{if (connection!=null) connection.close();} catch(Exception e) {}
			
		}
		return -1; //데이터 베이스 오휴
	}
	
	public int update(User user) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update user set name = ? , password =? , email =? where id =? ";
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try{if (pstmt!=null) pstmt.close();} catch(Exception e) {}	
			try{if (connection!=null) connection.close();} catch(Exception e) {}	
		}
		
		return -1;
	}	
	public User userDetail(int no) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where id= ?";
		try {
			connection = ds.getConnection();
			 pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User()
						.setId(rs.getString("id"))
						.setName(rs.getString("name"))
						.setEmail(rs.getString("email"))
						.setGender(rs.getString("gender"))
						.setNo(rs.getInt("no"))
						.setPassword(rs.getString("password"));
				return user;
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if (pstmt!=null) pstmt.close();} catch(Exception e) {}	
			try{if (connection!=null) connection.close();} catch(Exception e) {}	
		}
		return null;
	}
	
	public int delete(String id) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="delete from user where id=?";
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try{if (pstmt!=null) pstmt.close();} catch(Exception e) {}	
			try{if (connection!=null) connection.close();} catch(Exception e) {}	
		}		
		return -1;	
	}	
}
