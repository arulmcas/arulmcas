package com.workout.mapping.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.workout.mapping.departmentemployee.Department;
import com.workout.mapping.departmentemployee.Employee;

public class SessionUtil {

	public static SessionUtil sessionUtil = new SessionUtil();
	
	public static SessionUtil getInstance() {
        if(sessionUtil != null) {
            return sessionUtil;
        }
        return new SessionUtil();
    }
	
	public <O> Session getSession(Class<O> class1) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(class1);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(registry);
		Session session = factory.openSession();
		return session;
	}

	public <O> Session getSession(Class<Department> class1, Class<Employee> class2) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(class1).addAnnotatedClass(class2);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(registry);
		Session session = factory.openSession();
		return session;
	}
	
	public void closeSession(Session session) {
		session.close();
	}
}
