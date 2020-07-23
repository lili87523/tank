package com.avazhang.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200, y = 200;

    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
        this.setResizable(true);
        this.setTitle("tank war");
        this.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());
    }

    /*The method of paint will be automatically called whenever the window will be changed.
    except closing*/
    @Override
    public void paint(Graphics g){  //Graphics is a pen for you to draw in the window
        //System.out.println("paint");
        g.fillRect(x, y, 50, 50 );
        x += 10;  //change the coordinate so the rectangle will move
        y += 10;

    }

    //create a class for keyboard listener
    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed...");
            x += 30;
            repaint(); //will call paint()
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Key released...");
        }
    }
}
