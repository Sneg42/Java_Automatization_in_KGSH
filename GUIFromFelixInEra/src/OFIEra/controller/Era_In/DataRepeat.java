package OFIEra.controller.Era_In;

import OFIEra.controller.Era_In.Combination.Combinations;

import java.awt.*;

/**
 * Created by Dvorovenko.DI on 21.08.2017.
 * Super Class for numbers of repeated all equipments
 */
public class DataRepeat {

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

    public boolean isDelete() {
        return delete;
    }

    public boolean isCopyNameSource() {
        return copyNameSource;
    }

    public boolean isRoad() {
        return road;
    }

    public boolean isElectricExcavators() {
        return electricExcavators;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setCopyNameSource(boolean copyNameSource) {
        this.copyNameSource = copyNameSource;
    }

    public void setRoad(boolean road) {
        this.road = road;
    }

    public void setElectricExcavators(boolean electricExcavators) {
        this.electricExcavators = electricExcavators;
    }


    private int repeatEquipments ;
    private int repeatBlowOut_Unloading ;
    private int repeatAuto ;
    private int repeatExplosion ;

    private boolean delete = false;
    private boolean copyNameSource = false;
    private boolean road = false;
    private boolean electricExcavators = false;

    Robot robot = Combinations.rob();

    public void go(){};

}
