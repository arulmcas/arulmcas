package com.workout.mapping.departmentemployee;

import java.util.function.Function;



public class OperationService implements OperationManagement{

	public String createDepartment(DepartmentDTO departmentDTO) {
		Department department = departmentdata.apply(departmentDTO);
		String id = OperationRepository.getOperationRepository().createDepartment(department);
		return id;
	}

	public String createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeedata.apply(employeeDTO);
		String id = OperationRepository.getOperationRepository().createEmployee(employee);
		return id;
	}

	Function<DepartmentDTO, Department> departmentdata = (departmentDTO) -> {
		
		Department department = new Department();
//		department.setId(departmentDTO.getId());
		department.setName(departmentDTO.getName());
//		department.setEmployees(departmentDTO.getEmployees());
		return department;
		
	};
	
	Function<EmployeeDTO, Employee> employeedata = (employeeDTO) -> {
		
		Employee employee = new Employee();
//		employee.setId(employeeDTO.getId());
		employee.setFirst_name(employeeDTO.getFirst_name());
		employee.setLast_name(employeeDTO.getLast_name());
		employee.setSalary(employeeDTO.getSalary());
		employee.setDepartment(employeeDTO.getDepartment());
		return employee;
	};
}
