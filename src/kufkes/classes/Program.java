package kufkes.classes;

import kufkes.classes.LinkedList.LLNode;
import kufkes.classes.LinkedList.LinkedList;

public class Program {
    private int id;
    private String name;
    private String code;
    private LinkedList<Course> courses;
    private static int courseIdSeed;

    public Program(int id, String name, String code){
        this.id = id;
        this.name = name;
        this.code = code;
        this.courseIdSeed = 2000;
        this.courses = new LinkedList<Course>();
    }

    public void addCourse(String name, String code){
        Course tempCourse = new Course(courseIdSeed, name, code);
        courses.addFront(tempCourse);
        courseIdSeed++;
    }

    public boolean deleteCourseById(int id){
        if(this.courses.head==null){
            return false;
        }
        LLNode<Course> curr, prev;
        curr = prev = courses.head;
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

    public Course getCourseById(int id){
        if(this.courses.head==null){
            return null;
        }

        LLNode<Course> curr;
        curr = courses.head;
        while(curr!=null && curr.data.getId()!=id){
            curr = curr.next;
        }
        if(curr==null){
            return null;
        }
        return curr.data;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LinkedList<Course> getCourses() {
        return courses;
    }

    public String toString(){
        String s = "\n";
        s += "\nID: " + this.id;
        s += "\nName: " + this.name;
        s += "\nCode: " + this.code;
        s += "\nCourses: ";
        s += courses.printList();

        return s;
    }
}
