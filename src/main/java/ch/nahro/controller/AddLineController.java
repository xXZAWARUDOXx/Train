package ch.nahro.controller;

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


}
