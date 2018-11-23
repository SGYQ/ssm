package com.mk.emp.dao;

import java.util.List;

import com.mk.emp.entry.EmployeeBean;

/**
 * 持久层接口
 * @author admin
 *
 */
public interface EmployeeMapper
{
	/**
	 * 分页查询员工信息
	 * @param begin
	 * @param size
	 * @return
	 */
	public List<EmployeeBean> selectEmps(int begin, int size);
	
	/**
	 * 查询员工数目
	 * @return
	 */
	public int selectCountOfEmps();
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 */
	public EmployeeBean selectEmpById(int id);
	
}
