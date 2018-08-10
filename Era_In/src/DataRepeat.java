import Combination.Combinations;

import java.awt.*;

/**
 * Created by Dvorovenko.DI on 21.08.2017.
 */
public class DataRepeat {
    public  String getDelete() {
        return delete;
    }

    public  void setDelete(String delete) {
        this.delete = delete;
    }

    public  String getRoad() {
        return road;
    }

    public  void setRoad(String road) {
        this.road = road;
    }

    public  int getRepeatEquipments() {
        return repeatEquipments;
    }

    public  void setRepeatEquipments(int repeatEquipments) {
        this.repeatEquipments = repeatEquipments;
    }

    public  int getRepeatBlowOut_Unloading() {
        return repeatBlowOut_Unloading;
    }

    public  void setRepeatBlowOut_Unloading(int repeatBlowOut_Unloading) {
        this.repeatBlowOut_Unloading = repeatBlowOut_Unloading;
    }

    public  int getRepeatAuto() {
        return repeatAuto;
    }

    public  void setRepeatAuto(int repeatAuto) {
        this.repeatAuto = repeatAuto;
    }

    public  int getRepeatExplosion() {
        return repeatExplosion;
    }

    public  void setRepeatExplosion(int repeatExplosion) {
        this.repeatExplosion = repeatExplosion;
    }

    public  void setCopyNameSource(String copyNameSource) {
        this.copyNameSource = copyNameSource;
    }

    public  String getCopyNameSource() {

        return copyNameSource;
    }

    public void setElectricExcavators(String electricExcavators) {
        this.electricExcavators = electricExcavators;
    }

    public String getElectricExcavators() {
        return electricExcavators;

    }


    private int repeatEquipments ;
    private int repeatBlowOut_Unloading ;
    private int repeatAuto ;
    private int repeatExplosion ;
    private String delete = "n";
    private String copyNameSource = "n";
    private String road = "n";
    private String electricExcavators = "n";

    Robot robot = Combinations.rob();

    public void go(){};

}
