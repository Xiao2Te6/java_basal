package com.xiaoer.homework.oop_exercise.student1;

public class Student
{
    private String name;
    private int age;
    private String gender;
    private int enScore;
    private int maScore;
    private int cnScore;

    public Student() {
    }

    public Student(String name, int age, String gender, int enScore, int maScore, int cnScore) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.enScore = enScore;
        this.maScore = maScore;
        this.cnScore = cnScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEnScore() {
        return enScore;
    }

    public void setEnScore(int enScore) {
        this.enScore = enScore;
    }

    public int getMaScore() {
        return maScore;
    }

    public void setMaScore(int maScore) {
        this.maScore = maScore;
    }

    public int getCnScore() {
        return cnScore;
    }

    public void setCnScore(int cnScore) {
        this.cnScore = cnScore;
    }
}
