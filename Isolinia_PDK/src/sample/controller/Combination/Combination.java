package sample.controller.Combination;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 30.10.2017.
 */
public class Combination {
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

    public static final void clickMouse(Robot robot){
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(500);
    }

    public static final void altF4(Robot robot) {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }


    // Переместить мышку на кнопку изолини в графическом блоке Эры и нажать эту кнопку
    public static final void btn_menu_isolini(Robot robot) {
        robot.mouseMove(500, 65 );
        clickMouse(robot);

    }

    // Переместить мышку на кнопку построения изолини и нажать эту кнопку
    public static final void btn_create_isolini(Robot robot) {
        robot.mouseMove(25, 50 );
        clickMouse(robot);
        robot.delay(500);
    }

    // Переместить мышку на кнопку печати изолини и нажать эту кнопку
    public static final void btn_print_isolini(Robot robot) {
        robot.mouseMove(650, 50 );
        clickMouse(robot);
        robot.delay(500);
    }

    // Переместить мышку на кнопку масштаба карты и нажать эту кнопку
    public static final void btn_scale(Robot robot) {
        robot.mouseMove(250, 50 );
        clickMouse(robot);
    }

    // Переместить мышку на цифру масштаба карты и нажать эту кнопку
    public static final void txtField_number_scale(Robot robot) {
        robot.mouseMove(1050, 570 );
        clickMouse(robot);
    }

    // Переместить мышку на нопку вывода пдф и нажать эту кнопку
    public static final void btn_print_pdf(Robot robot) {
        robot.mouseMove(25, 50 );
        clickMouse(robot);
//        Старая задержка на моем компе
//        robot.delay(6500);
        robot.delay(3500);
    }

    // Переместить мышку на поле имени фалй пдф и нажать эту кнопку
    public static final void txtField_name_pdf(Robot robot) {
        robot.mouseMove(1000, 405 ); // Для моего монитора
//        robot.mouseMove(1000, 365 ); // Для Ваниного монитора
        clickMouse(robot);

    }

    // Ввести имя файла пдф из очереди и выйти в основное окно графическом блоке Эры
    public static final void insert_name_pdf_and_finish(Robot robot, Integer number_emission) {
        Combination.ctrA(robot);
        Combination.setStringClipboard(Integer.toString(number_emission + 1) );
        Combination.ctrV(robot);

//        // Для Ваниного монитора и программ установленных нра его кломпе
//        robot.mouseMove(1100, 790 );
//        clickMouse(robot);
//        robot.delay(1500);
//        Combination.altF4(robot);
        // Для моего компа
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(50);
        clickMouse(robot);
        robot.delay(50);
        robot.keyPress(KeyEvent.VK_ESCAPE);

    }

// Для дургих компов так как меньше производительсность изменить время задержек

    //Создание объекта робота и Задание первой задержки и автоЗадержки
    public static final Robot rob (){
        Robot rob = null;
        try {
            rob = new Robot();
            rob.delay(1000);
            rob.setAutoDelay(200);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return rob;
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
