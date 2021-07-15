package main.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    private Scene viewTasksScene;

    public void setViewTasksPage(Scene scene) {
        viewTasksScene = scene;
    }

    public void btnGoToViewTasks(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(viewTasksScene);
    }
}
