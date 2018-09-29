package com.mk.util;

public class PageBean
{
	private int index = 1; //当前页
	private int pageSize = 5; //页面大小
	private int totalCount;//总记录数
	private int totalPage; //总页数

	public PageBean()
	{
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	
	/**
	 * 计算
	 */
	public void compute()
	{
		if( totalCount%pageSize == 0 )
			totalPage = totalCount / pageSize;
		else
			totalPage = totalCount/pageSize +1;
	}
}
