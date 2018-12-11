package com.mk.employee.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mk.employee.entry.Employee;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class StaffServiceTest
{
	@Autowired
	StaffService staffService;

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testFindEmps()
	{
		/*List<Employee> list = staffService.findEmps(0, 8);
		
		String jsonStr = JSON.toJSONString(list);
		
		System.out.println(jsonStr);*/
	}

	
	@Test
	public void testFindEmployees()
	{
		/*PageBean<Employee> pageBean = staffService.findEmployees(1, 5); 
		System.out.println(pageBean);
		
		System.out.println("组件JSON: "+JSON.toJSONString(pageBean));*/
	}
	@Test
	public void test1()
	{
		PageHelper.startPage(4, 5);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = staffService.findEmpList();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Employee> page = new PageInfo<Employee>(emps, 5);
		
		System.out.println( JSON.toJSONString(page) );
	}
	
}
