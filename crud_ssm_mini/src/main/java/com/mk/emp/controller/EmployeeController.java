package com.mk.emp.controller;

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
import com.mk.emp.entry.EmployeeBean;
import com.mk.emp.service.EmployeeService;
import com.mk.util.StringUtils;

/**
 * 控制层
 * @author admin
 *
 */
@Controller
@RequestMapping("/staff")
public class EmployeeController
{
	@Autowired
	EmployeeService empService;
	
	//转向页面
	@RequestMapping("/staffs")
	public String forward()
	{
		return "staffList";
	}
	
	@RequestMapping("/getStaffs")
	@ResponseBody
	public String queryEmployees(HttpServletRequest request, HttpServletResponse response)
	{
		String index = request.getParameter("pageIndex");
		String size = request.getParameter("pageSize");
		int pageIndex = 0;
		int pageSize = 10;
		if( !StringUtils.isEmpty(index)&&!StringUtils.isEmpty(size) ) {
			pageIndex = Integer.parseInt(index);
			pageSize = Integer.parseInt(size);
		}
		
		List<EmployeeBean> list = empService.findEmps(pageIndex, pageSize);
		int count = empService.findCountOfEmps();
		Map<String,Object> map = new HashMap<>();
		map.put("total", count);
		map.put("data", list);
		
		return JSON.toJSONString(map);
	}
	
}
