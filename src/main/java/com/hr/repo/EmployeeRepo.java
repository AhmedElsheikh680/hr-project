package com.hr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public List<Employee> findAllByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("from Employee e where e.firstName= :firstName And lastName= :lastName")
	@EntityGraph(value = "Employee.simple", type = EntityGraphType.FETCH)
	public List<Employee> empSearch(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	
	//Master Details
	public List<Employee> findByDepartmentId(long deptId);
	
	
}
