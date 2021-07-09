package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.DataLoader;
import main.model.Program;
import main.model.ProgramManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ProgramManager pm01 = new ProgramManager();
        DataLoader dataLoader = new DataLoader(pm01);
        dataLoader.loadData();

        Parent root = FXMLLoader.load(getClass().getResource("view/home.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
