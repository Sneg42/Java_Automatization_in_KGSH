import Combination.Combinations;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Dvorovenko.DI on 12.07.2017.
 */
public class Test {


    public static void main(String[] args) throws Exception {

        Robot robot = new Robot();
//        robot.delay(2000);
//        robot.setAutoDelay(150);
//        //go to felix and check Electriv Excav or not
//          user.addKeyListener(new KeyListener() {
//              @Override
//              public void keyTyped(KeyEvent e) {
//
//              }
//
//              @Override
//              public void keyPressed(KeyEvent e) {
//                  if (e.getKeyCode() == 0xDD) {
//                      System.out.println("]");
//                  }
//              }
//
//              @Override
//              public void keyReleased(KeyEvent e) {
//
//              }
//
//          });
        System.out.println(KeyEvent.VK_1);
        while (true){
            JTextField textField = new JTextField(20);
            textField.addKeyListener(new KeyListener() {

                public void keyPressed(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_1) {
                        System.out.println("]");
                        System.exit(0);
                    }
                }

                public void keyReleased(KeyEvent e) {

                }

                public void keyTyped(KeyEvent e) {

                }

            });
        }

    }
}
