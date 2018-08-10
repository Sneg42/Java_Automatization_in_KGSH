package OFIEra.controller;

import OFIEra.controller.Era_In.Auto.AutoEmissions;
import OFIEra.controller.Era_In.Auto.AutoName;
import OFIEra.controller.Era_In.BlowOut_Unloading.BlowOut_UnloadingEmissions;
import OFIEra.controller.Era_In.Combination.Combinations;
import OFIEra.controller.Era_In.Equipment.EquipmentEmissions;
import OFIEra.controller.Era_In.Explosion.ExplosionEmissions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;

import static javafx.scene.input.KeyCode.L;
import static javafx.scene.input.KeyCode.Q;

/**
 * Created by Dvorovenko.DI on 30.08.2017.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        Robot robot = Combinations.rob();

        AutoEmissions au = new AutoEmissions();
        au.runCorrectAutoEmissions(robot, 4, false);

}

}




