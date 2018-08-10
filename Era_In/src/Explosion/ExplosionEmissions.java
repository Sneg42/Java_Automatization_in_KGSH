package Explosion;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 13.07.2017.
 */
public class ExplosionEmissions {

    public  void runFill(int repeat, Robot robot) {
        for (int i = 0; i < repeat; i++) {

            Combinations.beginEmission(robot, "0","3", "0", "1");
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            Combinations.fillOneChemical(robot);

            Combinations.beginEmission(robot, "0","3", "0", "4");
            Combinations.fillOneChemical(robot);

            Combinations.beginEmission(robot, "0","3", "3", "7");
            Combinations.fillOneChemical(robot);

            Combinations.beginEmission(robot, "2","9", "0", "8");
            Combinations.fillOneChemical(robot);

            Combinations.returnBeginingFelix(robot);
            Combinations.endEmission(robot);
        }
    }
}

