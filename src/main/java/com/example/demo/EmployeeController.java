package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mav) {
    	EmployeeListForm form = new EmployeeListForm();
    	List<EmployeeBean> list = new ArrayList<EmployeeBean>();

    	EmployeeBean bean = new EmployeeBean();
    	bean.setId("1");
    	bean.setName("Ken");
    	bean.setEmail("ken@mail.coml");
    	list.add(bean);

    	bean = new EmployeeBean();
    	bean.setId("2");
    	bean.setName("Hanako");
    	bean.setEmail("hanako@mail.coml");
    	list.add(bean);

    	form.setEmployees(list);

    	mav.addObject("employeeListForm", form);


    	EmployeeForm employeeForm = new EmployeeForm();
    	employeeForm.setEmployee(bean);

    	mav.addObject("employeeForm", employeeForm);

    	mav.setViewName("contents/employeeList");

        return mav;
    }


	@PostMapping("/detail")
    public ModelAndView list(@ModelAttribute EmployeeForm employeeForm, ModelAndView mav) {
    	mav.addObject("employeeForm", employeeForm);
    	mav.setViewName("contents/employee");

        return mav;
    }

	@GetMapping("/page3")
	 public ModelAndView page3(ModelAndView mav) {

   	mav.setViewName("page3");

       return mav;
   }
}