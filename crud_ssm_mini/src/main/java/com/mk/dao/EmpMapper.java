package com.mk.dao;

import java.util.List;

import com.mk.entry.Employee;

public interface EmpMapper
{
	//分页查询
	public List<Employee> selectEmpList(int index, int size);
	//查询记录总数
	public int selectCountOfEmp();
	
	/**
	 * <p>根据id 删除信息
	 * @param id
	 * @return
	 */
	public int deleteEmpById(int id);
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	public Employee selectEmployeeById(int id);
	
	public void insertEmployee(Employee employee);
	
	public int updateEmployee(Employee employee);
}
