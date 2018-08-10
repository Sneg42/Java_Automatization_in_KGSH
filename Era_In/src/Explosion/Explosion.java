package Explosion;

import Combination.Combinations;

import java.awt.*;

/**
 * Created by Dvorovenko.DI on 14.07.2017.
 */
public class Explosion {

    static int repeat = 2;
    static Robot robot = Combinations.rob();
    static String delete = "no";

    public static void main(String[] args) {

        ExplosionEmissions explosEmiss = new ExplosionEmissions();
        explosEmiss.runFill(repeat, robot);
    }
}
