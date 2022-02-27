package DataBase;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class LoginData {
	
	public static boolean loginData(String email ,String password) {
		List<UserTable> table = null;
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserTable.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			// start transaction
			System.out.println("start login Transcation");
			session.beginTransaction();
			
			//query transaction
		session.createQuery("from UserTable s where s.Email = email and s.password = password");
			
			System.out.println("query Transcation");
			
			
			
			
			// commit
			session.getTransaction().commit();
			System.out.println("commit Transcation");
			return true;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			session.close();
			factory.close();
		}
		
		
	return false;
	}

}
