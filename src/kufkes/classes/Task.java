package kufkes.classes;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private double weight;
    private boolean isAssigned;
    private Date dueDate;

    public Task(int id, String name, double weight, Date dueDate){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.isAssigned = false;
        this.dueDate = dueDate;
    }

    public Task(int id, String name, double weight, boolean isAssigned, Date dueDate){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.isAssigned = isAssigned;
        this.dueDate = dueDate;
    }

    public Task(Task that){
        this(that.getId(), that.getName(), that.getWeight(), that.getIsAssigned(), that.getDueDate());
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String toString(){
        String s = "\n\t\t-----";
        s += "\n\t\tID: " + this.id;
        s += "\n\t\tName: " + this.name;
        s += "\n\t\tWeight: " + this.weight;
        s += "\n\t\tIs Assigned: " + this.isAssigned;
        s += "\n\t\tDue Date: " + this.dueDate;
        return s;
    }
}
