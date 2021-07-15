package main;

import main.model.Course;
import main.model.Program;
import main.model.ProgramManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataLoader {

    public ProgramManager pm01;

    public ProgramManager getPm01(){
        return pm01;
    }

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

        pm01.addProgram("Fruit Proficiency", "FP - 607");
        Program fruitProficiency = pm01.getProgramById(1000);

        fruitProficiency.addCourse("Intro to Apple Peeling", "IAPP-999");
        fruitProficiency.addCourse("Orange Textures", "OTXT-988");

        Course introAppPeeling = pm01.getProgramById(1000).getCourseById(2000);
        Course orangeTextures = pm01.getProgramById(1000).getCourseById(2001);

        introAppPeeling.addTask("Peeling Race 1", 10.6, true, date01);
        introAppPeeling.addTask("Peeling Race 2", 20.5, false, date06);
        introAppPeeling.addTask("Peeling Race 3", 30.3, true, date03);
        introAppPeeling.addTask("Peeling Race 4", 22.7, false, date07);
        introAppPeeling.addTask("Peeling Race 5", 18.9, true, date05);

        orangeTextures.addTask("Peel Orange 1", 50.5, false, date02);
        orangeTextures.addTask("Peel Orange 2", 49.5, date04);

    }

}
