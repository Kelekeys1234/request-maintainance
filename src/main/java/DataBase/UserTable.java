package DataBase;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="users")
public class UserTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer Id; 
	@Column(name="FirstName")
	private String FirstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="Email")
	private String Email;
	@Column(name="password")
	private String password;
	public UserTable(String firstName, String lastName, String email, String password) {
		super();
		FirstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.password = password;
	}
	
	public UserTable(String email, String password) {
		super();
		Email = email;
		this.password = password;
	}

	public UserTable() {
		super();
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
