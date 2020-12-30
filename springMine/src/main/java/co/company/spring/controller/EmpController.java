package co.company.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@Controller
public class EmpController {
   @Autowired
   EmpMapper dao;
   
   @RequestMapping(value="/empSelect", method=RequestMethod.GET)
   public ModelAndView select(EmpSearch emp) {
	   ModelAndView mav = new ModelAndView();
      //조회
	  // 모델앤뷰
	  mav.addObject("list", dao.getEmpList(emp));
	  mav.setViewName("emp/select");
      return mav;
   }
   
   @GetMapping("/empInsertForm")
   public String insertForm(Emp emp,Model model) {
      model.addAttribute("jobs",dao.jobSelect());
      model.addAttribute("departments",dao.departmentSelect());
      return "emp/insert";
   }
   
   @GetMapping("/empUpdateForm")
   public String updateForm(Emp emp,Model model) {
      model.addAttribute("emp",dao.getEmp(emp));
      model.addAttribute("jobs",dao.jobSelect());
      model.addAttribute("departments",dao.departmentSelect());
      return "emp/insert";
   }
   
   @PostMapping("/empInsert")
   public String insert( @ModelAttribute("employee") Emp emp) {
      if(emp.getEmployeeId() == null)
    	  dao.insertEmp(emp);
      else
    	  dao.updateEmp(emp);
   return "emp/insertOutput";
      
   }
   
//   @PostMapping("/empInsert")
//   public String insert(@RequestParam (required=false,defaultValue = "noname" )String lastName,
//         @RequestParam (required=false,defaultValue = "nomoney" )int salary,Emp emp) {
//     //파라미터
//     System.out.println(lastName);
//     System.out.println(salary);
//     System.out.println(emp);
//      //등록처리
//      //redirect(url값을 넣어줘야한다)
//      return "redirect:empSelect";
//      
//   }
   
}