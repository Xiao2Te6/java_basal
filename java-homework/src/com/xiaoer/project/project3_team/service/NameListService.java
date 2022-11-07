package com.xiaoer.project.project3_team.service;

import com.xiaoer.project.project3_team.doman.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 */
public class NameListService {

    private Employee[] employees; //包含所有员工对象的数组

    /**
     * 给employee数组及数组元素进行初始化
     */
    public NameListService() {
        //动态初始化数组
        employees = new Employee[Data.EMPLOYEES.length];
        //构建元素对象，并赋值
        for (int i = 0; i < employees.length; i++){
            //获取员工类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            //从Date类中获取员工相同属性值
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            switch(type){
                case Data.EMPLOYEE:{ //10
                    //创建员工对象并将所有属性赋值
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                }
                case Data.PROGRAMMER:{ //11
                    Equipment equipment = cteatsEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary,equipment);
                    break;
                }
                case Data.DESIGNER:{ //12
                    Equipment equipment = cteatsEquipment(i);
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary,equipment,bonus);
                    break;
                }
                case Data.ARCHITECT:{ //13
                    Equipment equipment = cteatsEquipment(i);
                    double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary,equipment,bonus,stock);
                    break;
                }
            }

        }
    }

    /**
     * 根据不同的员工所用设备创建不同的设备对象
     * @param typeId 员工对应的设备索引
     * @return 创建设备对象
     */
    private Equipment cteatsEquipment(int typeId) {
        //获取对应设备id
        int eqType = Integer.parseInt(Data.EQUIPMENTS[typeId][0]);
        String model = Data.EQUIPMENTS[typeId][1];
            switch(eqType){
                case Data.PC:{ //21
                    String display = Data.EQUIPMENTS[typeId][2];
                    Equipment pc = new PC(model,display);
                    return pc;
                }
                case Data.NOTEBOOK:{ //22
                    double price = Double.parseDouble(Data.EQUIPMENTS[typeId][2]);
                    Equipment notebook = new NoteBook(model,price);
                    return notebook;
                }
                case Data.PRINTER:{ //23
                    String type = Data.EQUIPMENTS[typeId][2];
                    Equipment printer = new Printer(model,type);
                    return printer;
                }

            }
            return null;
    }


    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++){
             if (employees[i].getId() == id){
                 return employees[i];
             }
        }
        throw new TeamException("找不到指定的员工！");
    }
}
