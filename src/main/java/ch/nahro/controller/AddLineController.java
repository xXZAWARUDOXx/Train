package ch.nahro.controller;

import ch.nahro.Helper;
import ch.nahro.model.TrainType;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLineController {

    private Stage stage;

    @FXML
    private TextField numberField;

    @FXML
    private ChoiceBox<TrainType> trainTypeChoiceBox;

    public AddLineController(Stage stage) {
        this.stage = stage;
    }

    public void showStage() {
        this.stage = Helper.getStage(this.getClass().getClassLoader().getResource("AddLineView.fxml"), "SRTC Train Administration - Add Line", this);
        this.stage.show();
    }
}
