import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.*;

public class dia implements ActionListener,Runnable
{
	JFrame f1;
	JLabel l1,l2;
	JLabel dl;
	JPanel p1;
	JButton b1,b2;
	JTextField tf1;
	JTextField tf2;
	JPasswordField pf1;
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
	
	public void diashow()
	{
		
		//System.out.println(new Date());
		
		f1=new JFrame("UserName Password dialog box");
		p1=new JPanel();
		b1=new JButton("Log-in");
		b2=new JButton("Forgot Password");
		l1=new JLabel("Enter Username");
		l2=new JLabel("Enter Password");
		dl=new JLabel("fdffgf");
		tf1=new JTextField(15);
		pf1=new JPasswordField(15);
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
		l1.setBounds(30,30,150,150);
		l2.setBounds(30,60,100,150);
		//dl.setBounds(50,20,50,50);
		tf1.setBounds(80,30,150,100);
		pf1.setBounds(80,60,100,100);
		tf1.setBackground(Color.YELLOW);
		pf1.setBackground(Color.BLACK);
		pf1.setForeground(Color.WHITE);
		//f1.setLayout(new FlowLayout());
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
		ex.addActionListener(this);
		nw.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String am="hotaabhijit777@gmail.com";
		String bm="swadheen.pattnaik@gmail.com";
		
		//System.out.println(un+"\n"+pw);
		char[] pw1={'9','5','4','5','3','2','7','5','1','5'};
		char[] pw2={'9','9','3','8','3','6','2','1','6','2'};
		char[] pw3={'i','a','m','t','e','r','r','o','r','i','s','t'};
		String an="Abhijit Hota";
		String bn="Swadheen Pattnaik";
		String cn="Sachin Sethi";
		
	if(e.getSource()==b1)
	{
		char[] pw=pf1.getPassword();
		String un=tf1.getText();
		if(un.equals("abhijit.hota") && Arrays.equals(pw,pw1))
		{
			makenewform(an);
		}
		else if(un.equals("swadheen.pattnaik") && Arrays.equals(pw,pw2))
		{
			makenewform(bn);
		}
		else if(un.equals("sachin.sethi") && Arrays.equals(pw,pw3))
		{
			makenewform(cn);
		}
		else
		{
			makenoform();
		}
		tf1.setText("");
		pf1.setText("");
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


		
