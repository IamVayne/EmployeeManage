package com.employee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao
{

	@Override
	/**
	 * DAO中根据用户名和密码查询用户
	 */
	public Employee findByUsernameAndPassword(Employee employee)
	{
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			
			return list.get(0);
		}
		
		return null;
	}
	

}
