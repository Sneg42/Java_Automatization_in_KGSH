package Auto;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Мжно удалить класс
 */
public class AutoEmissionsRoad {

    public  void runFill(int repeat, Robot robot, String road) {

        for (int i = 0; i < repeat; i++) {

            // fill source emission for Пыление и Сдувание
            for (int j = 0; j < 2; j++) {
                Combinations.beginEmission(robot, "2","9", "0", "8");

                Combinations.tab2_Down2(robot);

                Combinations.fillOneChemical(robot);
                Combinations.returnBeginingFelix(robot);
                Combinations.endEmission(robot);
            }

            // fill emission for ДВС
            Combinations.beginEmission(robot, "0","3", "0", "1");

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            for (int j = 0; j < 11; j++) {
                robot.keyPress(KeyEvent.VK_UP);
            }

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
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.endEmission(robot);

        }
    }
}
