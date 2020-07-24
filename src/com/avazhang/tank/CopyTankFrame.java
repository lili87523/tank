package com.avazhang.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CopyTankFrame extends Frame {
    int x = 200, y = 200;

    public CopyTankFrame() throws HeadlessException{
        setSize(800, 600);
        setResizable(true);
        setTitle("Tank War");
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());

    }

    @Override
    public void paint(Graphics g){
        g.fillRect(x, y, 50, 50);
        //x += 20;
        //y += 20;
        //repaint();
    }

    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("pressed....");
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_DOWN:
                    y += 20;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 20;
                    break;
                case KeyEvent.VK_UP:
                    y -= 20;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 20;
                    break;
                default:break;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released...");
        }
    }
}
