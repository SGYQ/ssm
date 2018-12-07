package com.mk.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mk.employee.entry.Department;
import com.mk.employee.service.DeptService;

@Controller
public class DeptController
{
	@Autowired
	DeptService deptService;
	
	/**
	 * 获取所有部门
	 * @return
	 */
	@RequestMapping("/queryDepts")
	@ResponseBody
	public String queryDepts()
	{
		List<Department> list = deptService.findDepts();
		
		String jsonStr = JSON.toJSONString(list);
		
		return jsonStr;
	}
}
