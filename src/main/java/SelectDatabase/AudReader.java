package SelectDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

	
	

public class AudReader {
	 public static SessionFactory factory ;
	 public static Session session ;
	 public static AuditReader auditReader ;
	 
	public static List<CreateSelect> audReader(Integer ID) {
		 List<CreateSelect> list = new ArrayList<CreateSelect>();
		List<CreateSelect> nul= null;
		  factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		    session  =factory.openSession();
			try {
				// begin transaction ....
				System.out.println("beggin");
				session.beginTransaction();
				// query audit log
			     auditReader = AuditReaderFactory.get(session);
			     List<Number> revisions = AudReader.auditReader.getRevisions(CreateSelect.class,ID );
			     for ( Number number1 : revisions) {
			        	CreateSelect select = auditReader.find( CreateSelect.class, ID,number1);
			        	
			        	list.add(select);
			        }
				// commit
			session.getTransaction().commit();
			System.out.println("finish");
	         return list;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return nul;
			
			}
	public static List<CreateSelect> history() {
		factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
	    session  =factory.openSession();
	    List<CreateSelect> list = new ArrayList<CreateSelect>();
		List<CreateSelect> nul= null;
		try {
			// begin transaction ....
			System.out.println("beggin");
			session.beginTransaction();
			// query audit log
		     auditReader = AuditReaderFactory.get(session);
		     List<Number>num = session.createQuery("select u.Id from CreateSelect u").list();
		     
		    for (Number m : num) {
		    		 List<Number> revisions = AudReader.auditReader.getRevisions(CreateSelect.class,m );
		    		 for(Number var : revisions) {
		    			 CreateSelect select = auditReader.find( CreateSelect.class,m,var);
		    			 list.add(select);
		    		 }
		    		
		    }
		       
			// commit
		session.getTransaction().commit();
		System.out.println("finish");
         return list;
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return nul;
	}
	public static void pdf(){
		
	}
}