package com.xiaoer.project.project3_team.utility;

import com.xiaoer.project.project3_team.doman.Employee;
import com.xiaoer.project.project3_team.service.NameListService;
import com.xiaoer.project.project3_team.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployees(){
        NameListService service = new NameListService();

        try {
            System.out.println(service.getEmployee(2));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
