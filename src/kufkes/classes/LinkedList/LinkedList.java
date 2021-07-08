package kufkes.classes.LinkedList;

public class LinkedList<T> {
    public LLNode<T> head;

    public LinkedList(){
        this.head = null;
    }

    public void addFront(T data){
        LLNode<T> n = new LLNode<T>(data);
        if(head==null){
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public String printList(){
        String s = "";
        LLNode<T> curr;
        curr = head;
        while(curr!=null){
            s += curr.data;
            curr = curr.next;
        }
        return s;
    }
}

