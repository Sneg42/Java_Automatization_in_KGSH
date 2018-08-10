package Combination;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 12.07.2017.
 */
public class Combinations {
    public static final void altTab(Robot robot) {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public static final void ctrA(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static final void ctrC(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static final void ctrV(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static final void shiftTab(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public static final void ctrTab (Robot robot){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static final void tab2_Down2 (Robot robot){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
    }

    public static final void shiftTab2_Down (Robot robot){
        Combinations.shiftTab(robot);
        Combinations.shiftTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);

    }


    // Begin for Name
    public static  void beginName(Robot robot) {
        robot.keyPress(KeyEvent.VK_F7);
        robot.delay(100);
        for (int j = 0; j < 4; j++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
    }

    //Создание объекта робота и Задание первой задержки и автоЗадержки
    public static final Robot rob (){
        Robot rob = null;
        try {
            rob = new Robot();
            // waiting 6.5 sec for open app
            rob.delay(6500);
            rob.setAutoDelay(120);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return rob;
    }

    // Fill all  Name for Auto (Пыление, Сдувание, ДВС)
    public static final void fillNamesAuto(Robot robot){
        Combinations.altTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);

        Combinations.copyPast(robot);

        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.altTab(robot);

        // Запись кол-ва штук и часов
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);

        Combinations.copyPast(robot);

        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        Combinations.altTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrC(robot);
        Combinations.shiftTab(robot);
        Combinations.shiftTab(robot);
        Combinations.altTab(robot);
        Combinations.ctrV(robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    //begin fo emission with key number
    public static final void   beginEmission (Robot robot, String a,String b, String c,String d){
        robot.keyPress(KeyEvent.VK_F7);
        robot.delay(100);
        robot.keyPress(KeyStroke.getKeyStroke(a).getKeyCode());
        robot.keyPress(KeyStroke.getKeyStroke(b).getKeyCode());
        robot.keyPress(KeyStroke.getKeyStroke(c).getKeyCode());
        robot.keyPress(KeyStroke.getKeyStroke(d).getKeyCode());
        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.altTab(robot);
    }

    //fill Emission г/с и т/год for 1 chemical , need be in Феликс and ended in Era
    public static final void fillOneChemical (Robot robot) {
        // г/сек
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrC(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        Combinations.altTab(robot);
        Combinations.ctrV(robot);
        robot.keyPress(KeyEvent.VK_TAB);

        Combinations.altTab(robot);

        // т/год
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrC(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        Combinations.altTab(robot);
        Combinations.ctrV(robot);
        robot.keyPress(KeyEvent.VK_TAB);
    }

    // return in begin in Felix from Era and stop in Felix
    public static final void returnBeginingFelix(Robot robot){
        Combinations.altTab(robot);
        Combinations.shiftTab(robot);
        Combinations.shiftTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);

    }

    //end Emisiion in Era and go to next source, staying in Felix
    public static final void endEmission (Robot robot){
        Combinations.altTab(robot);
        Combinations.ctrTab(robot);
        for (int i = 0; i < 6; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_DOWN);
    }

    //Copy and past from Felix in Era, staying in Felix ending in Era
    public static final void copyPast (Robot robot){
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrA(robot);
        Combinations.ctrC(robot);
        Combinations.altTab(robot);
        Combinations.ctrV(robot);
    }

    // Delete 1st source and cahnge 2od to 1st
    public static final void del1st (Robot robot){
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_F8);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    // Correct name (Begin in Felix and Ending in Era)
    public static final void correctName (Robot robot){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.copyPast(robot);
        for (int j = 0; j < 5; j++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        Combinations.altTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        Combinations.copyPast(robot);

        robot.keyPress(KeyEvent.VK_DOWN);
        for (int j = 0; j < 5; j++) {
            robot.keyPress(KeyEvent.VK_LEFT);
        }
    }

    // Correct 2 Emissions г/сек & т/год(Begin in Felix (Результаты расчета с переменной изменения) and Ending in Era)
    public static final void correctEmiss (Robot robot){
        Combinations.copyPast(robot);
        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.altTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        Combinations.copyPast(robot);
    }

    // return String from Clipboard
    public static final String getStringClipboard (){
        String b = "";
        try{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor flavor = DataFlavor.stringFlavor;
            b = clipboard.getData(flavor).toString();

        }catch (Exception e ){

        }
        return b;
    }

    // set in Clipboard String
    public static final void setStringClipboard (String s){

        try{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(s);
            clipboard.setContents(stringSelection, null);


        }catch (Exception e ){

        }

    }
}
