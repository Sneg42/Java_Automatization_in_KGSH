package Auto;

import Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;

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
 * Встать в Пыление из-под колес
 *
 * Оставить открытым окно Эры
 */
public class AutoEmissions {

    public void runFill(int repeat, Robot robot, String road) {

        for (int i = 0; i < repeat; i++) {


            // fill source emission for Пыление и Сдувание
            Combinations.beginEmission(robot, "2","9", "0", "8");
            if (i == 0) robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.tab2_Down2(robot);
            Combinations.fillOneChemical(robot);
            Combinations.returnBeginingFelix(robot);
            Combinations.endEmission(robot);



            // fill source emission Сдувание
            Combinations.altTab(robot);
            // equipment Уголь в козове или нет
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyPress(KeyEvent.VK_ENTER);
            Combinations.ctrA(robot);
            Combinations.ctrC(robot);
            int b = Integer.parseInt(Combinations.getStringClipboard());
            Combinations.altTab(robot);
            if (b == 1){
                Combinations.beginEmission(robot, "3","7", "4", "9");
            }else{
                Combinations.beginEmission(robot, "2","9", "0", "8");
            }
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            Combinations.fillOneChemical(robot);
            Combinations.returnBeginingFelix(robot);
            Combinations.endEmission(robot);



            // fill emission for ДВС
            Combinations.beginEmission(robot, "0","3", "0", "1");

            if (road.equals("n")){
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

    public void runCorrectDVS(Robot robot, String road){
        Combinations.altTab(robot);

        //Source Road or not
        if (road.equals("n")){
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
