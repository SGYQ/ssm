package com.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.dao.EmpMapper;
import com.mk.entry.Employee;

@Service
public class EmpService
{
	@Autowired
	EmpMapper empDao;
	
	/**
	 * <p>查询列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Employee> findEmpList(int pageIndex, int pageSize)
	{
		if(pageIndex<0)
			pageIndex=0;
		if(pageSize<0)
			pageSize = 10;
		return empDao.selectEmpList(pageIndex*pageSize, pageSize);
	}
	/**
	 * <p>查询记录总数
	 * @return
	 */
	public int findCountOfEmp()
	{
		return empDao.selectCountOfEmp();
	}
	
	/**
	 * <p>根据id组 删除记录
	 * @param ids
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public void removeEmpByIds(String ids)
	{
		//先切割
		String[] id = ids.split(",");
		
		for(int i=0,len=id.length; i<len; i++)
			empDao.deleteEmpById( Integer.parseInt(id[i]) );
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Employee findEMployeeById(int id)
	{
		return empDao.selectEmployeeById(id);
	}
	/**
	 * 添加信息
	 * @param employee
	 */
	public void addEmpInfo(Employee employee)
	{
		empDao.insertEmployee(employee);
	}
	//编辑、修改
	public int editEmpInfo(Employee employee)
	{
		return empDao.updateEmployee(employee);
	}
	
}
