package com.xiaoer.genneric_test1;

public interface IServiceable
{
    void insert(Person person);
    void delete(String sn);
    void update(Person person);
    Person select(String sn);
}
