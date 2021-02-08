package test;
/* 子弹类
   子弹坐标，大小，速度
*
* */
import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 2;
    private static final int WIDTH = 30,HEIGHT = 30;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        move();
    }
    public void move() {
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
