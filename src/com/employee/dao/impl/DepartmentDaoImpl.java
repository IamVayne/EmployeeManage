package com.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.DepartmentDao;
import com.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao
{

	@Override
	public int findCount()
	{
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0)
		{
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize)
	{
		// TODO Auto-generated method stub

		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);

		return list;
	}

	//添加新部门
	@Override
	public void save(Department department)
	{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
		
		
	}
	
	//根据id查询部门

	@Override
	public Department findById(Integer did)
	{
		return this.getHibernateTemplate().get(Department.class,did);
	}

	//更新部门信息
	@Override
	public void update(Department department)
	{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
		
	}

	
	
	
}
