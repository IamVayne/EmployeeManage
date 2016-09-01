package com.employee.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
/**
 * 业务层实现类  
 */
import com.employee.service.EmployeeService;

@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao)
	{
		this.employeeDao = employeeDao;
	}

	@Override
	/**
	 * 业务层登录方法
	 */
	public Employee login(Employee employee)
	{
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(int currPage)
	{
		
		PageBean<Employee> pageBean = new PageBean<>();
		pageBean.setCurrPage(currPage);
		
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Employee> list  = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
		
		
	}

	@Override
	public void save(Employee employee)
	{
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		
		
	}

	@Override
	public Employee findById(Integer eid)
	{
		// TODO Auto-generated method stub
		
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee)
	{
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee)
	{
		employeeDao.delete(employee);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
