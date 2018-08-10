package OFIEra.controller.Era_In.Equipment;

import OFIEra.controller.Era_In.Combination.Combinations;

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
 * Один раз выбрать "Значение" в "Исходные даннеы", чтобы потом оно автоматически выбиралось
 * Встать в название первого источника выбросов
 *
 *
 */
public class EquipmentName {

    public  void runFill(int repeat, Robot robot, boolean delFirst, boolean copyNameSource) {

        for (int i = 0; i < repeat; i++) {

            // create and fill name Equipment (Экс, Бульд, Бур)
            Combinations.beginName(robot);
            Combinations.altTab(robot);

            // copy name source
            if (i == 0 && copyNameSource){
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
            // copy name equipments
            Combinations.copyPast(robot);
            Combinations.shiftTab(robot);
            Combinations.shiftTab(robot);
            Combinations.altTab(robot);

            // fill amount of Equipment
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            Combinations.ctrA(robot);
            Combinations.ctrC(robot);
            Combinations.altTab(robot);

            // if count equipment equals zero
            int b = Integer.parseInt(Combinations.getStringClipboard());
            if (b == 0) Combinations.setStringClipboard("1");

            Combinations.ctrV(robot);

            for (int j = 0; j < 4; j++) {
                robot.keyPress(KeyEvent.VK_TAB);
            }
            Combinations.ctrA(robot); // Чтобы выделить все часы работ в Эре
            // fill time for 1 Equipment
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_TAB);
            Combinations.copyPast(robot);
            for (int j = 0; j < 3; j++) {
                robot.keyPress(KeyEvent.VK_TAB);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            Combinations.returnBeginingFelix(robot);
            Combinations.altTab(robot);

            // Delete 1st source and change 2od to 1st
            if (i == 0 && delFirst) {
                Combinations.del1st(robot);
            }
        }

    }


}

