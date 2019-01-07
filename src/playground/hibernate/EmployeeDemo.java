package playground.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {
	
	static Session session;
	static SessionFactory factory;
	static String[] firstNames = {"Tick","Trick","Track"};
	static String[] lastNames = {"Bonecrusher","Shadowfox","Lightbender"};
	static String[] companies = {"Traders Council","Moria","the forest"};

	public static void main(String[] args) {
		
		// initialize everything
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {

			// create objects
//			for (int i=0;i<firstNames.length;i++) {
//				createEmployee(firstNames[i],lastNames[i],companies[i]);
//			}
		
			// retrieve an object by primary key
			// retrieve the second employee
			System.out.println("fetching second employee...");
			System.out.println(getEmployee(2));

			// query objects by company column
			

			// delete object by primary key


		} finally {
			factory.close();
		}

		
	}

	private static Employee getEmployee(int id) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Employee theEmployee = session.get(Employee.class, id);
		session.getTransaction().commit();
		return theEmployee;
		
	}

	private static void createEmployee(String firstName,String lastName,String company) {
		System.out.println("Creating a new employee...");
		Employee theEmployee = new Employee(firstName,lastName,company);
		System.out.println(theEmployee);
		System.out.println("throwing employee at database");
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(theEmployee);
		session.getTransaction().commit();
	}

	

}
