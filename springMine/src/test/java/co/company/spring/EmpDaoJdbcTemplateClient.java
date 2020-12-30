package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpDAOJdbcTemplate;

// 어노테이션 2개 복붙해서 쓰기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class } )
public class EmpDaoJdbcTemplateClient {
	
	// 스캔해서 자동으로 쓸때는 component고, 주입받아서 쓰는건 autowired
	@Autowired EmpDAOJdbcTemplate empDAO;
	
	// 조회
	@Test
	public void empdaotest() {
		System.out.println(empDAO.getListMap());
	}
	
	// 등록
	@Test
	public void insert() {
		Emp emp = new Emp();
		emp.setEmployeeId("1002");
		emp.setLastName("aaaa");
		emp.setEmail("aa@aa.aa");
		empDAO.insert(emp);
	}
}
