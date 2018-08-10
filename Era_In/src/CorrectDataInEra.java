import Auto.AutoEmissions;
import Equipment.EquipmentEmissions;

/**
 * Created by Dvorovenko.DI on 25.07.2017.
 * Для Авто нужно втстаь на название автосамосвала в Феликсе
 * в Эре встать в г/с на пылении
 */
public class CorrectDataInEra extends DataRepeat {

    public  void go() {

        // Correct all Emissions im Equipments
        for (int i = 0; i < getRepeatEquipments(); i++) {
            EquipmentEmissions equipmentEmissions = new EquipmentEmissions();
            equipmentEmissions.runCorrect(robot);

        }

        // Correct all Auto (Пыление, Сдувание, ДВС)
        for (int i = 0; i < getRepeatAuto(); i++) {
            new AutoEmissions().runCorrectPilenie_Sduvani(robot);
            new  AutoEmissions().runCorrectDVS(robot, getRoad());

        }

    }

}

