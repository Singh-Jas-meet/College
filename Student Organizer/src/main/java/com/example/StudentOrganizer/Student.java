package com.example.StudentOrganizer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
This class will act as the model for the Student Management System.
Required student fields will be created in this class along with encapsulation.
 */
public class Student {
    //  Below initialized are required student fields
    private SimpleStringProperty studentName;
    private SimpleIntegerProperty studentId;
    private SimpleStringProperty studentMajor;

    //    default constructor to initialize student object
    public Student( Integer studentId, String studentName, String studentMajor){
        this.studentId= new SimpleIntegerProperty(studentId);
        this.studentMajor= new SimpleStringProperty(studentMajor);
        this.studentName= new SimpleStringProperty(studentName);
    }
    //    setters for student name, id, and major. These are used to update student fields or change their values.
    public void setStudentName(String studentName) {
        this.studentName = new SimpleStringProperty(studentName);
    }

    public void setStudentId(int studentId) {
        this.studentId = new SimpleIntegerProperty(studentId);
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = new SimpleStringProperty(studentMajor);
    }

    //    getters for student name, id, and major. These will return the value of the student fields.
    public String getStudentName() {
        return studentName.get();
    }

    public Integer getStudentId() {
        return studentId.get();
    }

    public String getStudentMajor() {
        return studentMajor.get();
    }
}
