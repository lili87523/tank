package com.avazhang.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank myTank = new Tank(200, 500, Dir.DOWN, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    Bullet b = new Bullet(200, 200, Dir.DOWN, Group.GOOD, this);
    Explode e = new Explode(100, 100, this);
    public TankFrame() throws HeadlessException {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(true);
        this.setTitle("tank war");
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());
    }


    //to avoid the blink on the screen, we can draw our image in memory, and after it is ready, transfer it all-in-one to the screen
    //update() is called before paint()
    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /*The method of paint will be automatically called whenever the window will be changed.
    except closing*/
    @Override
    public void paint(Graphics g){  //Graphics is a pen for you to draw in the window
        //System.out.println("paint");
        //x += 10;  //change the coordinate so the rectangle will move
        //y += 10;
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.drawString("Bullets quantity:" + bullets.size(), 350, 60);
        g.drawString("Enemies quantity:" + tanks.size(), 350, 100);
        g.setColor(c);

        //draw my tank
        myTank.paint(g);
        myTank.setMoving(false);

        //draw enemy tanks
        for(int i = 0; i < tanks.size(); i++){
            tanks.get(i).paint(g);
        }

        //
        for(int i = 0; i < bullets.size(); i++){
            for(int j = 0; j < tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
        //this method will cause concurrent problem
//        for(Bullet b : bullets){
//            b.paint(g);
//        }

        //draw my tank's bullets
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).paint(g);
        }
        e.paint(g);
    }


    //create a class for keyboard listener
    //MyKeyListener just listen which key is pressed or released; no movement here
    class MyKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            //according to the key pressed, we can decide the direction for the tank
            switch(keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
            //repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                default:
                    break;

            }
            setMainTankDir();
            //System.out.println("Key released...");
        }

        public void setMainTankDir(){
            if(!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
            }
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }


        }
    }
}
