package sample.controller.main_programm;

import sample.controller.Combination.Combination;
import sun.plugin.com.event.COMEventHandler;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 30.10.2017.
 * Программа для вывода определенного кол-ва изолиний из графического блока.
 * Прежде необходимо проделать весь путь создания файла самостоятельно для первого вещества и сохранить файл
 * с именгем "1" в пустую папку, сделать нужный шаблон файла, определить масштаб
 * и потом посчитать сколько всего нужно файлов. Необходимо раскрыть все окна по максимум (нажать на прямоугольник
 * в правом верхнем углу каждого окна в ЭРЕ
 *
 * ВАЖНО!!! необходимо сохранять все файлы в пустую папку!!!!
 *
 * Указать масштаб и кол-во всего файлов с учетом 1-го созданного
 */
public class Isolinii_from_Era {
    public void run_create_all_file(int number_type_emission, String scale) {
        for (int i = 1; i < number_type_emission; i++) {
            create_file_pdf_isolini(i, scale);
        }
    }

    // Полностью создать файл пдф с изолинией из графического блока Эры и сохранить в папку
    private void create_file_pdf_isolini(int i, String scale) {
        Robot robot = Combination.rob();

        Combination.btn_menu_isolini(robot);

        robot.keyPress(KeyEvent.VK_DOWN);

        Combination.btn_create_isolini(robot);

        Combination.btn_print_isolini(robot);

        // Убрал выбор мастштаба так после обновления Эры он стал не изменным после 1-ой утсановки
//        Combination.btn_scale(robot);
//        Combination.txtField_number_scale(robot);
//
//        Combination.setStringClipboard(scale);
//        Combination.ctrV(robot);
//        robot.keyPress(KeyEvent.VK_ENTER);

        Combination.btn_print_pdf(robot);
        Combination.txtField_name_pdf(robot);
        Combination.insert_name_pdf_and_finish(robot, i);
    }
}

