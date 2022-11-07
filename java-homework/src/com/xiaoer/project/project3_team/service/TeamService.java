package com.xiaoer.project.project3_team.service;

import com.xiaoer.project.project3_team.doman.Architect;
import com.xiaoer.project.project3_team.doman.Designer;
import com.xiaoer.project.project3_team.doman.Employee;
import com.xiaoer.project.project3_team.doman.Programmer;

/**
 * 关于团队成员的管理（增删改查）
 */
public class TeamService {
    private static int counter = 1; //新增成员自动生成团队中的唯一ID
    private final int MAX_MEMBER = 5;  //开发团队最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER]; //存放团队中成员的对象
    private int total = 0; //团队成员的实际人数
    private int memberId = 0;

    public TeamService() {
    }

    public int getTotal() {
        return total;
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < team.length; i++ ){
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 添加员工
     * @param e 将要添加员工的对象
     * @throws TeamException 添加失败的异常
     */
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加(包括普通员工”高胖“)
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，不配加入该团队");
        }
        //该员工已在本开发团队中
        if (isExist(e)){
            throw new TeamException("该员工已在团队中，无需添加");
        }
        //该员工已是某团队成员，或者该员正在休假，无法添加
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus())){
            throw new TeamException("该成员已有团队，无法加入");
        }else if("VOCATION".equals(p.getStatus())){
            throw new TeamException("该员工在休假，放假是不可能工作滴，这辈子都不可能滴");
        }
        //团队中至多只能有一名架构师，两名设计师，三名程序员
            //获取团队中员工类型的人数
        int numOfP = 0, numOfA = 0, numOfD = 0;
        for (int i = 0; i < total; i++){
            if(team[i] instanceof Architect){
                numOfA ++;
            }else if(team[i] instanceof Designer){
                numOfD ++;
            }else {
                numOfP ++;
            }
        }
        if (e instanceof Architect){
            if(numOfA >= 1 ){
                throw new TeamException("团队中已有一名架构师，无法添加");
            }
        }else if (e instanceof Designer ){
            if (numOfD >= 2){
                throw new TeamException("团队中已有两名设计师，无法添加");
            }
        } else if (e instanceof Programmer){
            if (numOfP >= 3){
                throw new TeamException("团队中已有三名程序猿，无法添加");
            }
        }


        //将需要添加的员工（p/e），加入团队中（team）
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * 根据团队id删除成员
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        //找到团队员工
        for(; i < total; i++){
            if(team[i].getMemberId() == memberId);
            team[i].setStatus(Status.FREE);
            team[i].setMemberId(0);
            break;
        }
        if (i == total){
            throw new TeamException("没找到该员工，删除失败");
        }
        //删除该员工
        for(int j = i; j < total - 1; j++){
            team[j] = team[j + 1];
        }
        /* 写法1 ：team[total - 1] = null;
         total--;*/
        team[--total] = null;

    }

    //比较团队中员工的id和添加员工的id是否一样
    public boolean isExist(Employee e){
         for (int i = 0; i < total; i++){
             if (e.getId() == team[i].getId()){
                 return true;
             }
         }
         return false;
    }
}
