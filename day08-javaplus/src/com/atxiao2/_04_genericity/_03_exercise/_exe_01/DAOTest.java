package com.atxiao2._04_genericity._03_exercise._exe_01;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001",new User("小红", 18));
        userDAO.save("002",new User("小明", 19));
        userDAO.save("003",new User("小红", 20));

        System.out.println("001 -> " + userDAO.get("001"));

        userDAO.update("003",new User("小黑",33));

        userDAO.list().forEach(System.out::println);
        System.out.println("-----------------------");
        userDAO.delete("003");
        userDAO.list().forEach(System.out::println);
    }
}
