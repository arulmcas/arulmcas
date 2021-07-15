package com.workout.mapping.departmentemployee;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.workout.mapping.util.SessionUtil;

public class OperationRepository {

	private static OperationRepository operationRepository = new OperationRepository();
	
	public static OperationRepository getOperationRepository( ) {
		if(operationRepository != null) return operationRepository;
		return new OperationRepository();
	}

	public String createDepartment(Department department) {
		Session session = SessionUtil.getInstance().getSession(Department.class, Employee.class);
		Transaction transaction = session.beginTransaction();
		try {
			session.save(department);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in CreateDepartment::: " + e);
		} finally {
			SessionUtil.getInstance().closeSession(session);
		}
		return department.getId() + "";
	}
	
	public String createEmployee(Employee employee) {
		Session session = SessionUtil.getInstance().getSession(Department.class, Employee.class);
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in CreateEmployee::: " + e);
		} finally {
			SessionUtil.getInstance().closeSession(session);
		}
		return employee.getId() + "";
	}
}
