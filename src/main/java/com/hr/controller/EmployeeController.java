package com.hr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.model.Employee;
import com.hr.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "employee", description = "Operations For Employee Service")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	Environment env;
	
	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/getAllDepts/{deptId}/getAllEmps")
	public ResponseEntity<List<Employee>> getDeptEmps(@PathVariable long deptId){
		List<Employee>emps = employeeService.getDeptEmps(deptId);
		if(emps !=null) {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllEmps")
	@ApiOperation(value = "View A List Of Available Employee",response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfuly Retrieved  List"),
			@ApiResponse(code = 401, message="You Are Not Authorized To View The Resource"),
			@ApiResponse(code =403, message = "Accessing thr Resource You Were Trying To Reach Is Forbidden"),
			@ApiResponse(code = 404, message = "The Resource you Are Trying To Reach Is Not Found")
	})
	public ResponseEntity<List<Employee>> getAllEmps(){
		System.out.println("App Name Is "+appName);
		System.out.println("Naming "+ env.getProperty("spring.application.name"));
		List<Employee> emps = employeeService.getAll();
		if(emps != null) {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping("/getById/{id}")
//	public ResponseEntity<Employee> getById(@PathVariable long id){
//		Employee emp = employeeService.getById(id);
//		if(emp !=null) {
//			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/getById")
	public ResponseEntity<Employee> getById(@RequestParam long id){
		Employee emp = employeeService.getById(id);
		if(emp !=null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getByFirstNameAndLastName")
	public ResponseEntity<List<Employee>> getByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
		
		List<Employee> emps = employeeService.getByFirstnameAndLastName(firstName, lastName);
		if(emps !=null) {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/empSearch")
	public ResponseEntity<List<Employee>> empSearch(@RequestParam String firstName, @RequestParam String lastName){
		List<Employee> emps = employeeService.empSearch(firstName, lastName);
		if(emps != null) {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.NOT_FOUND);

		}
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmp(@Valid @RequestBody Employee emp){
		 employeeService.addEmp(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
		employeeService.updateEmp(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp")
	public String deleteEmp(@RequestParam long id) {
		employeeService.deleteEmp(id);
		return "Deleted Successfully!!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
