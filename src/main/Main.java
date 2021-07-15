package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.ProgramManager;

public class Main extends Application {
    public static ProgramManager pm01;

    @Override
    public void start(Stage primaryStage) throws Exception{

        pm01 = new ProgramManager();
        DataLoader dataLoader = new DataLoader(pm01);
        dataLoader.loadData();

        System.out.println(pm01.tasksByDateAssigned());

        // Home Scene
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("view/viewTasks.fxml"));
        Parent homePane = homeLoader.load();
        Scene homeScene = new Scene(homePane, 1000, 800);

//        HomeController homePaneController = (HomeController) homeLoader.getController();
//        homePaneController.set

//        Parent root = FXMLLoader.load(getClass().getResource("view/viewTasks.fxml"));
//        primaryStage.setTitle("Hello World");
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
