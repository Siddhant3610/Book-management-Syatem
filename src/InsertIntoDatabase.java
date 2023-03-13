import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class InsertIntoDatabase 
{
	public static void insert(String title,String aname,int price,int qty,int noofpages) 
	{	   	
		try{
			DAO db = new DAO();
			Connection conn=db.getConnection();
			
			
			
			String insertQuery="insert into book values(?,?,?,?,?)";
			PreparedStatement preparedStatement;
			
			preparedStatement=conn.prepareStatement(insertQuery);
			preparedStatement.setString(1,title+"");
			preparedStatement.setString(2,aname+"");
			preparedStatement.setString(3,price+"");
			preparedStatement.setString(4,qty+"");
			preparedStatement.setString(5,noofpages+"");
			
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Data Successfully Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
		}
	
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Failed to insert data","ERROR",JOptionPane.ERROR_MESSAGE);
		}
  }
}
