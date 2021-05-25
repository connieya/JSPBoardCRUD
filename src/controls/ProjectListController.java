package controls;

import java.util.Map;

import annotation.Component;
import dao.ProjectDao;

@Component("/project/list.do")
public class ProjectListController implements Controller {

	ProjectDao projectDao;
	
	public ProjectListController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		model.put("project", projectDao.selectList());
		return "/project/ProjectList.jsp";
	}

}
