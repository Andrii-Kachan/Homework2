package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Paint extends JFrame implements MouseMotionListener, ActionListener {

    int x = 0;
    int y = 0;
    Color color = Color.BLACK;

    public Paint() {

        setSize(400, 400);
        setTitle("Paint");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        JButton black = new JButton("black");
        JButton red = new JButton("red");
        JButton blue = new JButton("blue");
        JButton yellow = new JButton("yellow");

        black.setBackground(Color.black);
        red.setBackground(Color.red);
        blue.setBackground(Color.blue);
        yellow.setBackground(Color.yellow);

        panel.add(black);
        panel.add(red);
        panel.add(blue);
        panel.add(yellow);

        black.addActionListener(this);
        red.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        JLabel direct = new JLabel("Drag to draw", JLabel.RIGHT);
        container.add(direct, BorderLayout.SOUTH);
        container.add(panel, BorderLayout.EAST);
        container.addMouseMotionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if (act.equals("blue")){
            color = Color.BLUE;
        }
        else if (act.equals("red")){
            color = Color.RED;
        }
        else if (act.equals("yellow")){
            color = Color.YELLOW;
        }
        else {
            color = Color.BLACK;
        }
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, 3, 3);
    }
}
