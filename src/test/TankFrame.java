package test;
/*
* 用于主界面的绘制
* 1.new坦克
* 2.键盘监听
* 3.键盘事件对应不同的坦克属性设置
*
* */
import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    Tank mytank = new Tank(200,300,Dir.DOWN);
    Bullet bullet = new Bullet(300,300,Dir.DOWN);
//    坦克大战主窗口
    public TankFrame(){
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
//    调用坦克类的绘制和移动方法
    @Override
    public void paint(Graphics g){
        mytank.paint(g);
        //mytank.move();
//       子弹类
        bullet.paint(g);
        //bullet.move();
    }
//    设置键盘监听，主要监听八方向的键盘事件，然后设置坦克的方向属性
    class MyKeyListener extends KeyAdapter {
        boolean BL = false,BR = false,BU = false,BD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:BL = true;break;
                case KeyEvent.VK_RIGHT:BR = true;break;
                case KeyEvent.VK_UP:BU = true;break;
                case KeyEvent.VK_DOWN:BD = true;break;
            }
            setMainTankDir();
        }
// 键盘释放事件主要用于复原键盘按下对应的布尔设置
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:BL = false;break;
                case KeyEvent.VK_RIGHT:BR = false;break;
                case KeyEvent.VK_UP:BU = false;break;
                case KeyEvent.VK_DOWN:BD = false;break;
            }
            setMainTankDir();
        }
//        通过键盘事件来改变坦克对应的方向
        private void setMainTankDir() {
            if(!BL&&!BU&&!BR&&!BD) mytank.setMoving(false);
            else{
                if(BL&&BU) mytank.setDir(Dir.LU);
                else if(BL&&BD) mytank.setDir(Dir.LD);
                else if(BR&&BD) mytank.setDir(Dir.RD);
                else if(BR&&BU) mytank.setDir(Dir.RU);
                else if(BL)mytank.setDir(Dir.LEFT);
                else if(BR)mytank.setDir(Dir.RIGTH);
                else if(BU) mytank.setDir(Dir.UP);
                else if(BD)mytank.setDir(Dir.DOWN);
                mytank.setMoving(true);
            }
        }
    }


}
