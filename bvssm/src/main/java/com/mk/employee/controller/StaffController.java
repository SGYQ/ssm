package com.mk.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mk.employee.entry.Department;
import com.mk.employee.entry.Employee;
import com.mk.employee.service.DeptService;
import com.mk.employee.service.StaffService;

@Controller
@RequestMapping("/view/employee")
public class StaffController
{
	@Autowired
	StaffService staffService;
	@Autowired
	DeptService deptService;
	
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
	
	/**
	 * 分页查询
	 * @param pn
	 * @return
	 */
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
	
	/**
	 * 单个删除，根据员工编号
	 * @param request
	 * @return
	 */
	@RequestMapping("/clearEmp")
	@ResponseBody
	public String dropEmpInfoById(HttpServletRequest request)
	{
		String id = request.getParameter("id");
		String mes  = "";
		
		if( !StringUtil.isEmpty(id) )
			mes = staffService.removeEmpById( Integer.parseInt(id) )==1?"删除成功!":"删除失败!";
		
		return mes;
	}
	
	@RequestMapping("/clearEmps")
	@ResponseBody
	public String dropEmpInfoByIds( String[] ids)
	{
		int len = ids.length;
		int counts = 0;
		int[] array = new int[len];
		
		if( ids!=null ) {
			for(int i=0; i<len; i++)
				array[i]=Integer.parseInt(ids[i]);
		}
		
		//删除
		counts = staffService.removeEmpByIds(array);

		String msg = (counts==len ? "删除成功!":"删除失败!");
		return msg;
	}
	
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
