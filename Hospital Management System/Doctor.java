package com.company;

public class Doctor {
    private String Id, Name , Contact, Speciality;
    private int Fees;

    public Doctor() {
    }

    public Doctor(String id, String name, String contact, String speciality, int fees) {
        Id = id;
        Name = name;
        Contact = contact;
        Speciality = speciality;
        Fees = fees;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public int getFees() {
        return Fees;
    }

    public void setFees(int fees) {
        Fees = fees;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Speciality='" + Speciality + '\'' +
                ", Fees=" + Fees +
                '}';
    }
}
