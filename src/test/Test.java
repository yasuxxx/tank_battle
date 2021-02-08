package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
