package com.avazhang.tank;

import java.awt.*;

public class Bullet {
    public static final int SPEED = 10, WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf;
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }



    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH,HEIGHT);
//        g.setColor(c);
        switch(dir){
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
        }
        move();
    }

    public void move(){
        switch(dir){
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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }


    }

    public void collideWith(Tank tank){
        if(this.group == tank.getGroup())
            return;

        //TODO:add Rect field to Tank and Bullet Class
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
        if(rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }

    public void die(){
        this.live = false;
    }
}
