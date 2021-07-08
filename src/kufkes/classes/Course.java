package kufkes.classes;

import kufkes.classes.LinkedList.LLNode;
import kufkes.classes.LinkedList.LinkedList;

import java.util.Date;

public class Course {
    private int id;
    private String name;
    private String code;
    public LinkedList<Task> tasks;
    private static int taskIdSeed;

    public Course(int id, String name, String code, int maxTasks){
        this.id = id;
        this.name = name;
        this.code = code;
        this.taskIdSeed = 3000;

        this.tasks = new LinkedList<Task>();
    }

    public Course(int id, String name, String code){
        this.id = id;
        this.name = name;
        this.code = code;
        this.taskIdSeed = 3000;

        this.tasks = new LinkedList<Task>();
    }

    public void addTask(String name, double weight, Date dueDate){
        Task tempTask = new Task(taskIdSeed, name, weight, dueDate);
        tasks.addFront(tempTask);
        taskIdSeed++;
    }

    public int getId() {
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

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    public boolean deleteTaskById(int id){
        if(this.tasks.head==null){
            return false;
        }
        LLNode<Task> curr, prev;
        curr = prev = tasks.head;
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

    public Task getTaskById(int id){
        if(this.tasks.head==null){
            return null;
        }

        LLNode<Task> curr = tasks.head;
        while(curr!=null && curr.data.getId()!= id){
            curr = curr.next;
        }
        if(curr==null){
            return null;
        }
        return curr.data;

    }

    public String toString(){
        String s = "";
        s += "\n\tID: " + this.id;
        s += "\n\tName: " + this.name;
        s += "\n\tCode: " + this.code;
        s += "\n\tTasks: ";
        s += tasks.printList();
        return s;
    }
}
