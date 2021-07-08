package kufkes.classes;

import kufkes.classes.LinkedList.LLNode;
import kufkes.classes.LinkedList.LinkedList;

import java.util.Date;

public class ProgramManager {

    private static int programIdSeed;
    private LinkedList<Program> programs;
    private TaskSorter taskSorter;

    public ProgramManager(){
        this.programIdSeed = 1000;
        this.programs = new LinkedList<>();
        this.taskSorter = new TaskSorter();
    }

    public void addProgram(String name, String code){
        Program tempProgram = new Program(programIdSeed, name, code);
        programs.addFront(tempProgram);
        programIdSeed++;
    }

    public boolean deleteProgramById(int id){
        if(this.programs.head==null){
            return false;
        }
        LLNode<Program> curr, prev;
        curr = prev = programs.head;
        while(curr!=null && curr.data.getId()!=id){
            prev = curr;
            curr = curr.next;
        }
        if(curr==null){
            return false;
        }
        prev.next = curr.next;
        return true;
    }

    public Program getProgramById(int id){
        if(programs.head==null){
            return null;
        }

        LLNode<Program> curr = programs.head;
        while(curr!=null && curr.data.getId()!=id){
            curr = curr.next;
        }
        if(curr==null){
            return null;
        }
        return curr.data;
    }

    public Course getCourseById(int id){
        LLNode<Program> programCurr;
        programCurr = programs.head;
        if(programs.head==null){
            return null;
        }
        while(programCurr!=null){
            LLNode<Course> courseCurr;
            courseCurr = programCurr.data.getCourses().head;

            while(courseCurr!=null && courseCurr.data.getId()!=id){
                courseCurr = courseCurr.next;
            }
            if(courseCurr.data.getId()==id){
                return courseCurr.data;
            }
            programCurr = programCurr.next;
        }
        return null;
    }

    public String tasksByDateAssigned(){
        return taskSorter.tasksByDate(programs, false);
    }
    public String tasksByDateAll(){ return taskSorter.tasksByDate(programs, true); }

    public String tasksByWeightAssigned(){
        return taskSorter.tasksByWeight(programs, false);
    }

    public String tasksByWeightAll(){
        return taskSorter.tasksByWeight(programs, true);
    }

    public LinkedList<Program> getPrograms() {
        return programs;
    }

    public String toString(){
        String s = "Program List: ";
        s += programs.printList();
        return s;
    }
}
