package com.mk.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.employee.dao.StaffMapper;
import com.mk.employee.entry.Employee;

@Service
public class StaffService
{
	@Autowired
	StaffMapper staffDao;
	
	/**
	 * 查询所有(配合分页插件使用)
	 * @return
	 */
	public List<Employee> findEmpList()
	{
		return staffDao.selectList();
	}

	public int findCounts()
	{
		return staffDao.selectCountOfEmp();
	}
	
	/**
	 * 根据员工编号单个删除信息
	 * @param id
	 * @return
	 */
	public int removeEmpById(int id)
	{
		return staffDao.deleteEmployeeById(id);
	}
	
	/**
	 * 多项删除，根据编号
	 * @param ids
	 * @return
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public int removeEmpByIds(int[] ids)
	{
		int counts = 0;
		
		for(int i=0,len=ids.length; i<len; i++)
			counts += staffDao.deleteEmployeeById( ids[i] );
			
		return counts;
	}
	
}
