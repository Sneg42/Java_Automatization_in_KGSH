package OFIEra.controller.Era_In.BlowOut_Unloading;

import OFIEra.controller.Era_In.Combination.Combinations;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class BlowOut_UnloadingEmissions {

    public  void runFillEmissions(int repeat, Robot robot) {
        // queue for copy data from Felix and past im Era
        Queue queue = new LinkedList();

        // queue for all emissions in Equipments
        Queue queueEmmissions = new LinkedList();
        for (int i = 0; i < repeat; i++) {

            queueEmmissions.add("2909");
            queueEmmissions.add("2908");

            Combinations.copyEmissionsFromFelixInEra(robot, queueEmmissions, queue);
        }
    }
}

