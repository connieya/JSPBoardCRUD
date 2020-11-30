package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public BoardDAO() {

	
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
	
	public int write(String title, String userID, String content) {
		
		String sql = "insert into board(title,content,writer) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, userID);
			pstmt.setString(3, content);
			System.out.println("글 등록 성공");
			return pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("글쓰기 실패");
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return -1; // DB 오류
	}
	
	public ArrayList<Board> list(){
		
		String sql = "select * from board";
		ArrayList<Board> boardList = new ArrayList<Board>();		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setCreateTime(rs.getTimestamp(5));
				
				boardList.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return boardList;
	}

}
