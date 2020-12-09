package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.model.Department;
import com.hr.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getAllDepts")
	public ResponseEntity<List<Department>> getAllDepts(){
		List<Department> depts = departmentService.getAllDepts();
		if(depts !=null) {
			return new ResponseEntity<List<Department>>(depts, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Department>>(depts, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getDeptById")
	public ResponseEntity<Department> getDeptById(@RequestParam long deptId) {
		Department dept = departmentService.getDeptById(deptId);
		if(dept !=null) {
			return new ResponseEntity<Department>(dept, HttpStatus.OK);
		}else {
			return new ResponseEntity<Department>(dept, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addDept")
	public ResponseEntity<Department> addDept(@RequestBody Department dept) {
		departmentService.addDepartment(dept);
		 return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}
	
	@PutMapping("/updateDept")
	public ResponseEntity<Department> updateDept(@RequestBody Department dept) {
		departmentService.updateDept(dept);
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDept")
	public String deleteDept(@RequestParam long deptId) {
		departmentService.deleteDept(deptId);
		return "Deleted Successfully!!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
