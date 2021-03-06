package edu.mum.cs.cs544.ex3_2.model.part_a;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/*
 Create a Bidirectional OneToMany association between Department and Employee
using annotations. 
 */

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	// department is the owning side
	@OneToMany//(mappedBy = "department")
	private List<Employee> employeeList = new ArrayList<Employee>();

	public Department() {
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employeeList;
	}

	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
		employee.setDepartment(this);
	}

}
