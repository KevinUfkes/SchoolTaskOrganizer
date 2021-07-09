package main;

import main.model.Course;
import main.model.Program;
import main.model.ProgramManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataLoader {

    private ProgramManager pm01;

    public DataLoader(ProgramManager pm){
        this.pm01 = pm;
    }

    public void loadData() throws ParseException {
        //Date for Tests
        String tempDateString01;
        String tempDateString02;
        String tempDateString03;
        String tempDateString04;
        String tempDateString05;
        String tempDateString06;
        String tempDateString07;

        tempDateString01 = "01-01-2021 11:59:59";
        tempDateString02 = "02-02-2021 11:59:59";
        tempDateString03 = "03-03-2021 11:59:59";
        tempDateString04 = "04-04-2021 11:59:59";
        tempDateString05 = "05-05-2021 11:59:59";
        tempDateString06 = "06-06-2021 11:59:59";
        tempDateString07 = "07-07-2021 11:59:59";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date01 = formatter.parse(tempDateString01);
        Date date02 = formatter.parse(tempDateString02);
        Date date03 = formatter.parse(tempDateString03);
        Date date04 = formatter.parse(tempDateString04);
        Date date05 = formatter.parse(tempDateString05);
        Date date06 = formatter.parse(tempDateString06);
        Date date07 = formatter.parse(tempDateString07);


//        ProgramManager pm01 = new ProgramManager();

        pm01.addProgram("Fruit Proficiency", "F199");
        Program fruitProficiency = pm01.getProgramById(1000);

        fruitProficiency.addCourse("Apple Peeling", "APPL-1200");
        Course applePeeling = fruitProficiency.getCourseById(2000);

        fruitProficiency.addCourse("Orange Identification", "ORNG-1202");
        Course orangeProficiency = fruitProficiency.getCourseById(2001);

        applePeeling.addTask("Peeling Race 1", 15.5, false, date01);
        applePeeling.addTask("Peeling Race 2", 20.5, false, date02);
        applePeeling.addTask("Peeling Thickness Test", 15.5, false, date06);
        applePeeling.addTask("Midterm Exam", 25.5, false, date04);
        applePeeling.addTask("Final Exam", 35.5, false, date07);

        orangeProficiency.addTask("Tangerine Deceit", 25.5, false, date03);
        orangeProficiency.addTask("Lemon Distinction", 74.5, false, date05);

    }

}
