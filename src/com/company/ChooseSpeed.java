package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseSpeed extends JFrame implements ActionListener {
    JFrame frame1 = new JFrame();
    JButton button1 = new JButton("Slow");
    JButton button2 = new JButton("Medium");
    JButton button3 = new JButton("Fast");
    JButton button4 = new JButton("Back");

    ChooseSpeed(){

        button1.setBounds(230, 180, 150, 40);
        button1.setFont(new Font("Consolas", Font.PLAIN, 20));
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2.setBounds(230, 250, 150, 40);
        button2.setFont(new Font("Consolas", Font.PLAIN, 20));
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3.setBounds(230, 320, 150, 40);
        button3.setFont(new Font("Consolas", Font.PLAIN, 20));
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4.setBounds(50, 500, 80, 40);
        button4.setFont(new Font("Consolas", Font.PLAIN, 20));
        button4.setFocusable(false);
        button4.addActionListener(this);

        frame1.add(button1);
        frame1.add(button2);
        frame1.add(button3);
        frame1.add(button4);

        frame1.setTitle("Choose the speed!");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 600);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            frame1.dispose(); //one window display
            GameFrame frame = new GameFrame();
        }
        if(e.getSource() == button2){
            frame1.dispose(); //one window display
            Medium medium = new Medium();
        }
        if(e.getSource() == button3){
            frame1.dispose(); //one window display
            Hard hard = new Hard();

        }
        if(e.getSource() == button4){
            frame1.dispose(); //one window display
            Lauchpage lauch = new Lauchpage();
        }
    }


}
