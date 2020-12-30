package co.company.spring.dao;

import lombok.Data;

@Data
public class EmpSearch extends Emp {
	Integer minSalary;
	Integer MaxSalary;
	// 페이지 처리
	Integer first;
	Integer last;
	// 선택 다건 삭제용 -> forEach 돌릴용
	String[] list; // 
}
