package com.mk.employee.dao;

import java.util.List;

import com.mk.employee.entry.Department;

public interface DeptMapper
{
	/**
	 * 获取 所有部门信息
	 * @return
	 */
	public List<Department> selectDepts();
}
