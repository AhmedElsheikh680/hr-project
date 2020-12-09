package com.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.api.exception.RecordNotFoundException;
import com.hr.model.Employee;
import com.hr.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public List<Employee> getDeptEmps(long deptId){
		return employeeRepo.findByDepartmentId(deptId);
	}
	
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	public Employee getById(long id) {
		return employeeRepo.findById(id).orElseThrow(()->new RecordNotFoundException("This Employee Not Found "+id));
	}
	
	public List<Employee> getByFirstnameAndLastName(String firstName, String lastName){
		return employeeRepo.findAllByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Employee> empSearch(String firstName, String lastName){
		return employeeRepo.empSearch(firstName, lastName);
	}
	
	public void addEmp(Employee emp) {
		 employeeRepo.save(emp);
	}
	
	public void updateEmp(Employee emp) {
		employeeRepo.save(emp);
	}
	
	public void deleteEmp(long id) {
		employeeRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
