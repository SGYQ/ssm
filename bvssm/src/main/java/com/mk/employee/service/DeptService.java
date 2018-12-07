package com.mk.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.employee.dao.DeptMapper;
import com.mk.employee.entry.Department;

@Service
public class DeptService
{
	@Autowired
	DeptMapper deptDao;
	
	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Department> findDepts()
	{
		return deptDao.selectDepts();
	}
}
