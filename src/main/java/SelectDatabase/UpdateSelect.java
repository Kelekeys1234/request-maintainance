package SelectDatabase;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateSelect {
	
	public static void update(Integer Id , CreateSelect select) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			//start transaction
			System.out.println("start transcation");
			session.beginTransaction();
			//delete query
			
		    CreateSelect mySelect = session.get(CreateSelect.class, Id);
		   
		    mySelect.setId(Id);
		    mySelect.setOffice(select.getOffice());
		    mySelect.setClient(select.getClient());
		    mySelect.setVehicle(select.getVehicle());
		    mySelect.setDriver(select.getDriver());
		    mySelect.setBreakdown(select.getBreakdown());
		    mySelect.setLocation(select.getLocation());
		    mySelect.setComplaint(select.getComplaint());
		    mySelect.setCreatedOn(select.getCreatedOn());
		    
		    
			System.out.println("Query transcation");
			
			session.getTransaction().commit();
			System.out.println("commit transcation");
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			session.close();
			factory.close();
		}
	}
		public static void updateId(Integer Id ) {
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				//start transaction
				System.out.println("start transcation");
				session.beginTransaction();
				//delete query
				
			    CreateSelect mySelect = session.get(CreateSelect.class, Id);
			   
			    mySelect.setId(Id);
			   session.update(mySelect);
			    
				System.out.println("Query transcation");
				
				session.getTransaction().commit();
				System.out.println("commit transcation");
				
			}catch(Exception e) {
				e.printStackTrace();
				e.getMessage();
			}finally {
				session.close();
				factory.close();
			}
	}
		
	

}



	
