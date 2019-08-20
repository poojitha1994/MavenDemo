package letsstartcoding.springbootrestexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import letsstartcoding.springbootrestexample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
