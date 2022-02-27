package SelectDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CreateSelect.class).buildSessionFactory();
		  Session  session  =factory.openSession();
		    List<CreateSelect> get = new ArrayList<CreateSelect>();
			List<CreateSelect> nul= null;
			try {
				// begin transaction ....
				System.out.println("beggin");
				session.beginTransaction();
				// query audit log
			    AuditReader auditReader = AuditReaderFactory.get(session);
			    List<Number>num = session.createQuery("select u.Id from CreateSelect u").list();
			     
			    for (Number m : num) {
			    		 List<Number> revisions = auditReader.getRevisions(CreateSelect.class,m );
			    		 for(Number var : revisions) {
			    			 CreateSelect select = auditReader.find( CreateSelect.class,m,var);
			    			 get.add(select);
			    		 }
			    }
			    try {
    				
			    	InputStream in = new FileInputStream(new File("C:\\Users\\Toshiba.DESKTOP-492DQSF\\Desktop\\mavenTest\\src\\main\\webapp\\report\\report.jrxml"));
			    	JasperDesign dn = JRXmlLoader.load(in);
			    	JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(get);
			    	JasperReport report = JasperCompileManager.compileReport(dn);
			    	JasperPrint jasperPrint 
  		          = JasperFillManager.fillReport(report, new HashMap(), source);
			    	JasperViewer.viewReport(jasperPrint , false);
			    	 OutputStream out = new FileOutputStream(new File("C:\\Users\\Toshiba.DESKTOP-492DQSF\\Desktop\\mavenTest\\src\\main\\webapp\\report\\report.pdf"));
					 JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			    			}
			    				 catch (Exception e) {
			    			          e.printStackTrace();
			    			      }
			    		
				// commi
			    
			    
			session.getTransaction().commit();
			System.out.println("finish");
			}
			    catch(Exception e) {
				e.printStackTrace();
			}
	
	}
}

