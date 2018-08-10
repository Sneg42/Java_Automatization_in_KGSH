package OFIEra.controller;

import OFIEra.controller.Era_In.DataRepeat;
import OFIEra.controller.Era_In.FillDataInEra;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public Button btnStart;
    public ChoiceBox unitProgramm;
    public TextField txtRepeatEquipments;
    public TextField txtRepeatBlowOut_Reload;
    public TextField txtRepeatAuto;
    public TextField txtRepeatExplosion;
    public CheckBox chBoxDelete1stSource;
    public CheckBox chBoxCopy1stName;
    public CheckBox chBoxRoad;
    public CheckBox chBoxElectricExcavator;

    public void startProgramm (ActionEvent actionEvent) {
        RunProgrammThread myThreadGo = new RunProgrammThread();

        //set value out GUI in class machining Data from OFIEra
        myThreadGo.repeatEquipments = Integer.parseInt(txtRepeatEquipments.getText());
        myThreadGo.repeatBlowOut_Unloading = Integer.parseInt(txtRepeatBlowOut_Reload.getText());
        myThreadGo.repeatAuto = Integer.parseInt(txtRepeatAuto.getText());
        myThreadGo.repeatExplosion = Integer.parseInt(txtRepeatExplosion.getText());
        myThreadGo.delete = chBoxDelete1stSource.isSelected();
        myThreadGo.copyName = chBoxCopy1stName.isSelected();
        myThreadGo.road = chBoxRoad.isSelected();
        myThreadGo.electricExc = chBoxElectricExcavator.isSelected();

        myThreadGo.start();
    }

    public void stopProgramm(ActionEvent actionEvent) {
        StopAllGUI myThread = new StopAllGUI();
        myThread.start();
    }
}

class StopAllGUI extends Thread{
    @Override
    public void run() {
        System.exit(0);
    }
}

class RunProgrammThread extends Thread{
    protected int repeatEquipments;
    protected int repeatBlowOut_Unloading;
    protected int repeatAuto;
    protected int repeatExplosion;
    protected boolean delete;
    protected boolean copyName;
    protected boolean road;
    protected boolean electricExc;


    @Override
    public void run() {
        // select program Fill or Corrext
        DataRepeat programm = new FillDataInEra();
//        DataRepeat programm = new CorrectDataInEra();

        programm.setRepeatEquipments(repeatEquipments); //repeat Экс БульдОтвла БульдУОГР БУр
        programm.setRepeatBlowOut_Unloading(repeatBlowOut_Unloading); // repeat Сдувание и рзгрузка
        programm.setRepeatAuto(repeatAuto); // repeat Авто
        programm.setRepeatExplosion(repeatExplosion);// repeat ВР
        programm.setDelete(delete); // delete 1st source in ERA
        programm.setCopyNameSource(copyName); // copy name Source from Felix witout Источник 6000
        programm.setRoad(road); // if road set "y"
        programm.setElectricExcavators(electricExc);

        programm.go();
    }
}

