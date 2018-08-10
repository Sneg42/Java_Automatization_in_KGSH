package BlowOut_Unloading;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class BlowOut_UnloadingEmissions {

    public  void runFill(int repeat, Robot robot) {
        for (int i = 0; i < repeat; i++) {

            Combinations.beginEmission(robot, "2", "9", "0", "8");
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.fillOneChemical(robot);

            Combinations.returnBeginingFelix(robot);
            Combinations.endEmission(robot);
        }
    }
}
