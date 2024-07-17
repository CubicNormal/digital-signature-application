package javagui_digitalsignature;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainPanel extends JPanel implements MouseListener,MouseMotionListener,ActionListener
{
    private int prevX,prevY,nextX,nextY;
    private JButton btnClear;
    @Override
    public void paintComponent(Graphics g)
    {   
        g.drawLine(prevX, prevY, nextX, nextY);
        prevX=nextX;
        prevY=nextY;
    }
    public MainPanel()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        setForeground(Color.red); //For changing colour of the line
        btnClear=new JButton("Clear");
        btnClear.setBounds(50,50,100,30);
        add(btnClear);
        btnClear.addActionListener(this);
        setOpaque(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                }

    @Override
    public void mousePressed(MouseEvent e) {
        setOpaque(true);
        prevX = e.getX();
        prevY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        nextX = e.getX();
        nextY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prevX=prevY=nextX=nextY=0;
        setOpaque(false);
        repaint();
    }
}

class MainFrame extends JFrame
{
    private MainPanel panel;
    public MainFrame()
    {
        panel = new MainPanel();
        panel.setLayout(new BorderLayout());
        super.add(panel);
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("New User Regestration");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
