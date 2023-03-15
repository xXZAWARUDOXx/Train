package ch.nahro.controller;

import ch.nahro.Helper;
import ch.nahro.dao.GenericDAO;
import ch.nahro.model.TableModel;
import ch.nahro.model.TrainLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class MainController {

    private Stage stage;

    private static final ObservableList<TableModel> TABLE_ITEMS = FXCollections.observableArrayList();

    @FXML
    private TableView<TableModel> tableView;

    private TableColumn<TableModel, String> nameColumn;
    private TableColumn<TableModel, String> lineColumn;
    private TableColumn<TableModel, Integer> stopsColumn;

    @FXML
    public void initialize() {
        nameColumn = new TableColumn<>("Name");
        lineColumn = new TableColumn<>("Line");
        stopsColumn = new TableColumn<>("Stops");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lineColumn.setCellValueFactory(new PropertyValueFactory<>("line"));
        stopsColumn.setCellValueFactory(new PropertyValueFactory<>("stop"));
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(lineColumn);
        tableView.getColumns().add(stopsColumn);
        updateItemsFromDB();
        System.out.println(TABLE_ITEMS);
    }

    public void newLIne(ActionEvent actionEvent) {
    }

    public void deleteLine(ActionEvent actionEvent) {
    }

    public void importData(ActionEvent actionEvent) {
    }

    public void showStage() {
        this.stage = Helper.getStage(this.getClass().getClassLoader().getResource("MainView.fxml"), "SRTC Train Administration", this);
        this.stage.show();
    }

    private void updateItemsFromDB() {
        TABLE_ITEMS.clear();
        GenericDAO<TrainLine> trainLineDAO = new GenericDAO<>(TrainLine.class);
        List<TrainLine> trainLines = trainLineDAO.getAll();
        for (TrainLine trainLine : trainLines) {
            TABLE_ITEMS.add(new TableModel(trainLine));
        }
        tableView.setItems(TABLE_ITEMS);
        tableView.refresh();
    }
}
