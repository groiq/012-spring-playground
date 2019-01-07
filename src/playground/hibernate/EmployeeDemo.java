package playground.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {
	
	static Session session;
	

	public static void main(String[] args) {
		
		// initialize everything
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfd.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {

			// save objects
			createEmployee();

			// retrieve an object by primary key

			// query objects by company column

			// delete object by primary key


		} finally {
			factory.close();
		}

		
	}

	private static void createEmployee() {
		System.out.println("Creating a new employee...");
	}

	

}
