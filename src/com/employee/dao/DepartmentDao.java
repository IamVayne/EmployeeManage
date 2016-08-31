package com.employee.dao;

import com.employee.domain.Department;
import java.util.List;
public interface DepartmentDao
{

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);


}
