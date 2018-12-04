package com.mk.employee.dao;

import java.util.List;

import com.mk.employee.entry.Employee;

/**
 * <p>持久层接口
 * @author admin
 *
 */
public interface StaffMapper
{	
	/**
	 * <p>查询列表信息
	 * @return
	 */
	public List<Employee> selectList();
	
	/**
	 * <p>查询总记录数/员工总人数
	 * @return
	 */
	public int selectCountOfEmp();
	/**
	 * <p>根据id查询员工信息
	 * @param id
	 * @return
	 */
	public Employee selectEmployeeById(int id);
	
	/**
	 * <p>添加信息
	 * @param employee
	 * @return
	 */
	public int insertEmployee(Employee employee);
	
	/**
	 * <p>根据id删除员工信息
	 * @param id
	 * @return
	 */
	public int deleteEmployeeById(int id);
	
	/**
	 * <p>编辑员工信息
	 * @param employee
	 * @return
	 */
	public int updateEmployee(Employee employee);
	
}
