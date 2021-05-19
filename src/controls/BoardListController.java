package controls;

import java.util.Map;

import board.BoardDAO;

public class BoardListController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDAO boardDAO = (BoardDAO) model.get("boardDao");
		int pagenum =1;
		model.put("boards", boardDAO.list(pagenum));
		return "/board/BoardList.jsp";
	}

}
