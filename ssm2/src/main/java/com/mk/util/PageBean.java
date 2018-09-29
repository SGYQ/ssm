package com.mk.util;

public class PageBean
{
	private int index = 1; //��ǰҳ
	private int pageSize = 5; //ҳ���С
	private int totalCount;//�ܼ�¼��
	private int totalPage; //��ҳ��

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
	 * ����
	 */
	public void compute()
	{
		if( totalCount%pageSize == 0 )
			totalPage = totalCount / pageSize;
		else
			totalPage = totalCount/pageSize +1;
	}
}
