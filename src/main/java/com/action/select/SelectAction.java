package com.action.select;




import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import com.bean.Select;
import com.opensymphony.xwork2.ActionSupport;

import SelectDatabase.AudReader;
import SelectDatabase.CreateSelect;
import SelectDatabase.SaveSelect;
import SelectDatabase.UpdateSelect;

@Results({
	@Result(name="success" , location ="/success.jsp"),
	@Result(name="getVehicle" , location ="/listVehicle.jsp"),
	@Result(name="update" , location="/update.jsp"),
	@Result(name = "history" , location ="/history.jsp")
})
@Namespace("/select")

public class SelectAction extends ActionSupport{
	private static final long serialVersionUID = -9140802737198067408L;
	//select field
	private Select select;
     CreateSelect selects ;
 
	//list select
     Integer Id;
	Integer Ir;
	
	@Action("/update")
	public String update() {
		
	    UpdateSelect.update(Id ,new CreateSelect(select.getOffice(),select.getClient(),select.getVehicle(),select.getDriver(),select.getBreakdown(),select.getLocation(),select.getComplaint(),new Date()));
	    
	    return "success";
	}
	
	@Action("/updateId")
	public String updateId() {
		UpdateSelect.updateId(Id);
	
		
		return "update";
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
	public CreateSelect getSelects() {
		return selects;
	}


	
	public void setSelects(CreateSelect selects) {
		this.selects = selects;
	}
	

	
	
	
}
