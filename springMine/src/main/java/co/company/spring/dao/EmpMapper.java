package co.company.spring.dao;

import java.util.List;
import java.util.Map;


public interface EmpMapper {

   public List<Emp> getEmpList(EmpSearch emp);
   public int deleteEmp(Emp emp);
   public int deleteMultiEmp(EmpSearch emp);
   public int insertEmp(Emp emp);
   public void insertEmpProc(Emp emp);
   public int getCount();
   public Emp getEmp(Emp emp);
   public List<Job> jobSelect();
   public List<Department> departmentSelect();
   public List<Map<String,Object>> getStatDept();
   public int updateEmp(Emp emp);
}
