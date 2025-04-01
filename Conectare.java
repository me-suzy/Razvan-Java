import java.sql.*;
import oracle.jdbc.oracore.*;
import oracle.jdbc.driver.*;

class Conectare {
	 private String dbUrl;
	 private String user;
	 private String passw;
	 public Connection c; 
	Conectare(String server,String dataBase, String usr, String pass)
	{
	dbUrl="jdbc:oracle:thin:@"+server+":1521:"+dataBase;
	user=usr;
	passw=pass;
	}
	
	Conectare(String server, String port,String dataBase, String usr, String pass)
	{
	dbUrl="jdbc:oracle:thin:@"+server+":"+port+":"+dataBase;
	user=usr;
	passw=pass;
	}
	
	public String GetDbUrl()
	{
	return 	dbUrl;
	}
	
	public String GetUser()
	{
		return user;
	}
	
	public String GetPassw()
	{
		return passw;
	}
	
	
	public Connection getC()
	{
		return c;
	}
	
	public String Connect()
	{
		String rez="Succes";
	
         try {
         
    		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 
    		}
    	catch(Exception e){
    		rez="Eroare incarcare driver "+e;
    		
    	}
		if(rez=="Succes") 
		{
		
		try {c=DriverManager.getConnection(dbUrl,user,passw);
		}
		
		catch (SQLException e){ rez="Eroare la conectare "+e;
	                          }
		} 
		return rez; 
	} 
	
	
	
}

