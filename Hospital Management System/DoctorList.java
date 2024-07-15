package com.company;

class DNode
{
    Doctor doctors;
    DNode next;
    DNode previous;

    public DNode() {
    }

    public DNode( Doctor doctors) {
        this.doctors= doctors;
        next= null;
        previous=null;
    }
}

public class DoctorList {
    DNode head,tail;

    public DoctorList() {
        head = null;
        tail=null;
    }
    public void Insert(Doctor doctors){
        DNode node = new DNode(doctors);
        if (head == null)
            head = node;
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }
    public void Delete(Doctor doctor){

    }
    public Doctor SearchById(String id){
        DNode temp = head;
        while(temp != null){
            if(temp.doctors.getId().equals(id)){
                return temp.doctors;
            }
            temp= temp.next;
        }
        return null;
    }
    public Doctor SearchByContacts(String Contacts){
        DNode temp = head;
        while(temp != null){
            if(temp.doctors.getContact().equals(Contacts)){
                return temp.doctors;
            }
            temp= temp.next;
        }
        return null;
    }
    public void AllDoctorsInfo(){
        DNode temp = head;
        while(temp != null){
            System.out.println("Doctor ID ="+temp.doctors.getId()+"     Specialty = "+temp.doctors.getSpeciality());
            temp= temp.next;
        }

    }
    public Doctor getAtIndex(int Index){
        DNode temp= head;
        for (int i = 0; i < Index; i++) {
            temp = temp.next;
        }
        return temp.doctors;
    }

    public int Size(){
        DNode temp= head;
        int count= 0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public void PrintData(){
        DNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            System.out.println(count+" :   "+temp.doctors.toString());
            temp=temp.next;
        }
    }
}
