package com.xiaoer.project.project2_customer_information_mannegement.ui;

import com.xiaoer.project.project2_customer_information_mannegement.bean.Customer;
import com.xiaoer.project.project2_customer_information_mannegement.serveice.CustomerList;
import com.xiaoer.project.project2_customer_information_mannegement.util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);
    public CustomerView(){
        Customer custs = new Customer("胖大海",'男',18,"17608294174","12345@gmail.com");
        customerList.addCustomer(custs);
    }

    //显示菜单
    public void enterMainMenu(){
        boolean flag = true;
        do {
            System.out.println("-----------------------客户信息管理软件-----------------------");
            System.out.println("                        1 添加客户");
            System.out.println("                        2 修改客户");
            System.out.println("                        3 删除客户");
            System.out.println("                        4 查看客户");
            System.out.println("                        5 退出");
            System.out.print("               请输入1~5：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':{
                    this.addNewCustomer();
                    break;
                }
                case '2':{
                    this.modifyCustomer();
                    break;
                }
                case '3':{
                    this.deleteCustomer();
                    break;
                }
                case '4':{
                    this.listAllCustomers();
                    break;
                }
                case '5':{
                    System.out.print("是否退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        flag = false;
                    }
                }
            }
        }while (flag);

    }

    //添加客户
    private void addNewCustomer(){
        System.out.println("---------------------------添加客户-------------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char gender = CMUtility.readChar();
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱:");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess == true){
            System.out.println("---------------------------添加完成！------------------------");
        }else {
            System.out.println("-----------------------目录已满，添加失败！-------------------");
        }
    }
    //修改客户
    private void modifyCustomer(){
        System.out.println("---------------------------修改客户-------------------------");
        //查找用户需要修改的数据
        Customer oldCustomer;
        int num;
        for (;;){
            System.out.print("请输入需要修改的客户编号（-1退出）：");
            num = CMUtility.readInt();
            if (num == -1){
                return;
            }
            oldCustomer = customerList.getCustomer(num - 1);
            if (oldCustomer == null){
                System.out.println("无法找到指定客户！");
            } else {
                //找到指定客户借结束循环
                break;
            }
        }
        //修改客户信息
        System.out.println("请输入新的客户信息：");
        System.out.print("姓名（" + oldCustomer.getName() + "）:");
        String name = CMUtility.readString(10,oldCustomer.getName());
        System.out.print("性别（" + oldCustomer.getGender() + "）:");
        char gender = CMUtility.readChar(oldCustomer.getGender());
        System.out.print("年龄（" + oldCustomer.getAge() + "）:");
        int age = CMUtility.readInt(oldCustomer.getAge());
        System.out.print("电话（" + oldCustomer.getPhone() + "）:");
        String phone = CMUtility.readString(13,oldCustomer.getPhone());
        System.out.print("邮箱（" + oldCustomer.getEmail() + "）:");
        String email = CMUtility.readString(30,oldCustomer.getEmail());
        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.replaceCustomer(num - 1, newCustomer);
        if (isSuccess == true){
            System.out.println("---------------------------修改完成！------------------------");
        }else {
            System.out.println("---------------------------修改失败！------------------------");
        }
    }
    //删除客户
    private void deleteCustomer(){
        System.out.println("---------------------------删除客户-------------------------");
        Customer oldCustomer;
        int num;
        //查找用户需要删除的客户
        for (;;) {
            System.out.print("请输入需要删除的客户编号（-1退出）：");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            oldCustomer = customerList.getCustomer(num - 1);
            if (oldCustomer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                //找到指定客户借结束循环
                break;
            }
        }
        //删除指定用户
        System.out.print("是否确认删除（Y/N）:");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            boolean isSuccess = customerList.deleteCustomer(num - 1);
            if (isSuccess == true){
                System.out.println("---------------------------删除完成！------------------------");
            }else {
                System.out.println("---------------------------删除失败！------------------------");
            }
        }else {
            return;
        }
    }
    //查看客户
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表-------------------------");
        int total = customerList.getTotal();
        if (total == 0){
            System.out.println("没有客户记录！");
        }else {
            System.out.println("编号\t" + "姓名\t" + "性别\t" +  "年龄\t" + "电话\t\t" + "邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < total; i++){
                System.out.println(i+1 +"\t\t" + custs[i].toString());
            }
        }
        System.out.println("-------------------------客户列表完成------------------------");
    }
    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
