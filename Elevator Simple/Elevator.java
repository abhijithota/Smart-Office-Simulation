import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;


class Elevator extends JPanel implements ActionListener
{
    private Elevator_Controller app;
    private boolean up;
    private int ewidth;
    private int eheight;
    private int pathx;
    private int pathy;
    private int moving;
    private boolean stop;
    private int stopint;
    private int N;
	private int tempref;
    private Timer tm;


    public Elevator(Elevator_Controller App)
    {
        up = true;
        app = App;
        stop = false;
        stopint = 0;
        eheight = app.control.sel[0].getHeight();
        moving = 7 * eheight;
        ewidth = eheight * 3 / 4;
        pathx = (this.getWidth() - ewidth) / 2;
        pathy = this.getHeight() - eheight;
        tm = new Timer(50, this);
        tm.start();
    }

	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        eheight = app.control.sel[0].getHeight();
        ewidth = eheight * 3 / 4;
        g.fillRect(0, 0, this.getWidth(), eheight * 8);
        g.setColor(Color.YELLOW);
        for (int i = 1; i < 8; i++)
        {
            g.drawLine(0, eheight * i, this.getWidth(), eheight * i);
        }
        pathx = (this.getWidth() - ewidth) / 2;
        g.fillRect(pathx, moving, ewidth, eheight);
        g.setColor(Color.black);
        g.drawLine(pathx + ewidth / 2, moving, pathx + ewidth / 2, moving + eheight);  
    }

	
	
	public void checkFloor()
	{
		int i, c;
		c=0;
		System.out.println("checkFloor");
		if(up)
		{
			if(N==7)
			{
				up=false;
			}
			else
			{
				for (i = N+1; i < 8; i++)
				{
					if(app.control.bpsel[i] == false)
					{
						c=1;
						up=true;
						app.control.moveElevator=true;
						break;
					}
				}
			}
			if(c==0)
			{
				for (i = N-1; i >= 0; i--)
				{
					if(app.control.bpsel[i] == false)
					{
						c=1;
						up=false;
						app.control.moveElevator=true;
						break;
					}
				}
			}	
		}
		else
		{
			if(N==0)
			{
				up=true;
			}
			else
			{
				for (i = N-1; i >= 0; i--)
				{
					if(app.control.bpsel[i] == false)
					{
						c=1;
						up=false;
						app.control.moveElevator=true;
						break;
					}
				}
			}
			if(c==0)
			{
				for (i = N+1; i < 8; i++)
				{
					if(app.control.bpsel[i] == false)
					{
						c=1;
						up=true;
						app.control.moveElevator=true;
						break;
					}
				}
			}
		}
	}
	
	public void moveUpwards()
	{
		System.out.println("moveUpwards");
		app.state.setText("moveUpwards");
		moving -= tempref;
		if (moving % eheight < tempref)
		{
			N = 7 - moving / eheight;
			if (N < 0 || N > 7) { N = 0; }
			if (app.control.bpsel[N] == false)
			{
				stop = true;
			}
		}
	}
	
	
	public void moveDownwards()
	{
		System.out.println("moveDownwards");
		app.state.setText("moveDownwards");
		moving += tempref;
		if (moving % eheight < tempref)
		{
			N = 7 - moving / eheight;
			if (N < 0 || N > 7) { N = 0; }
			if (app.control.bpsel[N] == false)
			{
				stop = true;
			}
		}
	}
	
	public void openGate()
	{
		System.out.println("openGate");
	}
	
	public void closeGate()
	{
		System.out.println("closeGate");
	}
	
	
	public void stop()
	{
		System.out.println("stop");
		if(app.control.bp[N] == false)
		{
			moving = (7 - N) * eheight;
			repaint();
			app.control.bpsel[N] = true;
			app.control.sel[N].setBackground(Color.GREEN);
			stop = false;
			app.control.bp[N] = true;
			app.control.mbut[N].setBackground(Color.GREEN);
			try
			{
				Thread.sleep(1000);  
			}
			catch (InterruptedException ie)
			{
				System.out.println(ie.getMessage());
			}
			openGate();
			try
			{
				Thread.sleep(1000);  
			}
			catch (InterruptedException ie)
			{
				System.out.println(ie.getMessage());
			}
			closeGate();
			try
			{
				Thread.sleep(1000);  
			}
			catch (InterruptedException ie)
			{
				System.out.println(ie.getMessage());
			}
			app.state.setText("Stop at floor " + (N + 1));
		}
		else
		{
			moving = (7 - N) * eheight;
			repaint();
			app.control.bpsel[N] = true;
			app.control.sel[N].setBackground(Color.GREEN);
			stop = false;
			app.state.setText("No one present at floor" +(N + 1));
		}
	}
	
    public void actionPerformed(ActionEvent e)
    {
		if(app.control.moveElevator)
		{
			checkFloor();
			if (!stop)
			{
				tempref = eheight / 10;
				if (up)
				{
					moveUpwards();
				}
				else
				{
					moveDownwards();
				}
				repaint();
			}
			else
			{
				stop();
				app.control.moveElevator = false;
				checkFloor();
			}
		}
	}
}