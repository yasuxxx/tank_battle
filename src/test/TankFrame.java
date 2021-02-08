package test;

import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    Tank mytank = new Tank(200,300,Dir.DOWN);
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
    @Override
    public void paint(Graphics g){
        mytank.paint(g);
        mytank.move();

    }
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
