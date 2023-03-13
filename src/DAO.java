import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {

	String username="root";
	
	String password="tiger";
	
	String DB_URL="jdbc:mysql://localhost:3306/bookmanagementsystem";
	
	public Connection getConnection()
	{
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			//System.out.println("Connected to Database Successfully!!");
			
			conn=DriverManager.getConnection(DB_URL,username,password);
		}
		catch(Exception e2){
			//System.out.println("Unable to connect to database");
		}
		return conn;
	}
}