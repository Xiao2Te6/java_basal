package com.atxiao2._01_multi_thread.exercise.account_test;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer = new Customer(account);
        Customer customer1 = new Customer(account);

        customer.setName("高胖");
        customer1.setName("高贵妃");

        customer.start();
        customer1.start();
    }
}

class Account{
    private  double balances;
    private ReentrantLock lock = new ReentrantLock();

    public Account(double balances) {
        this.balances = balances;
    }

    public void deposit(int amt){

            try {
                lock.lock();
                if(amt > 0){
                    balances += amt;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balances);
                }
            }finally {
                lock.unlock();
            }
    }
}
class Customer extends Thread{
    private Account account;
    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            account.deposit(1000);
        }
    }
}
