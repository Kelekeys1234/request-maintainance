package SelectDatabase;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

import javax.persistence.Id;



@Entity
@Table(name="request")

@Audited 

public class CreateSelect {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO  )
	@Column(name="Id" , updatable = false , nullable = false)
	private Integer Id;
	@Column(name="office")
	private String office;
	@Column(name="client")
	private String client;
	@Column(name="vehicle")
	private String vehicle;
	@Column(name="drivers")
	private String driver;
	@Column(name="breakedown")
	private String breakdown;
	@Column(name="location")
	private String location;
	@Column(name="complaint")
	private String complaint;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date createdOn;
	
	public String getOffice() {
		return office;
	}
	public CreateSelect(String office, String client, String vehicle, String driver, String breakdown, String location,
			String complaint , Date createdOn) {
		super();
		this.office = office;
		this.client = client;
		this.vehicle = vehicle;
		this.driver = driver;
		this.breakdown = breakdown;
		this.location = location;
		this.complaint = complaint;
		this.createdOn = createdOn;
	}
	
	
	
		public CreateSelect(Integer id) {
		super();
		Id = id;
	}
		public void setOffice(String office) {
		this.office = office;
	}
	
	
	public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public  String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getBreakdown() {
		return breakdown;
	}
	public void setBreakdown(String breakdown) {
		this.breakdown = breakdown;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public CreateSelect() {
		super();
	}
	
	
	

}
