import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;


class ButtonPanel extends JPanel implements ActionListener
{
    public JButton mbut[] = new JButton[8];  // 8 Sensors
    public boolean bp[] = new boolean[8]; // the state of each sensors
	public JButton sel[] = new JButton[8];  // 8 Floor Buttons
    public boolean bpsel[] = new boolean[8]; // the state of each button, pressed or not
	public boolean moveElevator = false;

    public ButtonPanel()
    {
        this.setLayout(new GridLayout(8, 2, 0, 0));
        mbut = new JButton[8];
		sel = new JButton[8];
        for (int i = 8; i > 0; i--)
        {
            mbut[i - 1] = new JButton("S" + i);
            mbut[i - 1].setBackground(java.awt.Color.GREEN);
            mbut[i - 1].addActionListener(this);
            this.add(mbut[i - 1]);
            bp[i - 1] = true;
			sel[i - 1] = new JButton("F" + i);
            sel[i - 1].setBackground(java.awt.Color.GREEN);
            sel[i - 1].addActionListener(this);
            this.add(sel[i - 1]);
            bpsel[i - 1] = true;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        int who = Integer.valueOf(e.getActionCommand().substring(1)) - 1;
		char which = (e.getActionCommand().substring(0)).charAt(0);
		if(which == 'S')
		{
			if (mbut[who].getBackground() == java.awt.Color.RED)
			{
				mbut[who].setBackground(java.awt.Color.GREEN);
				bp[who] = true;
			}
			else
			{
				bp[who] = false;
				mbut[who].setBackground(java.awt.Color.RED);
			}
		}
		else
		{
			moveElevator = true;
			if (sel[who].getBackground() == java.awt.Color.GREEN)
			{
				bpsel[who] = false;
				sel[who].setBackground(java.awt.Color.RED);
			}
		}
    }
}