package OFIEra.controller.Era_In.Explosion;

import OFIEra.controller.Era_In.Combination.Combinations;

import java.awt.*;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class ExplosionName {

    static int repeat = 1;
    static Robot robot = Combinations.rob();
    static String delete = "no";

    public static void main(String[] args) {
        ExplosionEmissions explosionEmissions = new ExplosionEmissions();
        explosionEmissions.fillExplosionEmissions(repeat, robot);
    }

}
