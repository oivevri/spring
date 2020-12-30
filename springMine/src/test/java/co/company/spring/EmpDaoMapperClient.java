package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.config.MybatisConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class,
							MybatisConfiguration.class} )
public class EmpDaoMapperClient {
	@Autowired EmpMapper empDAO;

	// 등록 테스트
	//@Test
	public void insertTest() {
		Emp emp = new Emp();
		// employeeId는 자동으로.. selectKey 때문에 +1 되어서 들어갈걸
		emp.setFirstName("yoon");
		emp.setLastName("choi");
		emp.setEmail("104f@1dd.1jj1");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		emp.setJobId("IT_PROG");
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	
	// 프로시저를 이용한 등록 테스트
	//@Test
	public void insertProc() {
		Emp emp = new Emp();
		// employeeId랑 hireDate는 프로시저에 있어서 안해도됨
		emp.setLastName("choi");
		emp.setEmail("eff@hmd.tr");
		emp.setJobId("IT_PROG");
		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId() + ":" + emp.getMsg());
	}
	
	// 다건 삭제 테스트
	//@Test
	public void deleteMultiTest() {
		EmpSearch emp = new EmpSearch();
		emp.setList(new String[] {"1000","1001"});
		empDAO.deleteMultiEmp(emp);
	}
	
	// 수정테스트
	//@Test
	public void updateTest() {
		Emp emp = new Emp();
		emp.setEmployeeId("102");
		System.out.println(empDAO.getEmp(emp)); // 단건조회용
		
		emp.setFirstName("hong"); // 이름 update
		empDAO.updateEmp(emp); // 수정한걸 적용
		
		System.out.println(empDAO.getEmp(emp)); // 다시조회
	}
	
	// 전체조회
	//@Test
	public void emptestfull() {
		List<Emp> list = empDAO.getEmpList(null);
		for(Emp emp : list) {
			System.out.println(emp.getEmployeeId() + " : "
							+ emp.getLastName() + " : "
							+ emp.getDepartmentId() + " : "
							+ emp.getJobId());
		}
	}

	// 범위 조회
	// @Test
	public void empdaotest() {
		EmpSearch empvo = new EmpSearch();
		empvo.setMinSalary(8000);
		empvo.setMaxSalary(11000);
		List<Emp> list = empDAO.getEmpList(empvo);
		for(Emp emp : list) {
			System.out.println(emp.getEmployeeId() + " : "
							+ emp.getLastName() + " : "
							+ emp.getDepartmentId() + " : "
							+ emp.getJobId() + " : "
							+ emp.getSalary());
		}
	}
	
	// 전체 레코드 건수 조회 테스트
	//@Test
	public void countTest() {
		EmpSearch emp = new EmpSearch();
		List<Emp> list = empDAO.getEmpList(emp);
	}	
	
	// vo 대신 List<Map>사용
	@Test
	public void getStat() {
		List<Map<String, Object>> list = empDAO.getStatDept();
		System.out.println(list.get(0)); // 조회된 첫번째 결과
		System.out.println(list.get(0).get("deptName"));
	}
}
