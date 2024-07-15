package com.company;

public class CheckUp {
    Doctor Doctor;
    Patient Patient;
    int priority;
    String Recommendation,Date;


    public CheckUp(com.company.Doctor doctor, com.company.Patient patient, int priority, String recommendation, String date) {
        Doctor = doctor;
        Patient = patient;
        this.priority = priority;
        Recommendation = recommendation;
        Date = date;
    }

    public com.company.Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(com.company.Doctor doctor) {
        Doctor = doctor;
    }

    public com.company.Patient getPatient() {
        return Patient;
    }

    public void setPatient(com.company.Patient patient) {
        Patient = patient;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRecommendation() {
        return Recommendation;
    }

    public void setRecommendation(String recommendation) {
        Recommendation = recommendation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Checkup{" +
                "Doctor=" + Doctor.toString() +
                ", Patient=" + Patient.toString() +
                ", priority=" + priority +
                ", Recommendation='" + Recommendation + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
