package letsstartcoding.springbootrestexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import letsstartcoding.springbootrestexample.dao.EmployeeDao;
import letsstartcoding.springbootrestexample.model.Employee;

@RestController
@RequestMapping("/Company")
public class EmployeeController {
	@Autowired
	EmployeeDao employeedao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/Employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeedao.save(emp);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Employees")
	public List<Employee> getAllEmployees() {
		return employeedao.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long empid) {
		Employee emp= employeedao.findOne(empid);
		/*if(emp==null) {
			return ResponseEntity<Employee>.notFound().build();
		}*/
		return ResponseEntity.ok().body(emp);
		}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empdetails){
		Employee emp= employeedao.findOne(empid);
		/*if(emp==null) {
			return ResponseEntity.notFound().build();
		}*/
		emp.setName(empdetails.getName());
		emp.setDesignation(empdetails.getDesignation());
		emp.setExpertise(empdetails.getExpertise());
		
		Employee updateEmployee=employeedao.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	@DeleteMapping("/Employees/{id}")
	public void deleteEmployee(@PathVariable(value = "id") Long empid){
		Employee emp= employeedao.findOne(empid);
		/*if(emp==null) {
			return ResponseEntity.notFound().build();
		}*/
		employeedao.delete(emp);
		
		
	
		
	}
}
