package com.xiaoer.exercises.wages_system;

public class SalariedEmployee extends Employee{
    private double monthSalary;

    public SalariedEmployee(String name, int id, MyDate birthday) {
        super(name, id, birthday);
    }

    public SalariedEmployee(String name, int id, MyDate birthday, double monthSalary) {
        super(name, id, birthday);
        this.monthSalary = monthSalary;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public double earnings() {
    return monthSalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() +
                "monthSalary=" + monthSalary +
                '}';
    }
}
