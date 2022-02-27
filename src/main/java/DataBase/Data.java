package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  String url = "jdbc:postgresql://localhost:5432/project?useSSl=false";
  String name = "postgres";
  String password = "kelenna";
  try {
	  Connection conn= DriverManager.getConnection(url,name,password);
	  System.out.println("connected");
  }catch(Exception e) {
	  System.out.println("Not connected");
	  e.getMessage();
	  e.printStackTrace();
  }
	}

}
