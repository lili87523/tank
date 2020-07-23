package com.avazhang.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800, 500);
        f.setResizable(false);
        f.setTitle("tank war");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
