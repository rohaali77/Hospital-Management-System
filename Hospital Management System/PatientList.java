package com.company;

class PNode
{
    Patient patient;
    PNode next,previous;

    public PNode() {
    }

    public PNode(Patient patient) {
        this.patient = patient;
        next= null;
        previous=null;
    }
}

public class PatientList {
    PNode head,tail;

    public PatientList() {
        head = null;
        tail=null;
    }
    public void Insert(Patient patient){
        PNode node = new PNode(patient);
        if (head == null)
            head = node;
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }
    public Patient SearchById(String id){
        PNode temp = head;
        while(temp != null){
            if(temp.patient.getId().equals(id)){
                return temp.patient;
            }
            temp= temp.next;
        }
        return null;
    }
    public int Size(){
        PNode temp= head;
        int count= 0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public Patient SearchByContact(String Contact){
        PNode temp = head;
        while(temp != null){
            if(temp.patient.getContact().equals(Contact)){
                return temp.patient;
            }
            temp= temp.next;
        }
        return null;
    }
    public void PrintData(){
        PNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            System.out.println(count+" :   "+temp.patient.toString());
            temp=temp.next;
        }
    }
}
