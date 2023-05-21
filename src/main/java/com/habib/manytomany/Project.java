package com.habib.manytomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	private int pid;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectName=" + projectName + ", employees=" + employees + "]";
	}

	public Project(int pid, String projectName, List<Employee> employees) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
