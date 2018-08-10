/**
 * Created by Dvorovenko.DI on 29.08.2017.
 */
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.awt.Robot;
import java.awt.event.InputEvent;
public class TestScene extends Application {

        Stage window;
        Robot robot;
        Scene scene;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            window = primaryStage;
            window.setTitle("Кликер");

            StackPane layout = new StackPane();
            robot = new Robot();

            scene = new Scene(layout, 200, 100);
            window.setScene(scene);
            window.show();

            scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent ke) {
                    if (ke.getCharacter().equals("]")){
                        System.exit(0);
                        }
                    if (ke.getCharacter().equals("ъ")){
                        System.out.println(" ъ ");
                    }
                    if (ke.getCharacter().equals("Ъ")){
                        System.out.println(" Ъ ");
                    }
                }
            });

        }
    }


