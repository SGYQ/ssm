package com.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.entry.Tab;
import com.mk.mapper.TabMapper;

@Service
public class TabService
{
	@Autowired
	TabMapper tabMapper;
	
	//查询所有
	public List<Tab> findAll()
	{
		return tabMapper.selectAll();
	}
	//按页查询
	public List<Tab> findByPage(int pageIndex, int pageSize)
	{
		return tabMapper.selectByPage( (pageIndex-1)*pageSize, pageSize );
	}
}
