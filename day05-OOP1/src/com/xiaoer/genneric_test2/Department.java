package com.xiaoer.genneric_test2;

import java.util.ArrayList;

public class Department
{
    private String deptName;
    private ArrayList emps = new ArrayList();

    public Department() {
    }

    public Department(String deptName, ArrayList emps) {
        this.deptName = deptName;
        this.emps = emps;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public ArrayList getEmps() {
        return emps;
    }

    public void setEmps(ArrayList emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
