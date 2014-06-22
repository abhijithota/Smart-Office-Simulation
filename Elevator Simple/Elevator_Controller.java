import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Elevator_Controller extends JFrame
{
    public JLabel state;
    private JLabel id;
    public ButtonPanel control;
    private Elevator elevator;

    public Elevator_Controller()
    {
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 2);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel leftpanel = new JPanel();
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new FlowLayout());
        control = new ButtonPanel();
        this.getContentPane().add(control, BorderLayout.WEST);
        state = new JLabel();
        state.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        state.setText(" ");
        state.setBackground(java.awt.Color.LIGHT_GRAY);
        this.getContentPane().add(state, BorderLayout.SOUTH);
        this.setVisible(true);   
        elevator = new Elevator(this);
        this.getContentPane().add(elevator, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        Elevator_Controller es = new Elevator_Controller();
        es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        es.setVisible(true);
    }

}