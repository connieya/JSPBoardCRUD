package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.ProjectDao;
import vo.Project;

@Component("/project/add.do")
public class ProjectAddController implements Controller , DataBinding {

	ProjectDao projectDao;
	
	public ProjectAddController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
			Project project = (Project) model.get("project");
		if(project.getTitle() == null) {
			return "/project/ProjectForm.jsp";
		}else {
			projectDao.insert((Project) model.get("project"));
			return "redirect:/index.jsp";
		}
	}


	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"project",vo.Project.class
		};
	}

}
