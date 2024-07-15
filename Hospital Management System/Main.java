package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Patient p1 = new Patient("11","Adnan","0333-333");
        Patient p2 = new Patient("12","Laiba","0333-222");
        Patient p3 = new Patient("13","Iqra","0333-444");

        PatientList pList = new PatientList();
        pList.Insert(p1);
        pList.Insert(p2);
        pList.Insert(p3);

        Doctor d1 = new Doctor("21","Mazhar","0334-444","Eyes",700);
        Doctor d2 = new Doctor("22","Haseeb","0334-555","Neurologist",500);
        Doctor d3 = new Doctor("23","Aliya","0334-666","Gynecologist",500);

        DoctorList dList = new DoctorList();
        dList.Insert(d1);
        dList.Insert(d2);
        dList.Insert(d3);

        Scanner s = new Scanner(System.in);

        String Choice;
        while(true){
            MainMenu();
            Choice =s.nextLine();
            if(Choice.equals("1")){
                System.out.println("\n DOCTORS ID");
                String Id = s.nextLine();

                System.out.println("\n DOCTORS NAME");
                String Name = s.nextLine();

                System.out.println("\n DOCTORS CONTACT");
                String Contact = s.nextLine();

                System.out.println("\n DOCTORS SPECIALITY");
                String Speciality = s.nextLine();

                System.out.println("\n DOCTORS FEES");
                int Fees = s.nextInt();
                s.nextLine();

                Doctor d = new Doctor(Id,Name,Contact,Speciality,Fees);
                dList.Insert(d);
            }
            else if(Choice.equals("2")){
                System.out.println("\n Patient Id");
                String Id = s.nextLine();

                System.out.println("\n Patient Name");
                String Name = s.nextLine();

                System.out.println("\n Patient Contact");
                String Contact = s.nextLine();

                Patient patient = new Patient(Id,Name,Contact);
                pList.Insert(patient);
            }
            else if(Choice.equals("3")){
                dList.PrintData();
            }
            else if(Choice.equals("4")){
                pList.PrintData();
            }
            else if (Choice.equals("5")){
                System.out.println("\nWELCOME TO CHECKUP MENU \n");

                CheckUpList[] cList = new CheckUpList[dList.Size()];
                for (int i = 0; i < cList.length; i++) {

                    cList[i] = new CheckUpList();
                    Doctor doctor = dList.getAtIndex(i);
                    System.out.println("\n\nENTER PATIENT FOR DOCTOR :");
                    System.out.println("NAME         :"+doctor.getName());
                    System.out.println("SPECIALITY   :"+doctor.getSpeciality());
                    System.out.println("FEES         :"+doctor.getFees());

                    System.out.println("ALL PATIENTS   :");
                    pList.PrintData();

                    while(true){
                        System.out.println("ENTER PATIENT ID or TYPE null TO STOP");
                        String Id = s.nextLine();

                        if(Id.equals("null")){
                            break;
                        }
                        System.out.println("PRIORITY 1 FOR EMERGENCY 2 FOR INTERMEDIATE ANY OTHER KEY FOR NORMAL  ");
                        String per = s.nextLine();

                        int p=1;
                        if(per.equals("1")){
                            p=1;
                        }
                        else if(per.equals("2")){
                            p=2;
                        }
                        Patient patient = pList.SearchById(Id);
                        if(patient==null){
                            System.out.println("\n INVALID PATIENT ID !  \n");
                        }
                        else{
                            CheckUp cup = new CheckUp(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                            cList[i].Enqueue(cup);
                        }
                    }
                }
                for (int i = 0; i < cList.length; i++) {
                    System.out.println("\n\n Patients IN QUEUE FOR DOCTOR "+dList.getAtIndex(i).getName());
                    for (int j = 0; j < cList[i].Size(); j++) {
                        System.out.println("Patient "+(j+1)+"\nENTER RECOMMENDATION FOR PATIENT : "+cList[i].getPatient(j));
                        String rec = s.nextLine();
                        cList[i].AddRecommendation(j,rec);
                    }
                }
            }
            else if (Choice.equals("0")){
                break;
            }
        }
    }
    public static void MainMenu(){
        System.out.println("\n\n||   ******  HOSPITAL MANAGEMENT SYSTEM  ******   ||");
        System.out.println("       ||    MAIN MENU    ||");
        System.out.println("\nEnter 1 for Insert new Doctor");
        System.out.println("Enter 2 for Insert Patient ");
        System.out.println("Enter 3 for Print All Doctors");
        System.out.println("Enter 4 for Print All Patients ");
        System.out.println("Enter 5 for Checkup Menu ");
        System.out.println("Enter 0 for Exit  ");
    }
}
