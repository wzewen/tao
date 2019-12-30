package com.java.tao.design.mvc;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student student, StudentView studentView){
        this.model = student;
        this.view = studentView;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo(){
        return model.getRollNo();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
