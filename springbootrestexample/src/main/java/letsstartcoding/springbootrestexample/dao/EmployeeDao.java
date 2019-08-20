package letsstartcoding.springbootrestexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import letsstartcoding.springbootrestexample.model.Employee;
import letsstartcoding.springbootrestexample.repository.EmployeeRepository;

@Service
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeerepository;

	/* Save an employee */
	public Employee save(Employee emp) {
		return employeerepository.save(emp);
	}

	/* search all employee */
	public List<Employee> findAll() {
		return employeerepository.findAll();
	}

	/* Get all employee */
	public Employee findOne(Long empid) {
		return employeerepository.findOne(empid);
	}
	/* delete an employee */
	public void delete(Employee emp) {
		employeerepository.delete(emp);
	}

}
