import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.sql.*;

public class dia2 implements ActionListener,Runnable
{
	JFrame f1;
	JLabel l1,l2,l3;
	JLabel dl;
	JPanel p1;
	JButton b1,b2,b3;
	JTextField tf1,tf2,tf3;
	JMenuBar mb;
	JMenu f,e,v;
	JMenuItem nw,ex;
	
	JFrame tf;
	JPanel tp;
	JButton tb1,tb2;
	
	JFrame fpf;
	JPanel fpp;
	JButton fpb;
	JTextField fptf;
	
	JFrame vf;
	JPanel vp;
	JButton vb;
	JTable vt;
	
	public void diashow()
	{
		
		//System.out.println(new Date());
		
		f1=new JFrame("Database Interaction");
		p1=new JPanel();
		b1=new JButton("Insert");
		b2=new JButton("Delete");
		b3=new JButton("View Table");
		l1=new JLabel("ID");
		l2=new JLabel("Name");
		l3=new JLabel("Age");
		tf1=new JTextField(15);
		tf2=new JTextField(15);
		tf3=new JTextField(15);
		
		dl=new JLabel("fdffgf");
		mb=new JMenuBar();
		
		f=new JMenu("File");
		e=new JMenu("Edit");
		v=new JMenu("View");
		nw=new JMenuItem("New");
		ex=new JMenuItem("Exit");
		
		mb.add(f);
		mb.add(e);
		mb.add(v);
		f.add(nw);
		f.add(ex);
		f1.setJMenuBar(mb);

		
		/*tf1.setLayout(20,20);
		pf1.setLayout(20,20);*/
		/*l1.setBounds(30,30,150,150);
		l2.setBounds(30,60,100,150);
		//dl.setBounds(50,20,50,50);
		tf1.setBounds(80,30,150,100);
		pf1.setBounds(80,60,100,100);*/
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf1);
		p1.add(l3);
		p1.add(tf3);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		p1.add(dl);
		f1.add(p1);
		
		f1.setVisible(true);
		f1.setSize(500,500);
		f1.setLocation(200,200);
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		
		Thread t = new Thread(this);
		t.start();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		ex.addActionListener(this);
		nw.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Connection con=null;
		String url="jdbc:oracle:thin:localhost:1521:orcl";
		String driver="oracle.jdbc.OracleDriver";
		
		
	if(e.getSource()==b1)
	{
		String s1=tf1.getText();
		String s2=tf2.getText();
		String s3=tf3.getText();
		
		try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,"scott","tiger");
		Statement st=con.createStatement();
		st.executeUpdate("INSERT into tab1 VALUES("+s1+",'"+s2+"',"+s3+")");
		}
		catch(Exception exce)
		{
			System.out.println("Exception occured");
		}
		
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	else if(e.getSource()==b2)
	{
		String s1=tf1.getText();
		String s2=tf2.getText();
		String s3=tf3.getText();
		
		try{
		if(!(s1.equals("")))
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.execute("DELETE FROM tab1 WHERE ID="+s1);
		}
		
		if(!(s2.equals("")))
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.execute("DELETE FROM tab1 WHERE Name='"+s2+"'");
		}
		
		if(!(s3.equals("")))
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.execute("DELETE FROM tab1 WHERE Age="+s3);
		}
		}
		catch(Exception excep)
		{
			System.out.println("Exception occured");
		}
		
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	else if(e.getSource()==b2)
	{
		String i,n,a;
		
		Vector vdata,collect,vcolumn;

		try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,"scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM tab1");
		collect=new Vector();
		
		while(rs.next())
		{
			i=rs.getString(1);
			n=rs.getString(2);
			a=rs.getString(3);
			
			vdata=new Vector();
			
			vdata.add(i);
			vdata.add(n);
			vdata.add(a);
			collect.add(vdata);
		}
		}
		catch(Exception except)
		{
			System.out.println("Exception occured");
		}
		
		vp=new JPanel();
		vb=new JButton("hide");
		vb.addActionListener(this);
		vcolumn=new Vector();
		vcolumn.add("ID");
		vcolumn.add("Name");
		vcolumn.add("Age");
		vt=new  JTable(collect,vcolumn);
		JScrollPane jsp=new JScrollPane(vt);
		vp.add(vb);
		vp.add(vt);
		vp.add(jsp);
		vf.add(vp);
		vf.setVisible(true);
		vf.setSize(500,500);
		vf.pack();
		vb.addActionListener(this);
		
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	
	else if(e.getSource()==vb)
	{
		vf.setVisible(false);
	}

	
	else if(e.getSource()==ex)
	{
		System.exit(0);
	}
	
	else if(e.getSource()==nw)
	{
		tf=new JFrame("New-Options");
		tp=new JPanel();
		tb1=new JButton("Keep Existing");
		tb2=new JButton("Discard Existing");
		tp.add(tb1);
		tp.add(tb2);
		tf.add(tp);
		tf.setSize(300,100);
		tf.setLocation(100,100);
		tf.setVisible(true);
		tb1.addActionListener(this);
		tb2.addActionListener(this);
	}
	
	/*else if(e.getSource()==tb2)
	{
		tf1.setText("");
		pf1.setText("");
		tf.setVisible(false);
	}
	
	else if(e.getSource()==tb1)
	{
		tf.setVisible(false);
		dia d2=new dia();
		d2.diashow();
	}
	
	else if(e.getSource()==b2)
	{
		fpf=new JFrame("Enter e-Mail ID");
		fpp=new JPanel();
		fpb=new JButton("Get Details");
		fptf=new JTextField(15);
		fpp.add(fptf);
		fpp.add(fpb);
		fpf.add(fpp);
		fpf.setSize(200,200);
		fpf.setLocation(150,150);
		fpf.setVisible(true);
		fpb.addActionListener(this);
	}
	
	else if(e.getSource()==fpb)
	{
		fpf.setVisible(false);
		String mail=fptf.getText();
		if(mail.equals(am))
		{
			tf1.setText("abhijit.hota");
			//pf1.setPassword(pw1);
		}
	}*/
	
	}
	
	
	public void run()
	{
		Date date;
		SimpleDateFormat formatter;
		String strdate;
		while(true)
		{
			try{
			date=new Date();
			formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			strdate=formatter.format(date);
			dl.setText(strdate);
			Thread.sleep(1000);
				}
			catch(InterruptedException e){}
		}
	}
	
	
	public void makenewform(String s)
	{
		String pas="Welcome "+s+", Welcome to SQLStar";
		JFrame newf1=new JFrame("Log-In successful");
		JLabel newl1=new JLabel(pas);
		JPanel newp1=new JPanel();
		newp1.add(newl1);
		newf1.add(newp1);
		newf1.setVisible(true);
		newf1.setSize(400,100);
		newf1.setLocation(100,100);
		//newf1.setDefaultCloseOperation(System.exit(0));
	}
	
	public void makenoform()
	{
		JFrame nof1=new JFrame("Log-In failure");
		JLabel nol1=new JLabel("Invalid UserName or Password");
		JPanel nop1=new JPanel();
		nop1.add(nol1);
		nof1.add(nop1);
		nof1.setVisible(true);
		nof1.setSize(400,100);
		nof1.setLocation(100,100);
		//nof1.setDefaultCloseOperation(System.exit(0));
	}
		
		
	public static void main(String arg[])
	{
		dia d=new dia();
		d.diashow();
	}
}


		
