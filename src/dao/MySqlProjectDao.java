package dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Project;

public class MySqlProjectDao implements ProjectDao {
	SqlSessionFactory sf;
	
	public void setSqlSessionFactory(SqlSessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public List<Project> selectList(HashMap<String, Object> paramMap) throws Exception {

		SqlSession sqlSession =sf.openSession();

		try {
			
			return sqlSession.selectList("dao.ProjectDao.selectList",paramMap);

		} finally {
			sqlSession.close();
		}

	}

	@Override
	public int insert(Project project) throws Exception {
		SqlSession sqlSession =sf.openSession();

		try {
			int count = sqlSession.insert("dao.ProjectDao.insert",project);
			return count;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public Project selectOne(int no) throws Exception {
		SqlSession sqlSession =sf.openSession();
		try {
			return sqlSession.selectOne("dao.ProjectDao.selectOne",no);
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(Project project) throws Exception {
		SqlSession sqlSession = sf.openSession();
		try {
			Project original = sqlSession.selectOne("dao.ProjectDao.selectOne", project.getNo());
			
			Hashtable<String, Object> paramMap = new Hashtable<String, Object>();
			
			if(!project.getTitle().equals(original.getTitle())){
				paramMap.put("title", project.getTitle());
			}
			if(!project.getContent().equals(original.getContent())){
				paramMap.put("content", project.getContent());
			}
			if(!project.getStartDate().equals(original.getStartDate())){
				paramMap.put("startDate", project.getStartDate());
			}
			if(!project.getEndDate().equals(original.getEndDate())){
				paramMap.put("endDate", project.getEndDate());
			}
			if(project.getState() !=(original.getState())){
				paramMap.put("state", project.getState());
			}
			if(!project.getTags().equals(original.getTags())){
				paramMap.put("tags", project.getTags());
			}
			if(paramMap.size()>0) {
				paramMap.put("no", project.getNo());
				int count = sqlSession.update("dao.ProjectDao.update",paramMap);
				sqlSession.commit();
				return count;
			}else {
				return 0;
			}
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int delete(int no) throws Exception {
		SqlSession sqlSession = sf.openSession();
		try {
			int count = sqlSession.delete("dao.ProjectDao.delete",no);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
	}

}
