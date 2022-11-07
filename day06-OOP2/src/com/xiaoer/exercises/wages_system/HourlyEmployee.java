package com.xiaoer.exercises.wages_system;

public class HourlyEmployee extends Employee{
    private double wage;
    private double hour;

    public HourlyEmployee(String name, int id, MyDate birthday) {
        super(name, id, birthday);
    }

    public HourlyEmployee(String name, int id, MyDate birthday, double wage, double hour) {
        super(name, id, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                super.toString() +
                '}';
    }
}
