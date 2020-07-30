package com.avazhang.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir;
    private final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf;

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        //using paint() to move the object
        //Color c = g.getColor();
        //g.setColor(Color.YELLOW);
        //g.fillRect(x, y, 50, 50);
        //g.setColor(c);
        switch(dir){
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;

        }

        move();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move(){
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire(){
        int bx = x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx, by, this.dir, tf));
    }
}