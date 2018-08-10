package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import sample.controller.main_programm.Isolinii_from_Era;



public class Controller {

    public TextField txtField_number_emissions;
    public TextField txtField_scale;
    public Button btn_start;



    public void pullIsolinii(ActionEvent actionEvent) {
        // number of emission or number of isolines in Era
        int number_emissions = Integer.parseInt(txtField_number_emissions.getText());
        // scale in era graphic for pdf file

        // Убрал масштаб так как в последнем обновлении он не изменяется, но если что то измениться то роазкоменьти строчку ниже
        String scale_in_era_for_isolines = "";
//        String scale_in_era_for_isolines = txtField_scale.getText();

        Isolinii_from_Era is = new Isolinii_from_Era();
        is.run_create_all_file(number_emissions, scale_in_era_for_isolines);


        System.out.println("number_emissions");
    }

}
