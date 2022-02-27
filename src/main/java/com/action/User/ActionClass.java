package com.action.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.bean.Select;
import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DataBase.LoginData;
import DataBase.SaveSession;
import DataBase.UserTable;
import SelectDatabase.AudReader;
import SelectDatabase.CreateSelect;
import SelectDatabase.DeleteSelect;
import SelectDatabase.ListVehicle;
import SelectDatabase.Pdf;
import SelectDatabase.SaveSelect;
import SelectDatabase.UpdateSelect;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Namespace("/User")
@Results({
	@Result(name="login", location="/login.jsp"),
	@Result(name="vehicle", location="/vehicle.jsp"),
	@Result(name="getVehicle" , location ="/listVehicle.jsp"),
	@Result(name="success" , location ="/success.jsp"),
	@Result(name = "history" , location ="/history.jsp"),
	@Result(name = "all" , location ="/allHistory.jsp")
	
})

   public class ActionClass extends ActionSupport{
	private static final long serialVersionUID = -5518082085738840161L;
	// field
	private User user;
	private Select select;
	List<CreateSelect> create ;
	List<CreateSelect> history ;
	 public Integer ID;
	// execute action
	@Action("/userSign")
	public String execute() {
		SaveSession.save(new UserTable(user.getFirstname(),user.getLastname(),user.getEmail(),user.getPassword()));

		return "login";
	}
	
	// user login
	
	@Action("/userLogin")
	public String login() {
		boolean valid = LoginData.loginData(user.getEmail(), user.getPassword());
		
			if(!valid ) {
				return "login";
			}
			return "vehicle";
				
	}
	// pdf report
	@Action("/jasper")
	public String jasper()  {
		Pdf.pdf();
		history=AudReader.history();
		return "all";
	}
	
	// insert vehicle maintainance
	@Action("/vechicle")
	public String inserts() {
		
		SaveSelect.saveSelect(new CreateSelect(select.getOffice(),select.getClient(),select.getVehicle(),select.getDriver(),select.getBreakdown(),select.getLocation(),select.getComplaint(), new Date()));
		create=ListVehicle.listVehicle();
		return "getVehicle";
	}
	
	@Action("/record")
	public String getRecord() {
		create=ListVehicle.listVehicle();
		return "getVehicle";
	}
	// aud  reader
	@Action("/audReader")
	 public String audReadr() {
          history =AudReader.audReader(ID);
		return "history";
			}
	
	// get all the history
	@Action("/getHistory")
	public String getAud() {
		history= AudReader.history();
		
		return "all";
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
		Integer Id;
		@Action("/delete")
		public String  Delete() {
			DeleteSelect.delete(Id);
			return "success";
			}
			

	public Integer getID() {
			return ID;
		}

		public void setID(Integer iD) {
			ID = iD;
		}

	public List<CreateSelect> getHistory() {
			return history;
		}

		public void setHistory(List<CreateSelect> history) {
			this.history = history;
		}

	public List<CreateSelect> getCreate() {
		return create;
	}
	
	

	public Select getSelect() {
		return select;
	}

	public void setSelect(Select select) {
		this.select = select;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setCreate(List<CreateSelect> create) {
		this.create = create;
	}
	

}
