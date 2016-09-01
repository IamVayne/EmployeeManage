package com.employee.service;

import com.employee.domain.PageBean;

import java.util.List;

import com.employee.domain.Department;

public interface DepartmentService
{

	PageBean<Department> findByPage(Integer currPage);


	void save(Department department);


	Department findById(Integer did);


	void update(Department department);


	void delete(Department department);


	List<Department> findAll();

}
