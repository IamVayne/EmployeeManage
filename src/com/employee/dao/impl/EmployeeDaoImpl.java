package com.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
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

	//查询总记录数
	@Override
	public int findCount()
	{
		String hql="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			
			return list.get(0).intValue();
					
		}
		return 0;
	}
	
	//查询总页数
	@Override
	public List<Employee> findByPage(int begin, int pageSize)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		
		return list;
	}

	//dao层保存雇员
	@Override
	public void save(Employee employee)
	{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	public Employee findById(Integer eid)
	{
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee)
	{
		this.getHibernateTemplate().update(employee);
	}

	//删除方法
	@Override
	public void delete(Employee employee)
	{
		this.getHibernateTemplate().delete(employee);
	}
	
	
	
	
	
	
	
	
	
	

	
	
}
