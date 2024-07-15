package com.company;

class CNode{
    CheckUp cu;
    CNode next, previous ;

    public CNode(CheckUp cu) {
        next=previous=null;
        this.cu =cu;
    }
}

public class CheckUpList {
    CNode head,tail;
    public CheckUpList(){
        head = null;
        tail = null;
    }

    public void Enqueue(CheckUp cu){
        CNode newNode = new CNode(cu);
        //newNode.cu = cu;
        if (head == null){
            head = newNode;
            tail = newNode;
            newNode.next = null;
        }
        else{
            if (cu.getPriority() <= head.cu.getPriority()){
                newNode.next = head;
                head.previous = newNode.next;
                head = newNode;
            }
            else if (cu.getPriority() > tail.cu.getPriority()){
                newNode.next = null;
                tail.next = newNode;
                newNode.previous = tail.next;
                tail = newNode;
            }
            else {
                CNode current = head.next;
                while (current.cu.getPriority() >= cu.getPriority()){
                    current = current.next;
                }
                current.previous.next = newNode;
                newNode.next = current.previous;
                newNode.previous = current.previous.next;
                current.previous = newNode.next;
            }
        }
    }

    public CheckUp dequeue(){
        if(head == null){
            return null;
        }
        CNode checkup= head;
        head = head.next;
        return checkup.cu;
    }

    public void AddRecommendation(int index, String records){
        CNode temp=head;
        int i =0;
        while(temp!=null){
            if(index==i){
                temp.cu.setRecommendation(records);
                break;
            }
            i++;
            temp=temp.next;
        }
    }

    public Patient getPatient(int index){
        CNode temp = head;
        int i =0;
        while(temp!= null){
            if (index==i){
                break;
            }
            i++;
            temp= temp.next;
        }
        return temp.cu.getPatient();
    }
    public int Size(){
        CNode temp= head;
        int count= 0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public void Print(){
        CNode temp = head;
        while(temp!=null){
            System.out.println(temp.cu.getPriority()+"       "+temp.cu.getRecommendation());
            temp = temp.next;
        }
    }
}
