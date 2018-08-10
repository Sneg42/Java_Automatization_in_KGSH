import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Dvorovenko.DI on 25.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        DataRepeat programm = new FillDataInEra();
//        DataRepeat programm = new CorrectDataInEra();

        programm.setRepeatEquipments(2); //repeat Экс БульдОтвла БульдУОГР БУр
        programm.setRepeatBlowOut_Unloading(0); // repeat Сдувание и рзгрузка
        programm.setRepeatAuto(0); // repeat Авто
        programm.setRepeatExplosion(0);// repeat ВР
        programm.setDelete("n"); // delete 1st source in ERA
        programm.setCopyNameSource("n"); // copy name Source from Felix witout Источник 6000
        programm.setRoad("n"); // if road set "y"
        programm.setElectricExcavators("y");

        programm.go();

    }
}
