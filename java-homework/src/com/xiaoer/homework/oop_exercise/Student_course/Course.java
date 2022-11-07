package com.xiaoer.homework.oop_exercise.Student_course;

public class Course
{
    private String className;
    private int score;

    public Course(){
    }

    public Course(String className, int score) {
        this.className = className;
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
