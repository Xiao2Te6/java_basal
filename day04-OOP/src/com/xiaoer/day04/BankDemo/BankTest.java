package com.xiaoer.day04.BankDemo;

public class BankTest
{
    public static void main(String[] args) {
        Account acc = new Account(1001,250.41,0.0123);
        Customer cust = new Customer("大海","胖");

        cust.setAccount(acc);
        //存款
        cust.getAccount().deposit(100);
        //取款
        cust.getAccount().withdraw(200);
        cust.getAccount().withdraw(300);

        System.out.println("余额为：" + cust.getAccount().getBalance());

        System.out.println("用户 [" + cust.getLastName() + cust.getFirstName() + "] 的银行账户 Id为："
        + cust.getAccount().getId() + "，余额为：" + cust.getAccount().getBalance()
                + "，年利率为： " + cust.getAccount().getAnnualInterrestRate());
    }
}
