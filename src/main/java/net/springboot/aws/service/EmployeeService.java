package net.springboot.aws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.aws.entity.Employee;
import net.springboot.aws.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean getEmployee(Employee employee) {
		return employeeRepository.existsById(employee.getId());
		
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
public List<Employee> getAllEmployees(){
	return employeeRepository.findByOrderBySalaryDescNameAsc();
}

public int updateEmployeeSalary(int id, int salary) {
	Optional<Employee> emp = employeeRepository.findById(id);
	if(emp.isPresent()) {
		Employee employee = new Employee();
		employee.setSalary(salary);
		employee.setId(emp.get().getId());
		employee.setDesignation(emp.get().getName());
		employeeRepository.save(employee);
	}
	return salary;
	
}

}
