package OFIEra.controller.Era_In.Combination;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.*;

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

    public static final void tab2_goBot (Robot robot){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        //just in case if pae_down can't help to go in bot
        for (int j = 0; j < 10; j++) {
            robot.keyPress(KeyEvent.VK_DOWN);
        }
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
            rob.setAutoDelay(150);
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
        Combinations.shiftTab(robot);
        Combinations.shiftTab(robot);
//        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.altTab(robot);

        // Запись кол-ва штук и часов
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);

        Combinations.copyPast(robot);

        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        Combinations.ctrA(robot);
        Combinations.altTab(robot);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrC(robot);
        Combinations.shiftTab(robot);
        Combinations.shiftTab(robot);
        Combinations.altTab(robot);
        Combinations.ctrV(robot);
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    //begin for emission with key number
    public static final void beginEmission (Robot robot, String a,String b, String c,String d){
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

    //end Emission in Era and go to next source, staying in Felix
    public static final void endEmission (Robot robot){
        Combinations.altTab(robot);
        Combinations.ctrTab(robot);
        for (int i = 0; i < 6; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_DOWN);
    }

    //end Emission in Era and go to next source, staying in Era
    public static final void goToNextEmission (Robot robot){
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
//        Combinations.ctrA(robot);
        Combinations.ctrV(robot);
    }

    //Copy and past from Felix in Era, staying in Felix ending in Era
    public static final void copy (Robot robot){
        robot.keyPress(KeyEvent.VK_ENTER);
        Combinations.ctrA(robot);
        Combinations.ctrC(robot);
    }

    // Delete 1st source in Era and change 2od to 1st
    public static final void del1st (Robot robot){
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_F8);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    //delete Источник 6000 in name from Felix
    public static void delSource6000(Robot robot){
        robot.keyPress(KeyEvent.VK_HOME);
        robot.setAutoDelay(25);
        for (int j = 0; j < 14; j++) {
            robot.keyPress(KeyEvent.VK_DELETE);
        }
        robot.setAutoDelay(120);
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

    // add One Emission from Felix in queue
    public static final void addEmissionInQueue (Robot robot, String emission, Queue queue){
        // copy т/год for equals emission and set in Integer b
        Combinations.copy(robot);

        String b = (Combinations.getStringClipboard());
        // if т/год == 0 then pass this emission
        if (b.equals("0")){
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyPress(KeyEvent.VK_UP);
        }
        // else add this emission in queue
        else{
            //add number of emissions in queue
            queue.add(emission);
            robot.keyPress(KeyEvent.VK_UP);

            //copy г/сек for equals emission and add in queue
            Combinations.copy(robot);
            queue.add(Combinations.getStringClipboard());

            //add т/год equals emission in queue
            queue.add(b);
            robot.keyPress(KeyEvent.VK_UP);
        }

    }

    public static final void fillOneEmissionInEraFromQueue (Robot robot, Queue queue){

        robot.keyPress(KeyEvent.VK_F7);
        robot.delay(100);
        //set number emission
        Combinations.setStringClipboard((String) queue.poll());
        Combinations.ctrV(robot);
        // go to г/сек & т/год and past it form queue
        for (int k = 0; k < 2; k++) {
            robot.keyPress(KeyEvent.VK_TAB);
            Combinations.setStringClipboard((String) queue.poll());
            Combinations.ctrV(robot);
        }
        robot.keyPress(KeyEvent.VK_TAB);
    }

    // Copy emissions from Felix from queueEmissions. Begining in Era
    public static final void copyEmissionsFromFelixInEra(Robot robot, Queue queueEmissions, Queue queue){
            //go to Felix
            Combinations.altTab(robot);
            Combinations.tab2_goBot(robot);

            //add all emissions in queue
            robot.setAutoDelay(30);
            while (!queueEmissions.isEmpty()){
                Combinations.addEmissionInQueue(robot, (String) queueEmissions.poll(), queue);
            }
            robot.setAutoDelay(120);

            // go to Era in window "Загрязняющие вещества по источнику"
            Combinations.altTab(robot);

            // Fill Выбросы ДВС in Era from queue
            while (!queue.isEmpty()) {
                Combinations.fillOneEmissionInEraFromQueue(robot, queue);
            }

            // end Auto and go to next Auto
            Combinations.returnBeginingFelix(robot);
            Combinations.endEmission(robot);

    }

    // МОЖЕТ НЕ НУЖНЫЕ ФУНКЦИИ, ЕСЛИ НЕ РАЗОБРАТЬСЯ С КОДИРОВКОЙ В ЭРЕ
//    //add one technique from Felix in queue with count & time
//    public static final void addOneNameTechniqInQueue (Robot robot, Queue queue){
//        // name auto add in queue
//        Combinations.copy(robot);
//        robot.keyPress(KeyEvent.VK_ESCAPE);
//        queue.add(Combinations.getStringClipboard());
//
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyPress(KeyEvent.VK_TAB);
//        // count techniq add in queue
//        Combinations.copy(robot);
//        queue.add(Combinations.getStringClipboard());
//        robot.keyPress(KeyEvent.VK_DOWN);
//        // time techniq add in queue
//        Combinations.copy(robot);
//        queue.add(Combinations.getStringClipboard());
//        Combinations.shiftTab2_Down(robot);
//    }
//
//    //Fill one name technique from queue in Era with count & time
//    public static final void fillOneNameTechniqFromQueue (Robot robot, Queue queue){
//        // create and fill name techniq
//        Combinations.beginName(robot);
//        //set name auto with name source
//        Combinations.setStringClipboard((String) queue.poll());
//        Combinations.ctrV(robot);
//        // go to Количество источников выделения & fill from queue
//        robot.keyPress(KeyEvent.VK_TAB);
//        Combinations.setStringClipboard((String) queue.poll());
//        Combinations.ctrV(robot);
//        // go to в год & and fill fom queue
//        for (int j = 0; j < 3; j++) {
//            robot.keyPress(KeyEvent.VK_TAB);
//        }
//        Combinations.setStringClipboard((String) queue.poll());
//        Combinations.ctrV(robot);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_ENTER);
//
//    }
}
