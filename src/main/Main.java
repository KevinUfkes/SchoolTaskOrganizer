package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controllers.HomeController;
import main.controllers.ViewTasksController;
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
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("view/home.fxml"));
        Parent homePane = homeLoader.load();
        Scene homeScene = new Scene(homePane, 1000, 800);


        // View Tasks Scene
        FXMLLoader viewTasksLoader = new FXMLLoader(getClass().getResource("view/viewTasks.fxml"));
        Parent viewTasksPane = viewTasksLoader.load();
        Scene viewTasksScene = new Scene(viewTasksPane, 1000, 800);

        HomeController homePaneController = (HomeController) homeLoader.getController();
        homePaneController.setViewTasksPage(viewTasksScene);

        ViewTasksController viewTasksController = (ViewTasksController) viewTasksLoader.getController();
        viewTasksController.setHomePage(homeScene);

//        Parent root = FXMLLoader.load(getClass().getResource("view/viewTasks.fxml"));
//        primaryStage.setTitle("Hello World");
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
