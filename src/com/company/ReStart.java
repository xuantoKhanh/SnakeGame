package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReStart extends JFrame implements ActionListener {
    JFrame frame1 = new JFrame();
    JButton button1 = new JButton("Play again :)))");
    //JButton button3 = new JButton("High score");
    JButton button2 = new JButton("Exit!");
    JLabel label = new JLabel();


    ReStart(){

        button1.setBounds(200, 200, 200, 40);
        button1.setFont(new Font("Consolas", Font.PLAIN, 20));
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2.setBounds(200, 270, 200, 40);
        button2.setFont(new Font("Consolas", Font.PLAIN, 20));
        button2.setFocusable(false);
        button2.addActionListener(this);
//
//        button3.setBounds(200, 270, 200, 40);
//        button3.setFont(new Font("Consolas", Font.PLAIN, 20));
//        button3.setFocusable(false);
//        button3.addActionListener(this);

        label.setText("Game over!");
        label.setBounds(80, 0, 600, 200);
        label.setFont(new Font("Segoe Print", Font.BOLD,75));
        label.setForeground(Color.red);
        label.setOpaque(true);

        frame1.add(button1);
        frame1.add(button2);
        //frame1.add(button3);
        frame1.add(label);
        frame1.setTitle("Game over!");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setBackground(Color.BLACK);
        frame1.setSize(600, 600);
        frame1.setLayout(null);

        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            frame1.dispose(); //one window display
           ChooseSpeed speed = new ChooseSpeed();
        }
        if(e.getSource() == button2){
            frame1.dispose(); //one window display
            System.exit(0);
        }
//        if(e.getSource() == button3) {
//            frame1.dispose(); //one window display
//        }

    }

}
