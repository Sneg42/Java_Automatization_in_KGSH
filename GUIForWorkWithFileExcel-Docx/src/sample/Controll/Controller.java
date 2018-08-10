package sample.Controll;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.Controll.Programs.AutoValueXLSX;
import sample.Controll.Programs.CreateFile;
import sample.Controll.Programs.Live_or_SZZ_Zone;

public class Controller {
    public TextField txtNamePathForSaveFile;
    public ChoiceBox chBoxNameProgram;
    public Button btmRunProgram;


    public void initialize() {
        // add items on choice Box
        chBoxNameProgram.setItems(FXCollections.observableArrayList(
                "Порода по каждому Авто",
                "Данные из таблицы Эры по зонам"
        ));
    }
    public void stopProgramm(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void runProgram(ActionEvent actionEvent) throws Exception{
        CreateFile selectProgram = null;

        // choice progrom for work
        if(chBoxNameProgram.getValue().equals("Порода по каждому Авто")) {
            selectProgram = new AutoValueXLSX();
        }
        if (chBoxNameProgram.getValue().equals("Данные из таблицы Эры по зонам")) {
            selectProgram = new Live_or_SZZ_Zone();
        }

        // пока не настроил место сохранения сохранять по умолчянию в папку 1 на диске D
        selectProgram.createFile("D:\\\\1");

//            // check path saving and run program
//            String path = txtNamePathForSaveFile.getText();
//            while (!path.equals("")) {
//                if (path.equals("D:\\1") || path.equals("C:\\1")) selectProgram.createFile(path);
//                break;
//            }
//        System.exit(0);
    }
}
