package test;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    private boolean moving;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,40,40);
    }

    public void move() {
        if(!moving) return;
        switch (dir){
            case LEFT:x-=SPEED;break;
            case RIGTH:x+=SPEED;break;
            case UP:y-=SPEED;break;
            case DOWN:y+=SPEED;break;
            case LD:x-=SPEED;y+=SPEED;break;
            case LU:x-=SPEED;y-=SPEED;break;
            case RD:x+=SPEED;y+=SPEED;break;
            case RU:x+=SPEED;y-=SPEED;break;
        }
    }
}
