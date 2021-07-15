package com.workout.mapping.departmentemployee;

public class OperationController {

	OperationService operationService = new OperationService();
	DepartmentDTO departmentDTO = new DepartmentDTO();
	EmployeeDTO employeeDTO = new EmployeeDTO();
	
	public static void main(String args[]) {
		OperationController controller = new OperationController();
		controller.createDepartment();
		controller.createEmployee();
	}
	
	public void createDepartment() {
		
		departmentDTO.setName("Development");
		String id = operationService.createDepartment(departmentDTO);
		System.out.println("Department created successfully... "+ id);
	}
	
	public void createEmployee() {
		
		employeeDTO.setFirst_name("Arul");
		employeeDTO.setLast_name("Ammasi");
		employeeDTO.setSalary(100000);
		employeeDTO.setDepartment(operationService.departmentdata.apply(departmentDTO));
		String id = operationService.createEmployee(employeeDTO);
		System.out.println("Employee created successfully... "+ id);
	}
}
