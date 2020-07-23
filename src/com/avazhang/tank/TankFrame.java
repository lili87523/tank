package com.avazhang.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /*The method of paint will be automatically called whenever the window will be changed.
    except closing*/
    @Override
    public void paint(Graphics g){  //Graphics is a pen for you to draw in the window
        //System.out.println("paint");
        g.fillRect(200, 200, 50, 50 );
    }

}
