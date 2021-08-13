package main.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.TableView;

public class HomeController {
    private Scene viewTasksScene;
    private TableView tvHomeTest;



    public void setViewTasksPage(Scene scene) {
        viewTasksScene = scene;
    }

    public void btnGoToViewTasks(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(viewTasksScene);
    }
}
