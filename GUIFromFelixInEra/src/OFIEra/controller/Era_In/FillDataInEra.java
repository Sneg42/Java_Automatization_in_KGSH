package OFIEra.controller.Era_In;

import OFIEra.controller.Era_In.Auto.AutoEmissions;
import OFIEra.controller.Era_In.Auto.AutoName;
import OFIEra.controller.Era_In.BlowOut_Unloading.BlowOut_UnloadingEmissions;
import OFIEra.controller.Era_In.BlowOut_Unloading.BlowOut_UnloadingName;
import OFIEra.controller.Era_In.Combination.Combinations;
import OFIEra.controller.Era_In.Equipment.EquipmentEmissions;
import OFIEra.controller.Era_In.Equipment.EquipmentName;

import java.awt.event.KeyEvent;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 * Указать кол-во повторений
 * ЭРА:
 * Проверить Вставляет ли в г/с и поставить галочку в признак неооганизованго в окне добавления источника
 * Встать в номер источника выделений
 *
 * Феликс:
 * Выбрать "Значение" в результатах расчета, чтобы ячейка подсвечивалась синим
 * Открыть все Авто, чтобы были видны подэлементы всех авто
 * Встать в название необходимого Авто
 * или в Пыление из-под колес в случае ТОЛЬКО заполнения выбросов или корректировки
 *
 * Оставить открытым окно Эры
 */
public class FillDataInEra extends DataRepeat {

    public  void go() {

        // Fill name for Equipment
        EquipmentName equipName = new EquipmentName();
        equipName.runFill(getRepeatEquipments(), robot, isDelete(), isCopyNameSource());

        // Fill all name BlowOut & UnloadingName
        BlowOut_UnloadingName blowName = new BlowOut_UnloadingName();
        blowName.runFill(getRepeatBlowOut_Unloading(), robot,
                isDelete()  && getRepeatEquipments() == 0 ? true : false,
                isCopyNameSource()  && getRepeatEquipments() == 0 ? true : false);

        // Fill all name Auto
        AutoName autoName = new AutoName();
        autoName.runFill(getRepeatAuto(), robot,
                isDelete()  && getRepeatEquipments() == 0 && getRepeatBlowOut_Unloading() == 0 ? true : false,
                isCopyNameSource()  && getRepeatEquipments() == 0 && getRepeatBlowOut_Unloading() == 0 ? true : false );

        //Fill ExplosionName name
        // returning in begin in Felix and Era
        for (int i = 0; i < (3 * getRepeatAuto() - 1 +  getRepeatBlowOut_Unloading() + getRepeatEquipments()); i++) {
            robot.keyPress(KeyEvent.VK_UP);
        }
        // return in the begin if Source
        Combinations.ctrTab(robot);
        Combinations.altTab(robot);
        for (int i = 0; i < (4 * getRepeatAuto() +  getRepeatBlowOut_Unloading() + getRepeatEquipments()); i++) {
            robot.keyPress(KeyEvent.VK_UP);
        }
        Combinations.altTab(robot);

        // Fill Emission for equipment

        // For Excavator & other
        EquipmentEmissions equipEmiss = new EquipmentEmissions();
        equipEmiss.fillEquipmentEmissions(getRepeatEquipments(), robot);

        // Fill Emission for BlowOut & Unloading
        BlowOut_UnloadingEmissions blowEmiss = new BlowOut_UnloadingEmissions();
        blowEmiss.runFillEmissions(getRepeatBlowOut_Unloading(), robot);

        // Fill Emission for Auto
        AutoEmissions autoEmiss = new AutoEmissions();
        autoEmiss.runFillEmissions(getRepeatAuto(), robot, isRoad());

        // Fill explosion Emission

    }

}
