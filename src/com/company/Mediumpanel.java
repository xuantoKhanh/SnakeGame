package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;
import javax.swing.JPanel;

public class Mediumpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];  //hold all of coordinates for
    final int y[] = new int[GAME_UNITS];   //all the body parts of snake
    int bodyParts = 3; //chiều dài ban đầu là 6 game unit
    int applesEaten;
    int highScore;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    static boolean gameOn = false;

    //saving score
    private String saveDataPath1;
    private String fileName = "SaveData";

    Mediumpanel(){
        try{
            saveDataPath1 = GamePanel1_error.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            //saveDataPath1 = System.getProperty("user.home") + "SavaData";
        }catch(Exception e){
            e.printStackTrace();
        }
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT ));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        loadHighScore();
        startGame();
    }

    public void startGame(){
        newApple(); //gọi hiển thị quả táo đầu tiên
        running = true;
        timer = new Timer(DELAY, this);
        timer.start(); //bắt đầu tính thời gian
    }
    public void pause() {
        this.gameOn = true;
        timer.stop();
    }

    public void resume() {
        this.gameOn = false;
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g); //gọi lớp draw tiếp  với tham số truyền vào g
    }

    public void draw(Graphics g){
        if(running) {
            //làm lưới
            /*for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); //tạo lưới dọc
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE); //tạo lưới ngang
            }*/

            //set màu vs vị trí quả táo
            g.setColor(Color.red); //set màu quả táo
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE); //fill màu hinh tròn

            //set thân con rắn
            for (int i = 0; i < bodyParts; i++) { //set màu cho phần thân sau khi được ăn thêm táo
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0)); //set màu xanh nhưng cách khai báo khác bên trên
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))); //set màu random cho thân rắn
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE); //fill màu
                }
            }
            g.setColor(Color.red); //set màu Score (điểm) được show mỗi khi run
            g.setFont(new Font("Segoe Print", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH- metrics.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
            g.drawString("Best: " + highScore,(SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten))/2, SCREEN_HEIGHT - 10);
        }
        else{
            gameOver(g);
        }
    }

    public void newApple(){ //đồ ăn, tạo quả táo ở vị trí bất kì
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
        for(int i = bodyParts; i>0; i--){ //dịch chuyển bodypart
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch(direction){ //chuyển hướng của đầu rắn, chữ cái để nhận biết phương hướng
            case 'U':                         //U for Up
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':                         //D for Down
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':                          //L for left
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':                          //R for right
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple(){
        if((x[0] == appleX) && (y[0] == appleY)){   //tạo độ đầu rắn chạm tới tọa độ quả táo
            bodyParts++;   //body part dài hơn
            applesEaten++; //số táo đã ăn đc cộng thêm
            newApple(); //tạo ra quả táo mới
        }
    }

    public void checkCollisions(){ //check va chạm
        //check if head collides with body
        for(int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])){        //the head collied with the body
                running = false;   //game over
            }
        }
        //check if head touches left border
        if(x[0] < 0){
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if(!running ) {
            timer.stop(); //running false ngừng đếm thời gian vì game over
        }
    }

    public void gameOver(Graphics g){
        //Game over score
        g.setColor(Color.red);
        g.setFont(new Font("Segoe Print", Font.BOLD,40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
        g.drawString("Best: " + highScore, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten))/2, SCREEN_HEIGHT -10);
        //Game over text
        g.setColor(Color.red);
        g.setFont(new Font("Segoe Print", Font.BOLD,75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game over", (SCREEN_WIDTH - metrics2.stringWidth("Game over"))/2, SCREEN_HEIGHT/2);

        if(applesEaten > highScore){
            highScore = applesEaten;
        }
        setHighScore();
        ReStart restart = new ReStart();
    }

    private void createSaveData(){
        try{
            File file = new File(saveDataPath1, fileName);

            FileWriter output = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(""+ 0);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void loadHighScore(){
        try{
            File f = new File(saveDataPath1, fileName);
            if(!f.isFile()) {
                createSaveData();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            highScore = Integer.parseInt(reader.readLine());
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void setHighScore(){
        FileWriter output = null;
        try{
            File f = new File(saveDataPath1, fileName);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(""+ highScore);

            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e ){
        if(running){  //sau khi bấm phím, cho rắn chạy
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter { //keypress lệnh ấn từ bàn phím để chuyển động theo hướng
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT: //mũi tên trái
                    if(direction != 'R'){
                        direction = 'L';
                    } break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    } break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    } break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }break;
                case KeyEvent.VK_SPACE:
                    if(Mediumpanel.gameOn){
                        resume();
                    }else{
                        pause();
                    }break;

            }
        }
    }
}
