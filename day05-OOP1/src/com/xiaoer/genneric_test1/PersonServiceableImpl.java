package com.xiaoer.genneric_test1;

public class PersonServiceableImpl extends Person implements IServiceable {

    @Override
    public void insert(Person person) {
        System.out.println("插入数据到数据库");
    }

    @Override
    public void delete(String sn) {
        System.out.println("从数据库中删除数据");
    }

    @Override
    public void update(Person person) {
        System.out.println("更新数据库中的数据");
    }

    @Override
    public Person select(String sn) {
        System.out.println("查询数据");
        return null;
    }
}
