package controls;

import java.util.Map;

import dao.BoardDAO;


public class BoardListController implements Controller {
	BoardDAO boardDao;
	
	public BoardListController setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int pagenum =1;
		model.put("boards", boardDao.list(pagenum));
		return "/board/BoardList.jsp";
	}

}
