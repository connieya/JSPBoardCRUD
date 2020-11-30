package board;

import java.sql.Timestamp;

import user.User;

public class Board {

	private int bno;
	private String title;
	private String content;
	private String writer; //작성자를 User에 있는 Id로 연동하고 싶어서
	// User 타입형을 가져왔다.
	private Timestamp createTime;
	
	
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
}
