package vo;

import java.sql.Timestamp;
public class Board {

	private int bno;
	private String title;
	private String content;
	private String writer; 
	private Timestamp createTime;
	
	
	
	
	public int getBno() {
		return bno;
	}
	public Board setBno(int bno) {
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Board setTitle(String title) {
		return this;
	}
	public String getContent() {
		return content;
	}
	public Board setContent(String content) {
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public Board setWriter(String writer) {
		return this;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public Board setCreateTime(Timestamp createTime) {
		return this;
	}
	
	
	
}
