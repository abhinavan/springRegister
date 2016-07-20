package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Student;

@Controller
public class StudentController 
{
	public JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
	}
	
	@RequestMapping("/register")
	 public ModelAndView insertRegister(Student s,HttpServletRequest req,HttpServletResponse res)
	 {
		
		ModelAndView mav=new ModelAndView("successRegister");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		String query="insert into register values('"+name+"','"+pass+"')";
		int status=template.update(query);
		Student st=new Student(name,pass);
		mav.addObject("student",st);
		return mav;
	 }

}
