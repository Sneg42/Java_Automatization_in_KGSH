package Auto;

import java.awt.*;
import java.awt.event.KeyEvent;

import Combination.Combinations;

/**
 * Created by Dvorovenko.DI on 12.07.2017.
 * Указать кол-во повторений
 * ЭРА:
 * Встать в номер источника выделений
 * При корректировки встать в кол-во штук
 *
 * Феликс:
 * Выбрать "Значение" в результатах расчета, чтобы ячейка подсвечивалась синим
 * Открыть все Авто, чтобы были видны подэлементы всех авто
 * Встать в название необходимого Авто
 * или в Пыление из-под колес в случае ТОЛЬКО заполнения выбросов или корректировки
 *
 * Оставить открытым окно Эры
 */
public class AutoName  {

    public void runFill(int repeat, Robot robot, String delFirst, String copyNameSource) {

        for (int i = 0; i < repeat ; i++) {

            // create and fill name Equipment (Авто)
            Combinations.beginName(robot);
            Combinations.altTab(robot);

            // name auto
            if (i == 0 && copyNameSource.equals("y")){
                robot.keyPress(KeyEvent.VK_UP);
                Combinations.copyPast(robot);
                robot.keyPress(KeyEvent.VK_SPACE);
                Combinations.altTab(robot);
                robot.keyPress(KeyEvent.VK_DOWN);
            }
            Combinations.copyPast(robot);
            robot.keyPress(KeyEvent.VK_SPACE);

            // fill name time and amount for Пыление
            Combinations.fillNamesAuto(robot);

            if (i == 0 && delFirst.equals("y")) {
                // Delete 1st source and cahnge 2od to 1st
                Combinations.del1st(robot);
            }

            // fill name time and amount for Сдувание
            Combinations.beginName(robot);
            Combinations.fillNamesAuto(robot);

            // fill name time and amount for ДВС
            Combinations.beginName(robot);
            Combinations.fillNamesAuto(robot);
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.altTab(robot);
        }
    }

    public void runCorrect(int repeat, Robot robot) {
        for (int i = 0; i < repeat; i++) {

            //Correct Пыление
            Combinations.altTab(robot);
            Combinations.correctName(robot);

            //Correct Сдуваниеи ДВС
            for (int j = 0; j < 2; j++) {
                Combinations.altTab(robot);
                Combinations.shiftTab2_Down(robot);
                Combinations.correctName(robot);
            }

            // go to the next auto (Ending in Era)
            Combinations.altTab(robot);
            Combinations.shiftTab2_Down(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.altTab(robot);
        }
    }
}
