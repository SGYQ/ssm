package com.mk.mapper;

import java.util.List;

import com.mk.entry.Tab;

public interface TabMapper
{
	/**
	 * 查询所有
	 * @return
	 */
	public List<Tab> selectAll();
	/**
	 * 按页查询
	 * @param begin 开始索引  ，从第几条开始
	 * @param size  每页大小  ，取多少条记录
	 * @return
	 */
	public List<Tab> selectByPage(int begin, int size);
}
