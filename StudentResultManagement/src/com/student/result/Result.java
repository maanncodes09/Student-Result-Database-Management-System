package com.student.result;

public class Result {
    private int studentId;
    private double marks;
    private String grade;

    public Result(int studentId, double marks, String grade) {
        this.studentId = studentId;
        this.marks = marks;
        this.grade = grade;
    }

    public int getStudentId() { return studentId; }
    public double getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setMarks(double marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }
}