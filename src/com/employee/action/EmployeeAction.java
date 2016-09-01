package com.employee.action;
import java.util.List;

import com.employee.domain.Department;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
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
	private DepartmentService departmentService;
	
	
	
	public void setDepartmentService(DepartmentService departmentService)
	{
		this.departmentService = departmentService;
	}



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
	
	private int currPage = 1;
	
	//分页查询员工执行的方法
	
	public void setCurrPage(int currPage)
	{
		this.currPage = currPage;
	}



	public String findAll()
	{
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转处理
	public String saveUI()
	{
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		
		return "saveUI";
	}
	
	//保存员工的执行方法
	
	public String save()
	{
		employeeService.save(employee);
		
		return "saveSuccess";
	}
	
	
	//编辑员工执行的方法
	public String edit()
	{
		//根据id查询员工和部门。
		employee = employeeService.findById(employee.getEid());
		
		List<Department> list = departmentService.findAll();
		
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "editSuccess";
		
	}
	
	//
	public String update()
	{
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除雇员的方法
	public String delete()
	{
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		
		return "deleteSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
