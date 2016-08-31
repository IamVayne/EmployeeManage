package com.employee.dao;

import com.employee.domain.Employee;

public interface EmployeeDao
{

	Employee findByUsernameAndPassword(Employee employee);
	

}
