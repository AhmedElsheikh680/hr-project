package com.hr.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="employees")
@NamedEntityGraph(name="Employee.simple", attributeNodes = @NamedAttributeNode("department"))
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The Databese Generated Employee ID")
	private long id;
	@Column(name="first_name")
	@ApiModelProperty(notes = "The First Name Of The Employee", required = true)
	@NotEmpty(message = "First Name Must Not Be Empty")
	@NotNull(message = "This Field Is Required")
	private String firstName;
	@ApiModelProperty(notes = "The Last Name Of The Employee", required = true)
	@Column(name="last_name")
	@NotEmpty(message = "Last Name Must Not Be Empty")
	@NotNull(message = "This Field Is Required")
	private String lastName;
	private String address;
	@NotNull(message = "Salary Must Not Be Null")
	private double salary;
	@Column(name = "phone_number", unique = true)
//	@Min(value = 11, message = "Phone Number Should Be 11 Number")
	private String phoneNumber;

	@Column(name = "hire_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date hireDate;
	@Column(name = "job_id")
	private String jobId;
	@Column(name = "commission_pct")
	private Double ccommissionPct;
	@Column(name = "email")
	@Email(message = "You Should Enter A Valid Email")
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;
	public Employee() {
		super();
	}
	public Employee(long id, String firstName, String lastName,String address,double salary, String phoneNumber, Date hireDate,
			String jobId, Double ccommissionPct, String email, Department department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.ccommissionPct = ccommissionPct;
		this.email = email;
		this.department = department;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Double getCcommissionPct() {
		return ccommissionPct;
	}
	public void setCcommissionPct(Double ccommissionPct) {
		this.ccommissionPct = ccommissionPct;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
