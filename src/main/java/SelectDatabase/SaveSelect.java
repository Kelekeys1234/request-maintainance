package SelectDatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveSelect {
	
	public static void saveSelect(CreateSelect create) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		Session session = factory.openSession();
		create.setId(create.getId());
		try {
			// start transaction
			System.out.println("start transaction");
			session.beginTransaction();
			
			//save transaction
			session.save(create);
			System.out.println("save transaction");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("commit transaction");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			session.close();
			factory.close();
		}
		
	}

		
	}


