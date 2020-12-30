package co.company.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOMybatis {

	@Autowired SqlSession sqlSession;
	// 전체조회
	public List<Emp> getEmpList(){
		return sqlSession.selectList("EmpDAO.getEmpList");
	}
	// 단건조회
	public Emp getEmp (Emp emp) {
		return sqlSession.selectOne("EmpDAO.getEmp");
	}
}
