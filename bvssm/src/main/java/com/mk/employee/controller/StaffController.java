package com.mk.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mk.employee.entry.Employee;
import com.mk.employee.service.StaffService;

@Controller
@RequestMapping("/view/employee")
public class StaffController
{
	@Autowired
	StaffService staffService;
	
	//转向页面
	@RequestMapping("/employees")
	public String forEmps() 
	{
		return "emps";
	}
	@RequestMapping("/te")
	public String forEmpTest( @RequestParam(value="index",defaultValue="1")Integer index )
	{
		System.out.println(index); //始终是  1
		return "test";
	}
	
	@RequestMapping("/queryEmps")
	@ResponseBody
	public String queryEmployees( @RequestParam(value="pn",defaultValue="1")Integer pn )
	{
		//放在第一句，(起始页，页面大小)
		PageHelper.startPage(pn, 5);
		//查询列表
		List<Employee> list = staffService.findEmpList();
		//传入连续分页的页面索引数量
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(list,5);
		
		return JSON.toJSONString(pageInfo);
	}
	
}
