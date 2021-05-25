package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.BoardDao;
import vo.Board;
@Component("/board/add.do")
public class BoardAddController implements Controller, DataBinding {
	BoardDao boardDao;
	
	public BoardAddController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"board", vo.Board.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Board board = (Board) model.get("board");
		if(board.getTitle() == null) {
			return "/board/BoardForm.jsp";
		}else {
			boardDao.write(board);
			return "redirect:list.do";
		}
	}

}
