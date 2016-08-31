package com.employee.action;

import com.employee.domain.Department;
import com.employee.domain.PageBean;
import com.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>
{
	//模型驱动获取前台数据
	private Department department = new Department();

	@Override
	public Department getModel()
	{
		// TODO Auto-generated method stub
		return department;
	}
	
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage)
	{
		this.currPage = currPage;
	}
	
	//注入业务处理对象
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService)
	{
		this.departmentService = departmentService;
	}

	public String findAll(){
		
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//放入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
		
	}
	
	//添加部门页面
	public String saveUI()
	{
		return "saveUI";
	}
	
	public String save()
	{
		
		departmentService.save(department);
		System.out.println("save执行了...");
		
		return "saveSuccess";
	}
	
	//编辑部门执行的方法
	public String edit()
	{
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//更新部门信息
	
	public String update()
	{
		departmentService.update(department);
		return "updateSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
