package kufkes;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kufkes.classes.Course;
import kufkes.classes.Program;
import kufkes.classes.ProgramManager;
import kufkes.classes.Task;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main extends Application implements EventHandler<ActionEvent> {

    ProgramManager pm01 = new ProgramManager();
    // Home Items
    Label lblTitleHome, lblAddCourse, lblAddTask;
    Button btnAddProgram, btnAddCourse, btnAddTask;
    TextArea taViewAll;
    TextField tfProgramIdToAddCourse, tfCourseIdToAddTask;

    // Message Items
    Label lblMessage;
    Button btnMessageHome;

    // Add Program Items
    Label lblTitleAddProgram, lblProgramName, lblProgramCode;
    Button btnAddProgramSubmit, btnAddProgramBack;
    TextField tfProgramName, tfProgramCode;

    // Add Course Items
    Label lblTitleAddCourse, lblCourseName, lblCourseCode;
    Button btnAddCourseSubmit, btnAddCourseBack;
    TextField tfCourseName, tfCourseCode;

    // Add Task Items
    Label lblTitleAddTask, lblTaskName, lblTaskWeight, lblTaskIsAssigned, lblTaskDueDate;
    Button btnAddTaskSubmit, btnAddTaskBack;
    TextField tfTaskName, tfTaskWeight;
    CheckBox cbTaskIsAssigned;
    DatePicker dpTaskDueDate;

    Stage window;
    Scene mainScene, sceneMessage, sceneAddProgram, sceneAddCourse, sceneAddTask;
//    private Date dpTaskDueDate;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 1500, 1000));
//        primaryStage.show();

    // Home Scene
        window = primaryStage;
        window.setTitle("School Task Organizer");
        lblTitleHome = new Label("Welcome!");
        taViewAll = new TextArea();
        taViewAll.setText(pm01.toString());
        taViewAll.setPrefHeight(800);
        taViewAll.setPrefWidth(800);
        btnAddProgram = new Button("Add Program");
        btnAddProgram.setOnAction(this);
        lblAddCourse = new Label("Program Id to Add Course");
        tfProgramIdToAddCourse = new TextField();
        btnAddCourse = new Button("Add Course");
        btnAddCourse.setOnAction(this);
        lblAddTask = new Label("Course Id to Add Task");
        tfCourseIdToAddTask = new TextField();
        btnAddTask = new Button("Add Task");
        btnAddTask.setOnAction(this);

        VBox home = new VBox(10);
        home.setLayoutX(10);
        home.setAlignment(Pos.CENTER);
        home.getChildren().addAll(lblTitleHome, taViewAll, btnAddProgram, lblAddCourse, tfProgramIdToAddCourse, btnAddCourse, lblAddTask, tfCourseIdToAddTask, btnAddTask);
        mainScene = new Scene(home, 1500, 1000);

    // Message Scene
        lblMessage = new Label("");
        btnMessageHome = new Button("Home");
        btnMessageHome.setOnAction(this);

        VBox message = new VBox(10);
        message.setLayoutX(10);
        message.setAlignment(Pos.CENTER);
        message.setMaxSize(1500, 1000);
        message.getChildren().addAll(lblMessage, btnMessageHome);
        sceneMessage = new Scene(message, 1500, 1000);


    // Add Program Scene
        lblTitleAddProgram = new Label("Add Your Program");
        lblProgramName = new Label("Program Name");
        tfProgramName = new TextField();
        lblProgramCode = new Label("Program Code");
        tfProgramCode = new TextField();
        btnAddProgramSubmit = new Button("Submit");
        btnAddProgramSubmit.setOnAction(this);
        btnAddProgramBack = new Button ("Back");
        btnAddProgramBack.setOnAction(this);

        VBox addProgram = new VBox(10);
        addProgram.setLayoutX(10);
        addProgram.setAlignment(Pos.CENTER);
        addProgram.getChildren().addAll(lblTitleAddProgram, lblProgramName, tfProgramName, lblProgramCode, tfProgramCode, btnAddProgramSubmit, btnAddProgramBack);
        sceneAddProgram = new Scene(addProgram, 1500, 1000);

        // Add Course Scene
        lblTitleAddCourse = new Label("Add a Course");
        lblCourseName = new Label("Course Name");
        tfCourseName = new TextField();
        lblCourseCode = new Label("Course Code");
        tfCourseCode = new TextField();
        btnAddCourseSubmit = new Button("Submit");
        btnAddCourseSubmit.setOnAction(this);
        btnAddCourseBack = new Button("Back");
        btnAddCourseBack.setOnAction(this);

        VBox addCourse = new VBox(10);
        addCourse.setLayoutX(10);
        addCourse.setAlignment(Pos.CENTER);
        addCourse.getChildren().addAll(lblTitleAddCourse, lblCourseName, tfCourseName, lblCourseCode, tfCourseCode, btnAddCourseSubmit, btnAddCourseBack);
        sceneAddCourse = new Scene(addCourse, 1500, 1000);

    // Add Task Scene
        lblTitleAddTask = new Label("Add Task");
        lblTaskName = new Label("Task Name");
        tfTaskName = new TextField();
        lblTaskWeight = new Label("Task Weight");
        tfTaskWeight = new TextField();
        lblTaskIsAssigned = new Label("Is Assigned");
        cbTaskIsAssigned = new CheckBox();
        lblTaskDueDate = new Label("Due Date");
        dpTaskDueDate = new DatePicker();
        btnAddTaskSubmit = new Button("Submit");
        btnAddTaskSubmit.setOnAction(this);
        btnAddTaskBack = new Button("Back");
        btnAddTaskBack.setOnAction(this);

        VBox addTask = new VBox(10);
        addTask.setLayoutX(10);
        addTask.setAlignment(Pos.CENTER);
        addTask.getChildren().addAll(lblTitleAddTask, lblTaskName, tfTaskName, lblTaskWeight, tfTaskWeight, lblTaskIsAssigned, cbTaskIsAssigned, lblTaskDueDate, dpTaskDueDate, btnAddTaskSubmit, btnAddTaskBack);
        sceneAddTask = new Scene(addTask, 1500, 1000);


        window.setScene(mainScene);
        window.show();
    }

    @Override
    public void handle(ActionEvent e){
        if(e.getSource() == btnAddProgram){
            System.out.println("btnAddProgram");
            window.setScene(sceneAddProgram);
        }

        if(e.getSource() == btnAddProgramSubmit){
            System.out.println("btnAddProgramSubmit");
            String name = String.valueOf(tfProgramName.getText());
            String code = String.valueOf(tfProgramCode.getText());

            System.out.println(code);
            pm01.addProgram(name, code);
            lblMessage.setText("Added Program: " + name);
            window.setScene(sceneMessage);
        }

        if(e.getSource() == btnAddCourse){
            System.out.println("btnAddCourse");
            window.setScene(sceneAddCourse);
        }

        if(e.getSource()==btnAddTask){
            System.out.println("btnAddTask");
            window.setScene(sceneAddTask);
        }

        if(e.getSource()==btnAddCourseSubmit){
            Program temp = pm01.getProgramById(Integer.parseInt(tfProgramIdToAddCourse.getText()));
            System.out.println(temp);
            String courseName = String.valueOf(tfCourseName.getText());
            String courseCode = String.valueOf(tfCourseCode.getText());
            temp.addCourse(courseName, courseCode);
            lblMessage.setText("Added Course: " + courseName);
            tfProgramIdToAddCourse.setText("");
            window.setScene(sceneMessage);
        }

        if(e.getSource()==btnAddTaskSubmit){

            Course temp = pm01.getCourseById(Integer.parseInt(tfCourseIdToAddTask.getText()));
            System.out.println(temp);
            String taskName = String.valueOf(tfTaskName.getText());
            Double taskWeight = Double.parseDouble(tfTaskWeight.getText());
            Boolean taskIsAssigned = cbTaskIsAssigned.isSelected();
            LocalDate taskDueDateTemp = dpTaskDueDate.getValue();
            Date taskDueDate = Date.from(taskDueDateTemp.atStartOfDay(ZoneId.systemDefault()).toInstant());

            System.out.println(taskName);
            System.out.println(taskWeight);
            System.out.println(taskIsAssigned);
            System.out.println(taskDueDateTemp);
            System.out.println(taskDueDate);

            temp.addTask(taskName, taskWeight, taskIsAssigned, taskDueDate);
            lblMessage.setText("Added Task: " + taskName);
            tfCourseIdToAddTask.setText("");
            window.setScene(sceneMessage);
        }

        if(e.getSource() == btnMessageHome){
            System.out.println("btnMessageHome");
            lblMessage.setText("");
            taViewAll.setText(pm01.toString());
            window.setScene(mainScene);
        }

        if(e.getSource() == btnAddProgramBack){
            window.setScene(mainScene);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
