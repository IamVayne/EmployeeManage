package com.employee.service.impl;
import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
/**
 * 业务层实现类  
 */
import com.employee.service.EmployeeService;

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
	
	
	
}
