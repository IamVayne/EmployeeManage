package com.employee.service.impl;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService
{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao)
	{
		this.departmentDao = departmentDao;
	}

	/**
	 * 分頁查詢
	 */
	@Override
	public PageBean<Department> findByPage(Integer currPage)
	{
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		//封裝每页顯示記錄數；
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	/**
	 * save新部门
	 */
	@Override
	public void save(Department department)
	{
		// TODO Auto-generated method stub
		
		departmentDao.save(department);
		
	}

	//根据id查找部门
	@Override
	public Department findById(Integer did)
	{	
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department)
	{
		// TODO Auto-generated method stub
		departmentDao.update(department);
		
	}
	
	//部门删除

	@Override
	public void delete(Department department)
	{
		// TODO Auto-generated method stub
		departmentDao.delete(department);
		
	}
	
	
	
	
	

	
	
	
	
}
