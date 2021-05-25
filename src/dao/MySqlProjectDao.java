package dao;

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
	public List<Project> selectList() throws Exception {

		SqlSession sqlSession =sf.openSession();

		try {
			
			return sqlSession.selectList("dao.ProjectDao.selectList");

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
			int count = sqlSession.update("dao.ProjectDao.update",project);
			sqlSession.commit();
			return count;
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
