package OFIEra.controller.Era_In.Auto;

import OFIEra.controller.Era_In.Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

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

    public void runFill(int repeat, Robot robot, boolean delFirst, boolean copyNameSource) {

        for (int i = 0; i < repeat ; i++) {
            // НУЖНА ПРАВКА С ОЧЕРЕДЬЮ!!!! ТАК КАК ВСТАВЛЯЕТСЯ АБРАКАТАБРА ИЗ ОЧЕРЕЖИ В  ЭРУ, ПОКА ИСПОЛЬЗОВАТЬ СТАРЫЙ СПОСОБ
//            Queue queue = new LinkedList();
//            // Name techniq & if need with name source
//            String nameTechnique = "";
//
//            // go to Felix
//            Combinations.altTab(robot);
//
//            // name source if need
//            if (i == 0 && copyNameSource){
//                robot.keyPress(KeyEvent.VK_UP);
//                Combinations.copy(robot);
//                robot.keyPress(KeyEvent.VK_ESCAPE);
//                nameTechnique += Combinations.getStringClipboard() + " ";
//
//                robot.keyPress(KeyEvent.VK_DOWN);
//            }
//            // add name auto
//            Combinations.copy(robot);
//            robot.keyPress(KeyEvent.VK_ESCAPE);
//            nameTechnique += Combinations.getStringClipboard();
//            queue.add(nameTechnique);
//            robot.keyPress(KeyEvent.VK_DOWN);
//
//            // Пыление из-под колес
//            Combinations.addOneNameTechniqInQueue(robot, i, queue);
//            // Сдувание
//            Combinations.addOneNameTechniqInQueue(robot, i, queue);
//            // Двс
//            Combinations.addOneNameTechniqInQueue(robot, i, queue);
//
//            // go to Era
//            Combinations.altTab(robot);
//
//            // create and fill name Equipment Пыление из-под колес
//            Combinations.beginName(robot);
//            //set name auto with name source
//            Combinations.setStringClipboard((String) queue.poll());
//            Combinations.ctrV(robot);
//
//            // delete Источник 6000
//            if (i == 0 && copyNameSource){
//                Combinations.delSource6000(robot);
//            }
//
//            //set Пыление из-под колес
//            Combinations.setStringClipboard((String) queue.poll());
//            Combinations.ctrV(robot);
//            //set count Пыление из-под колес
//            robot.keyPress(KeyEvent.VK_TAB);
//            Combinations.setStringClipboard((String) queue.poll());
//            Combinations.ctrV(robot);
//            //set time Пыление из-под колес
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyPress(KeyEvent.VK_TAB);
//            Combinations.setStringClipboard((String) queue.poll());
//            Combinations.ctrV(robot);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyPress(KeyEvent.VK_ENTER);
//
//            // Delete 1st source and cahnge 2nd to 1st
//            if (i == 0 && delFirst) {
//                Combinations.del1st(robot);
//            }
//
//            //fill all data for Сдувание с кузова
//            Combinations.fillOneNameTechniqFromQueue(robot, queue);
//
//            //fill all data for Выбросы ДВС
//            Combinations.fillOneNameTechniqFromQueue(robot, queue);




            // create and fill name Equipment (Авто)
            Combinations.beginName(robot);
            Combinations.altTab(robot);

            // name auto
            if (i == 0 && copyNameSource){
                robot.keyPress(KeyEvent.VK_UP);
                Combinations.copyPast(robot);

                // delete Источник 6000
                Combinations.delSource6000(robot);

                robot.keyPress(KeyEvent.VK_END);
                robot.keyPress(KeyEvent.VK_SPACE);

                Combinations.altTab(robot);
                robot.keyPress(KeyEvent.VK_DOWN);
            }
            Combinations.copyPast(robot);
            robot.keyPress(KeyEvent.VK_SPACE);

            // fill name time and amount for Пыление
            Combinations.fillNamesAuto(robot);

            if (i == 0 && delFirst) {
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
