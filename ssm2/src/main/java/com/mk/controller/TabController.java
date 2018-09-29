package com.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mk.entry.Tab;
import com.mk.service.TabService;
import com.mk.util.Page;

@Controller
public class TabController
{
	@Autowired
	TabService tabService;
	
	@RequestMapping("/tabs")
	public ModelAndView queryTab(Page page)
	{
		ModelAndView mav = new ModelAndView();
		
		PageHelper.offsetPage( page.getStart(), page.getCount() );
		//查询结果
		List<Tab> result = tabService.findAll();
		int totalCount = (int) new PageInfo<>(result).getTotal();
		page.caculateLast(totalCount);
		
		mav.addObject("res", result);
		//设置转发路径(页面)
		mav.setViewName("table");
		
		return mav;
	}
	
}
