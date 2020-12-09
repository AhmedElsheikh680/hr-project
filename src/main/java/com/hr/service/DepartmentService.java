package com.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.model.Department;
import com.hr.repo.DepartmentRepo;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	public List<Department> getAllDepts(){
		return departmentRepo.findAll();
	}
	
	public Department getDeptById(long deptId) {
		return departmentRepo.findById(deptId).orElseThrow(null);
	}
	
	public void addDepartment(Department dept) {
		 departmentRepo.save(dept);
	}
	
	public void updateDept(Department dept) {
		 departmentRepo.save(dept);
	}
	
	public void deleteDept(long deptId) {
		departmentRepo.deleteById(deptId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
