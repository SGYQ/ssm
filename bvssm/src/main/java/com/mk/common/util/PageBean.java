package com.mk.common.util;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 分页组件
 * @author admin
 *
 */
@Component
@Scope("prototype")
public class PageBean<T>
{
	private int pageIndex=1;  //当前页面索引
	private int totalPages; //总页数
	private int pageSize=5; //页面大小
	private int totalCounts;//总记录数
	private List<T> list; //列表
	
	/**
	 * 构造函数
	 */
	public PageBean()
	{
	}

	public int getPageIndex()
	{
		return pageIndex;
	}

	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalCounts()
	{
		return totalCounts;
	}

	public void setTotalCounts(int totalCounts)
	{
		this.totalCounts = totalCounts;
	}

	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}

	@Override
	public String toString()
	{
		return "PageBean [pageIndex=" + pageIndex + ", totalPages=" + totalPages + ", pageSize=" + pageSize
				+ ", totalCounts=" + totalCounts + ", list=" + list + "]";
	}
	
	
}
