package controls.project;

import java.util.HashMap;
import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import controls.Controller;
import dao.ProjectDao;

@Component("/project/list.do")
public class ProjectListController implements Controller, DataBinding {

	ProjectDao projectDao;
	
	public ProjectListController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderCond", model.get("orderCond"));
		model.put("project", projectDao.selectList(paramMap));
		return "/project/ProjectList.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"orderCond",String.class
		};
	}

}
