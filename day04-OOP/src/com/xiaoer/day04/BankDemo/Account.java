package com.xiaoer.day04.BankDemo;

public class Account
{
    private int id;
    private double balance;
    private double annualInterrestRate;

    public Account(int id,double balance, double annualInterrestRate){
        this.balance = balance;
        this.annualInterrestRate = annualInterrestRate;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterrestRate() {
        return annualInterrestRate;
    }

    public void setAnnualInterrestRate(double annualInterrestRate) {
        this.annualInterrestRate = annualInterrestRate;
    }

    //取钱
    public void withdraw(double amount){
        if(balance < amount){
            System.out.println("余额不足！");
            return;
        }
        balance -= amount;
        System.out.println("成功存入" +  amount + "元");
    }
    //存钱
    public void deposit(double amount){
        if (amount < 0){
            return;
        }
        balance += amount;
        System.out.println("成功存入" + amount +"元");
    }
}
