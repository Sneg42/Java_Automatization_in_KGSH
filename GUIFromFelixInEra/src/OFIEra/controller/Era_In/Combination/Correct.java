package OFIEra.controller.Era_In.Combination;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Dvorovenko.DI on 09.11.2017.
 */
public class Correct extends Combinations{


    // Copy emissions from Felix from queueEmissions. Begining in Felix in bot first emission
    // and finished ang go to next technic
    public static final void copyEmissionsFromFelixInEraForCorrect(Robot robot, Queue queueEmissions, Stack stack){

        //add all emissions in queue
        robot.setAutoDelay(30);
        while (!queueEmissions.isEmpty()){
            Correct.addEmissionInQueueForCorrect(robot, stack);

            // get one number emission from queueu
            queueEmissions.poll();
        }
        robot.setAutoDelay(120);

        // go to Era in window "Загрязняющие вещества по источнику"
        Combinations.altTab(robot);

        // Fill in Era from queue
        while (!stack.isEmpty()) {
            Correct.correctOneEmissionInEraFromStack(robot, stack);
        }

        // end technic and go to next
        Combinations.returnBeginingFelix(robot);
        Combinations.endEmission(robot);

    }

    // add One Emission from Felix in stack for correct data
    public static final void addEmissionInQueueForCorrect (Robot robot, Stack stack){
        // copy т/год for equals emission and set in Integer b
        Combinations.copy(robot);

        String b = (Combinations.getStringClipboard());
        // if т/год == 0 then pass this emission
        if (b.equals("0")){
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyPress(KeyEvent.VK_UP);
        }
        // else add this emission in stack
        else{
            //add т/год equals emission in stack
            stack.add(b);
            robot.keyPress(KeyEvent.VK_UP);

            //copy г/сек for equals emission and add in stack
            Combinations.copy(robot);
            stack.add(Combinations.getStringClipboard());
            robot.keyPress(KeyEvent.VK_UP);
        }
    }

    //correct one emissions in Era from stack
    public static final void correctOneEmissionInEraFromStack (Robot robot, Stack stack){

        //correct г/сек
        Combinations.setStringClipboard((String) stack.pop());
        Combinations.ctrV(robot);

        //correct т/год
        robot.keyPress(KeyEvent.VK_TAB);
        Combinations.setStringClipboard((String) stack.pop());
        Combinations.ctrV(robot);

        // go to next emission
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_LEFT);
    }
}
