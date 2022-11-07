package com.xiaoer.project.project3_team.view;

import com.xiaoer.project.project3_team.doman.Employee;
import com.xiaoer.project.project3_team.service.NameListService;
import com.xiaoer.project.project3_team.service.TeamException;
import com.xiaoer.project.project3_team.service.TeamService;
import com.xiaoer.project.project3_team.utility.TSUtility;

public class TeamView {
    private NameListService namelistService = new NameListService();
    private TeamService teamService = new TeamService();

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    /**
     * 主界面显示及控制方法。
     */
    public void enterMainMenu() {
        for (; ; ) {
            System.out.println("----------------------------团队成员调度系统----------------------------");
            listAllEmployees();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                            1.查看团队成员");
            System.out.println("                            2.添加团队成员");
            System.out.println("                            3.删除团队成员");
            System.out.println("                            4.退出");
            System.out.print("            请选择（1~4）：");

            char c = TSUtility.readMenuSelaction();
            switch (c) {
                case '1': {
                    getTeam();
                    break;
                }
                case '2': {
                    addMember();
                    break;
                }
                case '3': {
                    deleteMember();
                    break;
                }
                case '4': {
                    System.out.print("是否退出（Y/N）:");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        return;
                    }
                    break;
                }
            }
        }
    }

    //显示所有的员工信息
    private void listAllEmployees() {
        System.out.println("ID\t名 字\t年龄\t薪 资\t职 位\t状 态\t奖 金\t股 票\t设 备");
        Employee[] allEmployees = namelistService.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++){
            System.out.println(allEmployees[i]);
        }

    }

    //查寻团队所有员工
    private void getTeam() {
        System.out.println("-------------------------------团队成员-------------------------------");
        if(teamService.getTotal() <= 0){
            System.out.println("该团队还没员工");
        }else{
            System.out.println("TID/ID\t名 字\t年龄\t薪 资\t职 位\t奖 金\t股 票");
            for (int i = 0; i < teamService.getTeam().length; i++ ){
                String str = String.valueOf(teamService.getTeam()[i].getMemberId()) ;
                System.out.println(str + " / " + teamService.getTeam()[i].gerDetailsFromTeam());
            }
        }
        System.out.println("---------------------------------------------------------------------");
        TSUtility.readReturn();

    }

    //添加团队成员
    private void addMember() {
        System.out.println("-----------------------------添加团队成员-----------------------------");
        System.out.print("请输入需要添加的员工id：");
        int employeeId = TSUtility.readInt();
        Employee employee = null;
        try {
            employee = namelistService.getEmployee(employeeId);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        try {
            teamService.addMember(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------添加成功！------------------------------");
        TSUtility.readReturn();
    }

    //删除团队成员
    private void deleteMember() {
        System.out.println("-----------------------------删除团队成员-----------------------------");
        System.out.print("请输入需要删除的员工TId：");
        int employeeYTId = TSUtility.readInt();
        System.out.print("是否删除（Y/N）:");
        char ifDelete = TSUtility.readConfirmSelection();
        if(ifDelete == 'N'){
            return;
        }else{
            try {
                teamService.removeMember(employeeYTId);
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("------------------------------删除成功！------------------------------");
        TSUtility.readReturn();
    }
}