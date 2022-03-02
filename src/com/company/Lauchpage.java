package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Lauchpage implements ActionListener {
    JFrame frame = new JFrame();
    JButton mybutton1 = new JButton("Play");
    JButton mybutton2 = new JButton("Instructions");
    //JButton mybutton3 = new JButton("High Scores");
    ImageIcon image = new ImageIcon("D:\\Users\\DELL\\SnakeGame\\snake.png");
;
    Lauchpage(){

        mybutton1.setBounds(200, 180, 200, 40);
        mybutton1.setFont(new Font("Consolas", Font.PLAIN, 20));
        mybutton1.setFocusable(false);
        mybutton1.addActionListener(this);

        mybutton2.setBounds(200, 250, 200, 40);
        mybutton2.setFont(new Font("Consolas", Font.PLAIN, 20));
        mybutton2.setFocusable(false);
        mybutton2.addActionListener(this);

//        mybutton3.setBounds(200, 320, 200, 40);
//        mybutton3.setFont(new Font("Consolas", Font.PLAIN, 20));
//        mybutton3.setFocusable(false);
//        mybutton3.addActionListener(this);


        frame.add(mybutton1);
        frame.add(mybutton2);
        //frame.add(mybutton3);
        frame.setIconImage(image.getImage());

        frame.setTitle("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mybutton1){
            frame.dispose(); //one window display
            ChooseSpeed speed = new ChooseSpeed();
        }
        if(e.getSource() == mybutton2){
            frame.dispose(); //one window display
            Instruction ins = new Instruction();
        }


    }

}
