package OFIEra.controller.Era_In.Auto;

import OFIEra.controller.Era_In.Combination.Combinations;
import OFIEra.controller.Era_In.Combination.Correct;
import com.sun.org.apache.xerces.internal.impl.dtd.models.CMBinOp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 12.07.2017.
 * Указать кол-во повторений
 *
 * ЭРА:
 * Встать в пустое поле Загрязняющих веществ в нужном Пыление из-под колес Автосамосвала.
 * При корректировки встать в г/с Пыления
 *
 * Феликс:
 * Выбрать "Значение" в результатах расчета, чтобы ячейка подсвечивалась синим
 * Открыть все Авто, чтобы были видны подэлементы всех авто
 * Встать на название Авто
 *
 * Оставить открытым окно Эры
 *
 * Не такой как другие источники выбросов и поэтому нельзя применть функцию из Combinations
 *
 * При корректировки начинать в Эра в г/с для Пыления из-под колес, в Феликсе стоять на марки Авто
 */
public class AutoEmissions {

    public void runFillEmissions(int repeat, Robot robot, boolean road) {

        for (int i = 0; i < repeat; i++) {
            Queue queue = new LinkedList();

//          go to Felix
            Combinations.altTab(robot);

            //go to Пыдение с кузова & add to queue
            if (i == 0) robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.tab2_goBot(robot);
            Combinations.addEmissionInQueue(robot, "2908", queue);

            // go to Сдувание с кузова in Felix & add to queue
            Combinations.shiftTab2_Down(robot);
            Combinations.tab2_goBot(robot);
            robot.setAutoDelay(30);
            Combinations.addEmissionInQueue(robot, "3749", queue);
            Combinations.addEmissionInQueue(robot, "2909", queue);
            Combinations.addEmissionInQueue(robot, "2908", queue);
            Combinations.addEmissionInQueue(robot, "2902", queue);
            robot.setAutoDelay(120);

            // go to Выбросы от ДВС in Felix & add to queue
            Combinations.shiftTab2_Down(robot);
            Combinations.tab2_goBot(robot);
            // if Auto on road
            if (!road) {
                for (int j = 0; j < 12; j++) {
                    robot.keyPress(KeyEvent.VK_UP);
                }
            }
            robot.setAutoDelay(30);
            Combinations.addEmissionInQueue(robot, "2732", queue);
            Combinations.addEmissionInQueue(robot, "0337", queue);
            Combinations.addEmissionInQueue(robot, "0330", queue);
            Combinations.addEmissionInQueue(robot, "0328", queue);
            Combinations.addEmissionInQueue(robot, "0304", queue);
            Combinations.addEmissionInQueue(robot, "0301", queue);
            robot.setAutoDelay(120);
            // go to Era in window "Загрязняющие вещества по источнику"
            Combinations.altTab(robot);

            // Fill Пыление из-под колем и Сдувание in Era
            for (int j = 0; j < 2; j++) {
                Combinations.fillOneEmissionInEraFromQueue(robot, queue);
                Combinations.goToNextEmission(robot);
            }

            // Fill Выбросы ДВС in Era from queue
            while (!queue.isEmpty()) {
                Combinations.fillOneEmissionInEraFromQueue(robot, queue);
            }
//            Combinations.goToNextEmission(robot);

            // end Auto and go to next Auto
            Combinations.returnBeginingFelix(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.endEmission(robot);

        }
    }


    public void runCorrectAutoEmissions(Robot robot, int repeat, boolean road){
        // queue for copy data from Felix and past im Era
        Stack stack = new Stack();

        // queue for all emissions in Explosion
        Queue queueEmissions = new LinkedList();
        for (int i = 0; i < repeat; i++) {

            // go to Felix and go to "Пыление из-под колес" and go to bot "Результаты расчета"
            Combinations.altTab(robot);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.tab2_goBot(robot);

            //correct emission "Пыление из-под колес"
            queueEmissions.add("2908");
            Correct.copyEmissionsFromFelixInEraForCorrect(robot, queueEmissions, stack);

            // go to Felix
            Combinations.altTab(robot);
            Combinations.tab2_goBot(robot);
            //correct emission "Сдувание с кузова"
            queueEmissions.add("3749");
            queueEmissions.add("2909");
            queueEmissions.add("2908");
            queueEmissions.add("2902");
            Correct.copyEmissionsFromFelixInEraForCorrect(robot, queueEmissions, stack);

            // if no road go to up at 12 units and return in Era? fo correct work function
            Combinations.altTab(robot);
            Combinations.tab2_goBot(robot);
            if (!road) {
                for (int j = 0; j < 12; j++) {
                    robot.keyPress(KeyEvent.VK_UP);
                }
            }
            //correct emission "Выбросы от ДВС"
            queueEmissions.add("2732");
            queueEmissions.add("0337");
            queueEmissions.add("0330");
            queueEmissions.add("0328");
            queueEmissions.add("0304");
            queueEmissions.add("0301");
            Correct.copyEmissionsFromFelixInEraForCorrect(robot, queueEmissions, stack);

        }
    }

    public void runCorrectPilenie_Sduvani(Robot robot){

        for (int j =0; j < 2; j++) {
            Combinations.altTab(robot);
            if (j == 0) {robot.keyPress(KeyEvent.VK_DOWN);}
            Combinations.tab2_Down2(robot);
            Combinations.correctEmiss(robot);
            robot.keyPress(KeyEvent.VK_LEFT);
            Combinations.altTab(robot);
            Combinations.shiftTab2_Down(robot);
            Combinations.endEmission(robot);
}
    }

    public void runCorrectDVS(Robot robot, boolean road){
        Combinations.altTab(robot);

        //Source Road or not
        if (road){
            Combinations.tab2_Down2(robot);
        }
        else{
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            for (int j = 0; j < 11; j++) {
                robot.keyPress(KeyEvent.VK_UP);
            }
        }

        for (int i = 0; i < 6; i++) {
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
