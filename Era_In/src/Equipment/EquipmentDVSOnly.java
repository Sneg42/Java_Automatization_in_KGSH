package Equipment;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 13.07.2017.
 */
public class EquipmentDVSOnly {
    public static void main(String[] args) {
        int repeat = 1;
        Robot robot = Combinations.rob();

        for (int i = 0; i < repeat; i++) {

            //Fill emissioms staying in time fo one
            Combinations.ctrTab(robot);
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

            // end Auto and go to next auto
            Combinations.returnBeginingFelix(robot);

        }


    }
}
