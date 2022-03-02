package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruction extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label1 = new JLabel("Hướng dẫn!");
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JButton button = new JButton("Back");

    Instruction() {

        label1.setBounds(200, 100, 600, 50);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 25));

        label2.setBounds(100, 200, 600, 60);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label2.setText("Sử dụng các phím mũi tên để di chuyển");

        label3.setBounds(80, 300, 600, 60);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label3.setText("Sử dụng phím SPACE để tạm dừng trò chơi!");


        button.setBounds(50, 500, 80, 40);
        button.setFont(new Font("Consolas", Font.PLAIN, 20));
        button.setFocusable(false);
        button.addActionListener(this);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(button);
        frame.setTitle("Instruction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            frame.dispose(); //one window display
            Lauchpage page = new Lauchpage();
        }


    }
}
