package SelectDatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSelect {

	public static int delete(Integer Id) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			//start transaction
			System.out.println("start transcation");
			session.beginTransaction();
			//delete query
			
		    CreateSelect select = session.get(CreateSelect.class, Id);
		    session.delete(select);
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
		return 0;

	}
}
