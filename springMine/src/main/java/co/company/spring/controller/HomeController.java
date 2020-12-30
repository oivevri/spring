package co.company.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@Controller
public class HomeController {

	@Autowired EmpMapper empMapper;
	// 아작스로 할려면 	@ResponseBody
	@RequestMapping("/empListajax")
	@ResponseBody
	public List<Emp> empListAjax(EmpSearch emp) {
		return empMapper.getEmpList(emp);
	}
	
	@RequestMapping("/empList")
	public String empList(Model model, EmpSearch emp) {
		model.addAttribute("list", empMapper.getEmpList(emp)); // 이게 옛날 requestSetAttribute랑 같음
		return "emp/empList";
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping("/main") //무조건 앞에 /로 시작해야함
	public String main() {
		return "main"; // 확장자, 경로명 적을 필요 없음. main이라고만 적어도 어느폴더에있는건지 스프링이 알아서 처리해줌
	}
	
	@RequestMapping("/adminmain") //무조건 앞에 /로 시작해야함
	public String adminmain() {
		return "admin/main"; // 
	}
}
