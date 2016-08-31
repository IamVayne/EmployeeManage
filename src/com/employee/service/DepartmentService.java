package com.employee.service;

import com.employee.domain.PageBean;
import com.employee.domain.Department;

public interface DepartmentService
{

	PageBean<Department> findByPage(Integer currPage);


	void save(Department department);


	Department findById(Integer did);


	void update(Department department);


	void delete(Department department);

}
