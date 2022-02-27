package SelectDatabase;

import java.util.List;

import  org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class ListVehicle {
	
	public static List<CreateSelect> listVehicle(){
		List<CreateSelect> table = null;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			// start transaction
			session.beginTransaction();
			System.out.println("start trascation");
			
			  table = session.createQuery("from CreateSelect").list();
			System.out.println("get trascation");
			
			//commit
			session.getTransaction().commit();
			System.out.println("commit trascation");
			
		  return table;
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			session.close();
			factory.close();
		}
		return table;
	}

}
