import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Arrays;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.sql.*;

public class pro implements ActionListener,Runnable
{
	JFrame f1;
	JLabel l1,l2;
	JLabel dl;
	JPanel p1;
	JButton b1,b2;
	JTextField tf1;
	JTextField pf1;
	JMenuBar mb;
	JMenu f,e,v;
	JMenuItem nw,ex;
	
	JFrame tf;
	JPanel tp;
	JButton tb1,tb2;
	
	JFrame newf1;
	JLabel newl1;
	JButton newb1;
	JButton newb2;
	JButton newb3;
	JPanel newp1;
	
	
	public void diashow()
	{
		f1=new JFrame("UserName-Password dialog box");
		p1=new JPanel();
		b1=new JButton("Log-in");
		b2=new JButton("Exit");
		l1=new JLabel("Enter Username");
		l2=new JLabel("Enter Password");
		tf1=new JTextField(15);
		pf1=new JPasswordField(15);
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
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(pf1);
		p1.add(b1);
		p1.add(b2);
		p1.add(dl);
		f1.add(p1);
		f1.setVisible(true);
		f1.setSize(300,300);
		f1.setLocation(200,300);
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		
		Thread t = new Thread(this);
		t.start();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		ex.addActionListener(this);
		nw.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pw1="9545327515";
		String pw2="9938362162";
		String an="Abhijit Hota";
		String bn="Swadheen Pattnaik";
			
		if(e.getSource()==b1)
		{
			String pw=pf1.getText();
			String un=tf1.getText();
			if(un.equals("abhijit.hota") && pw.equals(pw1))
			{
				f1.setVisible(false);
				LogSuccess ls=new LogSuccess(an);
			}
			else if(un.equals("swadheen.pattnaik") && pw.equals(pw2))
			{
				f1.setVisible(false);
				LogSuccess ls=new LogSuccess(bn);
			}
			else
			{
				makenoform();
			}
			tf1.setText("");
			pf1.setText("");
		}
		
		else if(e.getSource()==b2)
		{
			System.exit(0);
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
		
		else if(e.getSource()==tb2)
		{
			tf1.setText("");
			pf1.setText("");
			tf.setVisible(false);
		}
		
		else if(e.getSource()==tb1)
		{
			tf.setVisible(false);
			pro d2=new pro();
			d2.diashow();
		}
		
		else if(e.getSource()==newb1)
		{
			newf1.setVisible(false);
			LogSuccess ls1=new LogSuccess("Student");
		}
		
		else if(e.getSource()==newb2)
		{
			newf1.setVisible(false);
			LogSuccess ls2=new LogSuccess("Courses");
		}
		
		else if(e.getSource()==newb3)
		{
			newf1.setVisible(false);
			LogSuccess ls3=new LogSuccess("Branches");
		}
		
		
		
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
		newf1=new JFrame("Log-In successful");
		newl1=new JLabel(pas);
		newb1=new JButton("Student");
		newb2=new JButton("Courses");
		newb3=new JButton("Branches");
		newp1=new JPanel();
		
		newp1.add(newl1);
		newp1.add(newb1);
		newp1.add(newb2);
		newp1.add(newb3);
		newf1.add(newp1);
		newf1.setVisible(true);
		
		newb1.addActionListener(this);
		newb2.addActionListener(this);
		newb3.addActionListener(this);
		
		newf1.setSize(400,200);
		newf1.setLocation(100,100);
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
		pro d=new pro();
		d.diashow();
	}
}

















class LogSuccess implements ActionListener
{

	Connection con;
	String url;
	String driver;
	
	JFrame lsf;
	JPanel lsp;
	JButton lsb1,lsb2,lsb3,lsb4;
	JLabel lsl;
	
	JFrame sf;
	JPanel sp;
	JButton sb1,sb2,sb3,sb4;
	JLabel sl1,sl2,sl3,sl4,sl5;
	JTextField stf1,stf2,stf3,stf4,stf5;
	
	JFrame cf;
	JPanel cp;
	JButton cb1,cb2,cb3,cb4;
	JLabel cl1,cl2,cl3,cl4;
	JTextField ctf1,ctf2,ctf3,ctf4;
	
	JFrame bf;
	JPanel bp;
	JButton bb1,bb2,bb3,bb4;
	JLabel bl1,bl2;
	JTextField btf1,btf2;
	
	String s1,s2,s3,s4,s5;
	
	JPanel vp;
	JFrame vf;
	JButton vb;
	JTable vt;
	
	public LogSuccess(String s)
	{
		lsf=new JFrame("Hello "+s);
		lsp=new JPanel();
		lsl=new JLabel("Logged is as "+s);
		lsb1=new JButton("Student Database");
		lsb2=new JButton("Courses Database");
		lsb3=new JButton("Branches Database");
		lsb4=new JButton("Back/LogOut");
		
		lsp.add(lsl);
		lsp.add(lsb1);
		lsp.add(lsb2);
		lsp.add(lsb3);
		lsp.add(lsb4);
		lsf.add(lsp);
		
		lsf.setSize(300,100);
		lsf.setLocation(100,100);
		lsf.setVisible(true);
		lsf.pack();
		lsf.setDefaultCloseOperation(lsf.EXIT_ON_CLOSE);
		
		lsb1.addActionListener(this);
		lsb2.addActionListener(this);
		lsb3.addActionListener(this);
		lsb4.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		if(ee.getSource()==lsb1)
		{
			lsf.setVisible(false);
			Student();
		}
		
		else if(ee.getSource()==lsb2)
		{
			lsf.setVisible(false);
			Courses();
		}
		
		else if(ee.getSource()==lsb3)
		{
			lsf.setVisible(false);
			Branches();
		}
		
		else if(ee.getSource()==lsb4)
		{
			lsf.setVisible(false);
			pro d2=new pro();
			d2.diashow();
		}
		
		/*--------------Students---------------*/
		
		else if(ee.getSource()==sb1)
		{
			insert("Student");	
		}
		
		else if(ee.getSource()==sb2)
		{
			delete("Student");
		}
		
		else if(ee.getSource()==sb3)
		{
			view("Student");	
		}
		
		else if(ee.getSource()==sb4)
		{
			sf.setVisible(false);
			lsf.setVisible(true);
		}
		
		/*----------Courses-------*/
		
		else if(ee.getSource()==cb1)
		{
			insert("Courses");
		}
		
		else if(ee.getSource()==cb2)
		{
			delete("Courses");
			
		}
		
		else if(ee.getSource()==cb3)
		{
			view("Courses");
			
		}
		
		else if(ee.getSource()==cb4)
		{
			cf.setVisible(false);
			lsf.setVisible(true);
			
		}
		
		/*------------Branches-------------*/
		
		else if(ee.getSource()==bb1)
		{
			insert("Branches");
		}
		
		else if(ee.getSource()==bb2)
		{
			delete("Branches");
		}
		
		else if(ee.getSource()==bb3)
		{
			view("Branches");
		}
		
		else if(ee.getSource()==bb4)
		{
			bf.setVisible(false);
			lsf.setVisible(true);
		}
		
		else if(ee.getSource()==vb)
		{
			vf.setVisible(false);
		}
	}
	
	
	/*------------------------------------------------------------------*/
	
	public void Student()
	{
		sf=new JFrame("Student Database Interaction");
		sp=new JPanel();
		
		sb1=new JButton("Insert");
		sb2=new JButton("Delete");
		sb3=new JButton("View Table");
		sb4=new JButton("Back");
		
		sl1=new JLabel("ID");
		sl2=new JLabel("Name");
		sl3=new JLabel("Age");
		sl4=new JLabel("Course ID");
		sl5=new JLabel("Address");
		
		stf1=new JTextField(15);
		stf2=new JTextField(15);
		stf3=new JTextField(15);
		stf4=new JTextField(15);
		stf5=new JTextField(15);
		
		sp.add(sl1);
		sp.add(stf1);
		sp.add(sl2);
		sp.add(stf1);
		sp.add(sl3);
		sp.add(stf3);
		sp.add(sl4);
		sp.add(stf4);
		sp.add(sl5);
		sp.add(stf5);
		sp.add(sb1);
		sp.add(sb2);
		sp.add(sb3);
		sp.add(sb4);
		sf.add(sp);
		
		sf.setVisible(true);
		sf.setSize(500,500);
		sf.setLocation(200,200);
		sf.setDefaultCloseOperation(sf.EXIT_ON_CLOSE);
		
		sb1.addActionListener(this);
		sb2.addActionListener(this);
		sb3.addActionListener(this);
		sb4.addActionListener(this);		
	}
	
	public void Courses()
	{
		cf=new JFrame("Courses Database Interaction");
		cp=new JPanel();
		cb1=new JButton("Insert");
		cb2=new JButton("Delete");
		cb3=new JButton("View Table");
		cb4=new JButton("Back");
		
		cl1=new JLabel("Course ID");
		cl2=new JLabel("Course Name");
		cl3=new JLabel("Price");
		cl4=new JLabel("Duration");

		ctf1=new JTextField(15);
		ctf2=new JTextField(15);
		ctf3=new JTextField(15);
		ctf4=new JTextField(15);
		
		cp.add(cl1);
		cp.add(ctf1);
		cp.add(cl2);
		cp.add(ctf1);
		cp.add(cl3);
		cp.add(ctf3);
		cp.add(cl4);
		cp.add(ctf4);
		
		cp.add(cb1);
		cp.add(cb2);
		cp.add(cb3);
		cp.add(cb4);
		cf.add(cp);
		
		cf.setVisible(true);
		cf.setSize(500,500);
		cf.setLocation(200,200);
		cf.setDefaultCloseOperation(cf.EXIT_ON_CLOSE);
		
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		cb3.addActionListener(this);
		cb4.addActionListener(this);
	}
	
	
	public void Branches()
	{
		bf=new JFrame("Branches Database Interaction");
		bp=new JPanel();
		bb1=new JButton("Insert");
		bb2=new JButton("Delete");
		bb3=new JButton("View Table");
		bb4=new JButton("Back");
		
		bl1=new JLabel("Branch Name");
		bl2=new JLabel("Branch Location");

		btf1=new JTextField(15);
		btf2=new JTextField(15);
		
		bp.add(bl1);
		bp.add(btf1);
		bp.add(bl2);
		bp.add(btf1);
		
		bp.add(bb1);
		bp.add(bb2);
		bp.add(bb3);
		bp.add(bb4);
		bf.add(bp);
		
		bf.setVisible(true);
		bf.setSize(500,500);
		bf.setLocation(200,200);
		bf.setDefaultCloseOperation(bf.EXIT_ON_CLOSE);
		
		bb1.addActionListener(this);
		bb2.addActionListener(this);
		bb3.addActionListener(this);
		bb4.addActionListener(this);
	}
	

	/*------------------------------------------------------------------*/
	
	public void insert(String src1)
	{
		con=null;
		url="jdbc:oracle:thin:localhost:1521:orcl";
		driver="oracle.jdbc.OracleDriver";

		if(src1.equals("Student"))
		{
			s1=stf1.getText();
			s2=stf2.getText();
			s3=stf3.getText();
			s4=stf4.getText();
			s5=stf5.getText();
			
			try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.executeUpdate("INSERT into "+src1+" VALUES("+s1+",'"+s2+"',"+s3+",'"+s4+"','"+s5+"')");
			}
			catch(Exception exce)
			{
				System.out.println("Exception occured "+exce);
			}
			
			stf1.setText("");
			stf2.setText("");
			stf3.setText("");
			stf4.setText("");
			stf5.setText("");
		}
		
		
		else if(src1.equals("Courses"))
		{
			s1=ctf1.getText();
			s2=ctf2.getText();
			s3=ctf3.getText();
			s4=ctf3.getText();
			
			try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.executeUpdate("INSERT into "+src1+" VALUES('"+s1+"',"+s2+",'"+s3+"','"+s4+"')");
			}
			catch(Exception exce)
			{
				System.out.println("Exception occured "+exce);
			}
			
			ctf1.setText("");
			ctf2.setText("");
			ctf3.setText("");
			ctf4.setText("");
		}
		
		
		else if(src1.equals("Branches"))
		{
			s1=btf1.getText();
			s2=btf2.getText();
			
			try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Statement st=con.createStatement();
			st.executeUpdate("INSERT into "+src1+" VALUES('"+s1+"','"+s2+"')");
			}
			catch(Exception exce)
			{
				System.out.println("Exception occured "+exce);
			}
			
			btf1.setText("");
			btf2.setText("");
		}
		
	}
	
	
	public void delete(String src2)
	{	
	
		if(src2.equals("Student"))
		{
			s1=stf1.getText();
			s2=stf2.getText();
			s3=stf3.getText();
			s4=stf3.getText();
			s5=stf3.getText();
			
			try{
			if(!(s1.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE ID="+s1);
			}
			
			if(!(s2.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Name='"+s2+"'");
			}
			
			if(!(s3.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Age="+s3);
			}
			
			if(!(s4.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE CourseID='"+s3+"'");
			}
			
			if(!(s5.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Address='"+s3+"'");
			}
			}
			catch(Exception excep)
			{
				System.out.println("Exception occured +excep");
			}
			
			stf1.setText("");
			stf2.setText("");
			stf3.setText("");
			stf4.setText("");
			stf5.setText("");
		}
		
		
		else if(src2.equals("Courses"))
		{
			s1=ctf1.getText();
			s2=ctf2.getText();
			s3=ctf3.getText();
			s4=ctf3.getText();
			
			try{
			if(!(s1.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE CourseID='"+s1+"'");
			}
			
			if(!(s2.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Price="+s2);
			}
			
			if(!(s3.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Duration='"+s3+"'");
			}
			
			if(!(s4.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE CourseName='"+s3+"'");
			}
			}
			catch(Exception excep)
			{
				System.out.println("Exception occured "+excep);
			}
			
			ctf1.setText("");
			ctf2.setText("");
			ctf3.setText("");
			ctf4.setText("");
		}
		
		
		else if(src2.equals("Branches"))
		{
			s1=btf1.getText();
			s2=btf2.getText();
			
			try{
			if(!(s1.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE BranchName='"+s1+"'");
			}
			
			if(!(s2.equals("")))
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url,"scott","tiger");
				Statement st=con.createStatement();
				st.execute("DELETE FROM "+src2+" WHERE Location='"+s2+"'");
			}
			}
			catch(Exception excep)
			{
				System.out.println("Exception occured "+excep);
			}
			
			btf1.setText("");
			btf2.setText("");
		}
	}
	
	
	public void view(String src3)
	{
		String sr1,sr2,sr3,sr4,sr5;
		Vector vdata,collect,vcolumn;

		try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,"scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM "+src3);
		collect=new Vector();
		vcolumn=new Vector();
		
		if(src3.equals("Students"))
		{
			while(rs.next())
			{
				sr1=rs.getString(1);
				sr2=rs.getString(2);
				sr3=rs.getString(3);
				sr4=rs.getString(4);
				sr5=rs.getString(5);
				
				vdata=new Vector();
				
				vdata.add(sr1);
				vdata.add(sr2);
				vdata.add(sr3);
				vdata.add(sr4);
				vdata.add(sr5);
				collect.add(vdata);
			}
			vcolumn.add("ID");
			vcolumn.add("Name");
			vcolumn.add("Age");
			vcolumn.add("Course ID");
			vcolumn.add("Location");
		}
		
		if(src3.equals("Courses"))
		{
			while(rs.next())
			{
				sr1=rs.getString(1);
				sr2=rs.getString(2);
				sr3=rs.getString(3);
				sr4=rs.getString(4);
				
				vdata=new Vector();
				
				vdata.add(sr1);
				vdata.add(sr2);
				vdata.add(sr3);
				vdata.add(sr4);
				collect.add(vdata);
			}
			vcolumn.add("Course ID");
			vcolumn.add("Price");
			vcolumn.add("Duration");
			vcolumn.add("Course Name");
		}
		
		if(src3.equals("Branches"))
		{
			while(rs.next())
			{
				sr1=rs.getString(1);
				sr2=rs.getString(2);
				
				vdata=new Vector();
				
				vdata.add(sr1);
				vdata.add(sr2);
				collect.add(vdata);
			}
			vcolumn.add("Branch Name");
			vcolumn.add("Location");
		}
		
		vp=new JPanel();
		vf=new JFrame();
		vb=new JButton("hide");
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
		}
		catch(Exception except)
		{
			System.out.println("Exception occured "+except);
		}
		
	}
	
}


