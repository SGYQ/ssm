package com.mk.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.emp.dao.EmployeeMapper;
import com.mk.emp.entry.EmployeeBean;

/**
 * 业务层
 * @author admin
 *
 */
@Service
public class EmployeeService
{
	@Autowired
	EmployeeMapper empDao;
	
	/**
	 * 分页查询
	 * @param pageIndex 页面索引
	 * @param pageSize  页面大小
	 * @return
	 */
	public List<EmployeeBean> findEmps(int pageIndex, int pageSize)
	{
		return empDao.selectEmps(pageIndex*pageSize, pageSize);
	}
	
	/**
	 * 查询员工数目
	 * @return
	 */
	public int findCountOfEmps()
	{
		return empDao.selectCountOfEmps();
	}
	
}
