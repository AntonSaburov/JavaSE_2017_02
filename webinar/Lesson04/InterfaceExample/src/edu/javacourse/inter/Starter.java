package edu.javacourse.inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by antonsaburov on 06.03.17.
 */
public class Starter
{
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 500, 500);
        JButton btn = new JButton("Press me");
        btn.addActionListener(new First());
        btn.addActionListener(new Second());
        frame.add(btn);

        frame.setVisible(true);
    }
}

class First extends JButton implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("First is called");
    }
}

class Second extends JFrame implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Second is called");
    }
}

