package com.employee.domain;

import java.util.List;

public class PageBean<T>
{
	private int currPage;//当前页是第几页
	private int pageSize;//每页记录的个数
	private int totalCount;//一共有多少条记录
	private int totalPage;//一共有多少页数
	private List<T> list;//存储每页的记录
	
	
	
	public int getCurrPage()
	{
		return currPage;
	}
	public void setCurrPage(int currPage)
	{
		this.currPage = currPage;
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
	public List<T> getList()
	{
		return list;
	}
	public void setList(List<T> list)
	{
		this.list = list;
	}
	
	
}
