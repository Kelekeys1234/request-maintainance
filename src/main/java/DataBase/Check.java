package DataBase;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class Check {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserTable.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			String email ="favour@gmail.com";
			String password="kelenna";
			// start transaction
			System.out.println("start Transcation");
			session.beginTransaction();
			
			//query transaction
			
			List<UserTable> user =session.createQuery("from UserTable s where  s.getPassword = 'mamawowosan' ").list();
			
			for(UserTable users : user) {
				System.out.println(users.getPassword());
			}
			
			
			
			System.out.println("query Transcation");
			
			// commit
			session.getTransaction().commit();
			System.out.println("commit Transcation");
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			session.close();
			factory.close();
		}
	}
}
	
