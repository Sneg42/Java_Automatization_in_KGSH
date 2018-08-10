package Equipment;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class EquipmentEmissions {

    public  void runFillWithoutElectric(int repeat, Robot robot) {
        // fill emission for ДВС
        Combinations.beginEmission(robot, "0","3", "0", "1");
        robot.keyPress(KeyEvent.VK_DOWN);
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "0","3", "0", "4");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "0","3", "2", "8");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "0","3", "3", "0");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "0","3", "3", "7");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "2","7", "3", "2");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "2","9", "0", "8");
        Combinations.fillOneChemical(robot);

        Combinations.beginEmission(robot, "3","7", "4", "9");
        Combinations.fillOneChemical(robot);

        // end Auto and go to next auto
        Combinations.returnBeginingFelix(robot);
        Combinations.endEmission(robot);
    }

    public  void runFillWithElectric(int repeat, Robot robot, String ElectrExkav) {
        // go in need cell in Felix
        for (int i = 0; i < repeat; i++) {
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);

            if (ElectrExkav.equals("y")){
                robot.keyPress(KeyEvent.VK_ENTER);
                Combinations.ctrA(robot);
                Combinations.ctrC(robot);
                int b = Integer.parseInt(Combinations.getStringClipboard());

                Combinations.altTab(robot);
                // if Electric Excavator then fill only 2908 & 3749
                if (b == 0){
                    // fill emission for ДВС
                    Combinations.beginEmission(robot, "2","9", "0", "8");
                    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                    for (int j = 0; j < 3; j++) {
                        robot.keyPress(KeyEvent.VK_UP);
                    }
                    Combinations.fillOneChemical(robot);

                    Combinations.beginEmission(robot, "3","7", "4", "9");
                    Combinations.fillOneChemical(robot);

                    // end Auto and go to next auto
                    Combinations.returnBeginingFelix(robot);
                    Combinations.endEmission(robot);
                }else{
                    runFillWithoutElectric(repeat,robot);
                }
            }else{
                runFillWithoutElectric(repeat,robot);
            }
        }
    }

    public void runCorrect(Robot robot){
        Combinations.altTab(robot);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_DOWN);

        for (int i = 0; i < 8; i++) {
            Combinations.correctEmiss(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_LEFT);
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
        }


        Combinations.shiftTab2_Down(robot);
        Combinations.endEmission(robot);
    }
}
