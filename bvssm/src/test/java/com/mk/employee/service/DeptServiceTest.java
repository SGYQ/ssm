package com.mk.employee.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mk.employee.entry.Department;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class DeptServiceTest
{
	@Autowired
	DeptService deptService;
	
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testFindDepts()
	{
		List<Department> list = deptService.findDepts();
		String jsonstr = JSON.toJSONString(list);
		
		System.out.println(jsonstr);
	}

}
