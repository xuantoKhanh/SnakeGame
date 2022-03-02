package com.company;

import javax.swing.*;

public class Medium extends JFrame {
    Medium(){

        this.add(new Mediumpanel()); //add class gamepanel vào game frame
        this.setTitle("Snake Game"); //set title cho frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); //không thể thay đổi kích thước thủ công
        this.pack(); //fit around all components
        this.setVisible(true);
        this.setLocationRelativeTo(null); //game hiển thị ngay giữa màn hình
    }

}
