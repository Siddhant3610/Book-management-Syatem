import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class SearchFromDatabase {
	public static void search(String title)
	{
		try{
			DAO db=new DAO();
			Connection conn = db.getConnection();
			
			
			String selectQuery="select * from book where title=?";
			
			PreparedStatement preparedStatement;
			
			preparedStatement =conn.prepareStatement(selectQuery);
			
			preparedStatement.setString(1,title+"");
			
			ResultSet result=preparedStatement.executeQuery();
			
			if(result.next())
			{
				System.out.println("title = "+result.getString(1));
				System.out.println("aname = "+result.getString(2));
				System.out.println("price = "+result.getString(3));
				System.out.println("qty = "+result.getString(4));
				System.out.println("noofpages = "+result.getString(5));
				System.out.println();
				JOptionPane.showMessageDialog(null,"Search  Successfull !!!");
			}
			else
			{
					JOptionPane.showMessageDialog(null, "Please enter valid Title","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e3)
		{
			System.out.println(e3);
		}
	}
}
