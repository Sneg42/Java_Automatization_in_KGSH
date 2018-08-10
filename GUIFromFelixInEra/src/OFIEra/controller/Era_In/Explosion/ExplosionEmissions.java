package OFIEra.controller.Era_In.Explosion;

import OFIEra.controller.Era_In.Combination.Combinations;
import OFIEra.controller.Era_In.Combination.Correct;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 13.07.2017.
 */
public class ExplosionEmissions {

    public  void fillExplosionEmissions(int repeat, Robot robot) {
        // queue for copy data from Felix and past im Era
        Queue queue = new LinkedList();

        // queue for all emissions in Explosion
        Queue queueEmmissions = new LinkedList();
        for (int i = 0; i < repeat; i++) {


            queueEmmissions.add("3749");
            queueEmmissions.add("2908");
            queueEmmissions.add("0337");
            queueEmmissions.add("0304");
            queueEmmissions.add("0301");

            Combinations.copyEmissionsFromFelixInEra(robot, queueEmmissions, queue);
        }
    }


    public  void correctExplosionEmissions(int repeat, Robot robot) {
        // queue for copy data from Felix and past im Era
        Stack stack = new Stack();

        // queue for all emissions in Explosion
        Queue queueEmissions = new LinkedList();
        for (int i = 0; i < repeat; i++) {


            queueEmissions.add("3749");
            queueEmissions.add("2908");
            queueEmissions.add("0337");
            queueEmissions.add("0304");
            queueEmissions.add("0301");

            Correct.copyEmissionsFromFelixInEraForCorrect(robot, queueEmissions, stack);

        }
    }
}

