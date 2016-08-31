package com.employee.action;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的action类
 * @author vayne
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>
{
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel()
	{
		return employee;
	}
	
	//注入业务层的类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}



	/**
	 * 登录执行的方法
	 */
	
	public String login(){
		//调用业务层类
		
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			
			//登录失败
			
			this.addActionError("用户名或者密码错误");
			return INPUT;
		}else{
			
			//登录成功
			
			ActionContext.getContext().getSession().put("existEmployee",existEmployee);
			return SUCCESS;
			
		}
		
	}

}
