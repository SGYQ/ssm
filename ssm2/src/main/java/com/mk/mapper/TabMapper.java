package com.mk.mapper;

import java.util.List;

import com.mk.entry.Tab;

public interface TabMapper
{
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Tab> selectAll();
	/**
	 * ��ҳ��ѯ
	 * @param begin ��ʼ����  ���ӵڼ�����ʼ
	 * @param size  ÿҳ��С  ��ȡ��������¼
	 * @return
	 */
	public List<Tab> selectByPage(int begin, int size);
}
