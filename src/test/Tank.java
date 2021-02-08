package test;
/*
* 坦克类：主要包含坦克的属性和方法
*
* */
import java.awt.*;

public class Tank {
//    坦克的位置坐标,方向,速度,是否移动
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
//坦克的显示
    public void paint(Graphics g) {
        g.fillRect(x,y,40,40);
    }
//坦克移动
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
