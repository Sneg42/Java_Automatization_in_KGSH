package sample.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.Combination.Combination;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Изолини ПДК");
            primaryStage.setScene(new Scene(root, 400, 300));
        } catch (Exception e) {
            System.out.println("Поймал ");
            // generic exception handling
            e.printStackTrace();
        }
            primaryStage.setResizable(false);
            primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

    }
}
