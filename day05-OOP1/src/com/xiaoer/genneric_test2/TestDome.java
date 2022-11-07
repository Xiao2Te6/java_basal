package com.xiaoer.genneric_test2;

import java.util.List;

public class TestDome {
    public static void main(String[] args) {
        Department hr = new Department();
        hr.setDeptName("人事部");
        //添加部门员工
        hr.getEmps().add(new Employee("小斌", 18));
        hr.getEmps().add(new Employee("地雷", 17));
        hr.getEmps().add(new Employee("吉吉", 56));
        System.out.println(hr.getEmps());

        //员工人数
        System.out.println("该部门有" + hr.getEmps().size() + "人");

//        List<Employee> emps = hr.getEmps();
//        System.out.println(emps.get(0).getName());

        //求出年龄最小的员工
        int index = 0;
        Employee emp = (Employee) hr.getEmps().get(0);
        int ageMin = emp.getAge();

        for (int i = 0; i < hr.getEmps().size(); i++){
            Employee employee = (Employee) hr.getEmps().get(i);
            if (employee.getAge() < ageMin ){
                ageMin = employee.getAge();
                index = i;
            }
        }
        Employee minAgeEmp = (Employee) hr.getEmps().get(index);
        System.out.println(minAgeEmp.getName() + "是最小的员工,年龄为" + minAgeEmp.getAge());

        //删除集合中 姓名 叫吉吉的员工
//        int index1 = -1;
        String remove = "吉吉";
        for (int i = 0; i < hr.getEmps().size(); i++){
            Employee employee = (Employee) hr.getEmps().get(i);
            if (employee.getName().equals(remove)){
                hr.getEmps().remove(i);
                break;
            }
        }

        System.out.println(hr);

    }
}
