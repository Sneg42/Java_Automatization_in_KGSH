package BlowOut_Unloading;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class BlowOut_UnloadingName {

    public void runFill(int repeat, Robot robot, String delFirst, String copyNameSource) {
        for (int i = 0; i < repeat; i++) {
            //begin in Era and fill name
            Combinations.beginName(robot);
            Combinations.altTab(robot);
            if (i == 0 && copyNameSource.equals("y")){
                robot.keyPress(KeyEvent.VK_UP);
                Combinations.copyPast(robot);
                robot.keyPress(KeyEvent.VK_SPACE);
                Combinations.altTab(robot);
                robot.keyPress(KeyEvent.VK_DOWN);
            }
            Combinations.copyPast(robot);

            //fill time
            for (int j = 0; j < 4; j++) {
                robot.keyPress(KeyEvent.VK_TAB);
            }
            Combinations.altTab(robot);
            for (int j = 0; j < 2; j++) {
                robot.keyPress(KeyEvent.VK_TAB);
            }
            Combinations.copyPast(robot);
            for (int j = 0; j < 2; j++) {
                robot.keyPress(KeyEvent.VK_ENTER);
            }

            //return in begin in Felix and finishing in Era
            Combinations.returnBeginingFelix(robot);
            Combinations.altTab(robot);

            // Delete 1st source and change 2od to 1st
            if (i == 0 && delFirst.equals("y")) {
                Combinations.del1st(robot);
            }
        }
    }
}
