package ch.nahro;

import ch.nahro.controller.MainController;
import ch.nahro.dao.Connector;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Connector.getInstance().setConfiguration();
        MainController mainController = new MainController();
        mainController.showStage();
    }
}