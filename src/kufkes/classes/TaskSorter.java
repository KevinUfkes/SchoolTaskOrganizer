package kufkes.classes;

import kufkes.classes.LinkedList.LLNode;
import kufkes.classes.LinkedList.LinkedList;

import java.util.Date;

public class TaskSorter {

    public TaskSorter(){

    }

    public String tasksByDate(LinkedList<Program> programs, boolean includeIsNotAssigned){
        LinkedList<Task>tasksByDate = new LinkedList<>();
        LLNode<Program> programCurr;
        programCurr = programs.head;
        if(programs.head==null){
            return null;
        }
        while(programCurr!=null){
            LLNode<Course> courseCurr;
            courseCurr = programCurr.data.getCourses().head;

            while(courseCurr!=null){
                LLNode<Task> taskCurr;
                taskCurr = courseCurr.data.getTasks().head;

                while(taskCurr!=null){
                    if(taskCurr.data.getIsAssigned() || includeIsNotAssigned) {
                        Task taskByDateTemp;
                        taskByDateTemp = new Task(taskCurr.data);
                        LLNode<Task> tempTaskNode = new LLNode<>(taskByDateTemp);
                        tempTaskNode.next = null;
                        Date tempDateTempNode = tempTaskNode.data.getDueDate();


                        if (tasksByDate.head == null || (tasksByDate.head.data.getDueDate().after(tempDateTempNode) || tasksByDate.head.data.getDueDate().equals(tempDateTempNode))) {
                            tempTaskNode.next = tasksByDate.head;
                            tasksByDate.head = tempTaskNode;
                        } else {
                            LLNode<Task> tasksByDateCurr, tasksByDatePrev;
                            tasksByDateCurr = tasksByDatePrev = tasksByDate.head;

                            while (tasksByDateCurr != null && (tasksByDateCurr.data.getDueDate().before(tempDateTempNode) || tasksByDate.head.data.getDueDate().equals(tempDateTempNode))) {
                                tasksByDatePrev = tasksByDateCurr;
                                tasksByDateCurr = tasksByDateCurr.next;
                            }
                            tasksByDatePrev.next = tempTaskNode;
                            tempTaskNode.next = tasksByDateCurr;

                        }
                    }
                    taskCurr = taskCurr.next;
                }
                courseCurr = courseCurr.next;
            }
            programCurr = programCurr.next;
        }
        return tasksByDate.printList();
    }

    public String tasksByWeight(LinkedList<Program> programs, boolean includeIsNotAssigned){
        LinkedList<Task>tasksByWeight = new LinkedList<>();
        LLNode<Program> programCurr;
        programCurr = programs.head;
        if(programs.head==null){
            return null;
        }
        while(programCurr!=null){
            LLNode<Course> courseCurr;
            courseCurr = programCurr.data.getCourses().head;

            while(courseCurr!=null){
                LLNode<Task> taskCurr;
                taskCurr = courseCurr.data.getTasks().head;

                while(taskCurr!=null){
                    if(taskCurr.data.getIsAssigned() || includeIsNotAssigned) {
                        Task taskByWeightTemp;
                        taskByWeightTemp = new Task(taskCurr.data);
                        LLNode<Task> tempWeightTaskNode = new LLNode<>(taskByWeightTemp);
                        tempWeightTaskNode.next = null;

                        if (tasksByWeight.head == null || tasksByWeight.head.data.getWeight() <= tempWeightTaskNode.data.getWeight()) {
                            tempWeightTaskNode.next = tasksByWeight.head;
                            tasksByWeight.head = tempWeightTaskNode;
                        } else {
                            LLNode<Task> tasksByWeightCurr, tasksByWeightPrev;
                            tasksByWeightCurr = tasksByWeightPrev = tasksByWeight.head;
                            while (tasksByWeightCurr != null && tasksByWeightCurr.data.getWeight() >= tempWeightTaskNode.data.getWeight()) {
                                tasksByWeightPrev = tasksByWeightCurr;
                                tasksByWeightCurr = tasksByWeightCurr.next;
                            }
                            tasksByWeightPrev.next = tempWeightTaskNode;
                            tempWeightTaskNode.next = tasksByWeightCurr;
                        }
                    }
                    taskCurr = taskCurr.next;
                }
                courseCurr = courseCurr.next;
            }
            programCurr = programCurr.next;
        }
        return tasksByWeight.printList();
    }
}
