package OFIEra.controller.Era_In.Equipment;

import OFIEra.controller.Era_In.Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class EquipmentEmissions {

         public void fillEquipmentEmissions(int repeat, Robot robot) {
         // queue for copy data from Felix and past im Era
         Queue queue = new LinkedList();

         // queue for all emissions in Equipments
         Queue queueEmmissions = new LinkedList();
         for (int i = 0; i < repeat; i++) {

             queueEmmissions.add("3749");
             queueEmmissions.add("2909");
             queueEmmissions.add("2908");
             queueEmmissions.add("2732");
             queueEmmissions.add("0337");
             queueEmmissions.add("0330");
             queueEmmissions.add("0328");
             queueEmmissions.add("0304");
             queueEmmissions.add("0301");

             Combinations.copyEmissionsFromFelixInEra(robot, queueEmmissions, queue);
         }
     }






    public void runCorrect(int repeat, Robot robot, boolean ElectrExkav) {
        for (int i = 0; i < repeat; i++) {
            // go to Felix from Era
            Combinations.altTab(robot);

            // go to Мощность двигателя in Felix
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);

            if (ElectrExkav){
                robot.keyPress(KeyEvent.VK_ENTER);
                Combinations.ctrA(robot);
                Combinations.ctrC(robot);
                int b = Integer.parseInt(Combinations.getStringClipboard());

                // if Electric Excavator then fill only 2908 & 3749
                if (b == 0){
                    // fill emission for ДВС
                    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                    for (int j = 0; j < 3; j++) {
                        robot.keyPress(KeyEvent.VK_UP);
                    }
                    corectEmiss(2, robot);

                }else{ // if no Electric Excavator then fill all
                    robot.keyPress(KeyEvent.VK_DOWN);
                    corectEmiss(8, robot);
                }
            }else{
                robot.keyPress(KeyEvent.VK_DOWN);
                corectEmiss(8, robot);
            }

            Combinations.shiftTab2_Down(robot);
            Combinations.endEmission(robot);
        }
    }

//     correct emission and finished in Felix
//     repeat - how much emission need to correct

    void corectEmiss (int repeat, Robot robot){
        for (int j = 0; j < repeat; j++) {
            Combinations.correctEmiss(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_LEFT);
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
        }
    }

    public void ruCorrectWithQueue(int numberOfEquipments, Robot robot, boolean ElectrExkav){
        Queue queue = new LinkedList();

        for (int i = 0; i < numberOfEquipments; i++) {
            Combinations.tab2_Down2(robot);
            fillQueue(robot, queue, 16);
            Combinations.shiftTab2_Down(robot);

        }



    }

    public static void fillQueue (Robot robot, Queue queue, int repeat) {
        for (int i = 0; i < repeat; i++) {

            robot.keyPress(KeyEvent.VK_ENTER);
            Combinations.ctrA(robot);
            Combinations.ctrC(robot);
            // insert from clipboard
            queue.add((Combinations.getStringClipboard())) ;
            robot.keyPress(KeyEvent.VK_DOWN);
        }
    }
}

