package dao;

import java.util.List;

import vo.Board;

public interface BoardDao {
	int write(Board board) throws Exception;
	int next() throws Exception;
	List<Board> list(int pagenum) throws Exception;
	boolean nextPage(int pagenum) throws Exception;
	Board detail(int bno) throws Exception;
	int update(Board board) throws Exception;
	int delete(int bno) throws Exception;
	int alldelete(String userId) throws Exception;

}
