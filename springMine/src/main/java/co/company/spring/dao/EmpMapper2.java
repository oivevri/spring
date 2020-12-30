package co.company.spring.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper2 {
// 매개변수는 emp_mapper.xml 의 파라미터타입과 같아야한다
	public List<Emp> getEmpList(EmpSearch emp); // 전체조회
	public int getCount(EmpSearch emp); // 전체 레코드 조회
	// 이건 전체조회랑 같은 파라미터가 넘어가야함!!! 둘이 같이 묶어서 쓰기!!
	public Emp getEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int insertEmp(Emp emp);
	public int deleteEmp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public void insertEmpProc(Emp emp);
	public List<Map<String,Object>> getStatDept();
	// 단건이면 그냥 Map, 여러건이면 List<Map>
}
