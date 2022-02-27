package DataBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SaveSession {
  public static void save(UserTable table) {
	  
	  SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserTable.class).buildSessionFactory();
		 Session session = factory.getCurrentSession();
	 
	 try {
	  System.out.println("beggin trascation");
	  session.beginTransaction();
	  
	
	  //save session
	   session.save(table);
	 System.out.println("save trascation");
	 //commit
	 
	 session.getTransaction().commit();
	 System.out.println("commit trascation");
	 
	 }catch(Exception e) {
		 e.printStackTrace();
		 e.getMessage();
	 }finally {
		 session.close();
		 factory.close();
		 
	 }
	 
	  
  }
}
