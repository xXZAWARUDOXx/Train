package ch.nahro;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Helper {

    private static FXMLLoader loader;

    public static Stage getStage(URL url, String title, Object controller) {
        Stage stage = new Stage();
        loader = new FXMLLoader(url);
        loader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        return stage;
    }

}