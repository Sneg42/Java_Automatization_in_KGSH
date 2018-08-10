package OFIEra.controller.Era_In;

import OFIEra.controller.Era_In.Auto.AutoEmissions;
import OFIEra.controller.Era_In.Equipment.EquipmentEmissions;

/**
 * Created by Dvorovenko.DI on 25.07.2017.
 * Для Авто нужно втстаь на название автосамосвала в Феликсе
 * в Эре встать в г/с на пылении
 */
public class CorrectDataInEra extends DataRepeat {

    public  void go() {

//        // Correct all Emissions im Equipments
//        EquipmentEmissions equipmentEmissions = new EquipmentEmissions();
//        equipmentEmissions.runCorrect(getRepeatEquipments(), robot, isElectricExcavators());



        // Correct all Auto (Пыление, Сдувание, ДВС)
        for (int i = 0; i < getRepeatAuto(); i++) {
            new AutoEmissions().runCorrectPilenie_Sduvani(robot);
            new AutoEmissions().runCorrectDVS(robot, isRoad());

        }

    }

}

