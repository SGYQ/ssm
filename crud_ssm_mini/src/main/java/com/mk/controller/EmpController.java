package com.mk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mk.entry.Employee;
import com.mk.service.EmpService;
import com.mk.util.StringUtils;

@Controller
@RequestMapping("/employee")
public class EmpController
{
	@Autowired
	EmpService empService;
	
	//跳转页面
	@RequestMapping("/empoyeeList")
	public String forEmployee()
	{
		return "emps";
	}
	
	//查询列表
	@RequestMapping("/queryEmp")
	@ResponseBody
	public String queryEmployees(HttpServletRequest request,HttpServletResponse response)
	{
		String index = request.getParameter("pageIndex");
		String size = request.getParameter("pageSize");
		int pageIndex = 0;
		int pageSize = 10;
		if( !StringUtils.isEmpty(index)&&!StringUtils.isEmpty(size) ) {
			pageIndex = Integer.parseInt(index);
			pageSize = Integer.parseInt(size);
		}
		List<Employee> list = empService.findEmpList(pageIndex, pageSize);
		int counts = empService.findCountOfEmp();
		Map<String,Object> map = new HashMap<>();
		map.put("total", counts);
		map.put("data", list);
		
		return JSON.toJSONString(map);
	}
	
	//删除数据(一个或者多个)
	@RequestMapping("/clear")
	@ResponseBody
	public String dropEmpById(HttpServletRequest request,HttpServletResponse response)
	{
		String ids = request.getParameter("ids");
		String result = "删除成功！";
		
		try {
			empService.removeEmpByIds(ids);
		} catch(Exception e) {
			result = "删除失败！";
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	@RequestMapping("/queryDataById")
	@ResponseBody
	public String queryEmpById(HttpServletRequest request,HttpServletResponse response)
	{
		String id = request.getParameter("id");
		
		Employee emp = new Employee();
		if( !StringUtils.isEmpty(id) )
				emp = empService.findEMployeeById( Integer.parseInt(id) );
		
		return JSON.toJSONString(emp);
	}
	
	//编辑，修改
	@RequestMapping("/appendEmp")
	@ResponseBody
	public String appendEmpInfo(HttpServletRequest request,HttpServletResponse response)
	{
		String data = request.getParameter("data");
		Employee employee = JSON.parseObject(data, Employee.class);
		//添加
		empService.addEmpInfo(employee);
		
		return "添加成功！";
	}
	
	
	@RequestMapping("/modifyEmp")
	@ResponseBody
	public String modifyEmpInfp(HttpServletRequest request,HttpServletResponse response)
	{
		String data = request.getParameter("data");
		
		Employee employee = JSON.parseObject(data, Employee.class);
		//修改
		empService.editEmpInfo(employee);
		
		return "编辑成功!!";
	}
}
