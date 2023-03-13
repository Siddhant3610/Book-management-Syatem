import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Book extends JFrame implements ActionListener{
	JFrame b;
	JButton del,search,add,execute,cancel;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	int count=0;
	public Book()
	{
		b=new JFrame ("Book Management System");
		
		l1=new JLabel("Title");
		l1.setBounds(55,20,30,20);
		
		l2=new JLabel("Author Name");
		l2.setBounds(55,40,80,20);
		
		l3=new JLabel("Price");
		l3.setBounds(55,60,30,20);
		
		l4=new JLabel("Quantity");
		l4.setBounds(55,80,80,20);
		
		l5=new JLabel("No of Pages");
		l5.setBounds(55,100,80,20);
		
		t1=new JTextField();
		t1.setBounds(140,20,120,20);
		t1.disable();
		
		t2=new JTextField();
		t2.setBounds(140,40,120,20);
		t2.disable();
		
		t3=new JTextField();
		t3.setBounds(140,60,120,20);
		t3.disable();
				
		t4=new JTextField();
		t4.setBounds(140,80,120,20);
		t4.disable();
		
		t5=new JTextField();
		t5.setBounds(140,100,120,20);
		t5.disable();
		
		add=new JButton("Add");
		add.setBounds(55, 130, 100, 30);
		add.addActionListener(this);
		
		search=new JButton("Search");
		search.setBounds(195, 130, 100, 30);
		search.addActionListener(this);
		
		del=new JButton("Delete");
		del.setBounds(335, 130, 100, 30);
		del.addActionListener(this);
		
		execute=new JButton("Execute");
		execute.setBounds(125, 170, 100, 30);
		execute.addActionListener(this);
//		execute.setEnabled(false);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(265, 170, 100, 30);
		cancel.addActionListener(this);
		
		b.add(l1);
		b.add(l2);
		b.add(l3);
		b.add(l4);
		b.add(l5);
		
		b.add(t1);
		b.add(t2);
		b.add(t3);
		b.add(t4);
		b.add(t5);
		
		b.add(del);
		b.add(search);
		b.add(add);
		b.add(execute);
		b.add(cancel);
		
		
		b.setSize(500,240);
		b.setLayout(null);
		b.setLocationRelativeTo(null);
		b.setResizable(false);
		b.setVisible(true);
	}
	void disabled(){
		t1.disable();
		t2.disable();
		t3.disable();
		t4.disable();
		t5.disable();
		
	}
	void txtclear()
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	}
	void enabled()
	{
		t1.enable();
		t2.enable();
		t3.enable();
		t4.enable();
		t5.enable();
	}
		
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob= e.getSource();
		if(ob==add)
		{
			enabled();
			count=1;
		}
		if(e.getSource()==search)
		{
			t1.enable();
			count=2;
		}
		
		else if(ob==del)
		{
			t1.enable();
			count=3;
		}
		
		else if(ob==execute)
		{
			if(count==1)
			{
				String title=t1.getText();
				
				String aname=t2.getText();
				
				int price=Integer.parseInt(t3.getText());
				
				int qty=Integer.parseInt(t4.getText());
				
				int noofpages=Integer.parseInt(t5.getText());
				
				InsertIntoDatabase.insert(title, aname, price, qty, noofpages);
				txtclear();
				disabled();
			}
			else if(count==2)
			{
				String title=t1.getText();
				SearchFromDatabase.search(title);
				txtclear();	
				disabled();
			}
			else if(count==3)
			{
				String title=t1.getText();
				DeleteFromDatabase.delete(title); 
				txtclear();
				disabled();
			}
		}
		else if(ob==cancel){
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		new Book();
	}
}