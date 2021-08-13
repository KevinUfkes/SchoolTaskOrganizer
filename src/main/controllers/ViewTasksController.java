package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.DataLoader;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewTasksController implements Initializable {
    private Scene homeScene;


    @FXML
    private Label lblTitleHome;
    @FXML
    private TextArea taHomeList;
    @FXML
    private Button btnViewByDateAll;
    @FXML
    private Button btnViewByDateAssigned;
    @FXML
    private Button btnViewByWeightAll;
    @FXML
    private Button btnViewByWeightAssigned;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitleHome.setText("Home Welcome!");
//        taHomeList.setText(String.valueOf(Main.pm01.tasksByDateAll()));
    }

    public void setHomePage(Scene scene) {
        homeScene = scene;
    }

    public void btnViewTasksHome(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(homeScene);
    }

    public void btnViewByDateAll(ActionEvent actionEvent) {
        taHomeList.setText(Main.pm01.tasksByDateAll().printList());
    }

    public void btnViewByDateAssigned(ActionEvent actionEvent) {
        taHomeList.setText(Main.pm01.tasksByDateAssigned().printList());
    }

    public void btnViewByWeightAll(ActionEvent actionEvent) {
        taHomeList.setText(Main.pm01.tasksByWeightAll());
    }

    public void btnViewByWeightAssigned(ActionEvent actionEvent) {
        taHomeList.setText(Main.pm01.tasksByWeightAssigned());
    }
}
