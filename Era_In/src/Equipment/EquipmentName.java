package Equipment;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 12.07.2017.
 * Указать кол-во повторений
 * Вбить первый источник самому
 *
 * ЭРА:
 * Встать в название первого источника выбросов в Эре
 *
 * Феликс:
 * Встать в название первого источника выбросов
 *
 *
 */
public class EquipmentName {

    public  void runFill(int repeat, Robot robot, String delFirst, String copyNameSource) {

        for (int i = 0; i < repeat; i++) {

            // create and fill name Equipment (Экс, Бульд, Бур)
            Combinations.beginName(robot);
            Combinations.altTab(robot);
            if (i == 0 && copyNameSource.equals("y")){
                robot.keyPress(KeyEvent.VK_UP);
                Combinations.copyPast(robot);
                robot.keyPress(KeyEvent.VK_HOME);
                robot.setAutoDelay(25);
                for (int j = 0; j < 14; j++) {
                    robot.keyPress(KeyEvent.VK_DELETE);
                }
                robot.setAutoDelay(120);
                robot.keyPress(KeyEvent.VK_END);
                robot.keyPress(KeyEvent.VK_SPACE);
                Combinations.altTab(robot);
                robot.keyPress(KeyEvent.VK_DOWN);
            }
            Combinations.copyPast(robot);

            robot.keyPress(KeyEvent.VK_TAB);
            Combinations.altTab(robot);

            // fill amount of Equipment
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_RIGHT);
            Combinations.copyPast(robot);
            for (int j = 0; j < 3; j++) {
                robot.keyPress(KeyEvent.VK_TAB);
            }

            // fill time for 1 Equipment
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_TAB);
            Combinations.copyPast(robot);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            Combinations.returnBeginingFelix(robot);
            Combinations.altTab(robot);

            // Delete 1st source and change 2od to 1st
            if (i == 0 && delFirst.equals("y")) {
                Combinations.del1st(robot);
            }
        }

    }


}

