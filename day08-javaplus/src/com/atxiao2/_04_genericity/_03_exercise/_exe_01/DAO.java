package com.atxiao2._04_genericity._03_exercise._exe_01;

import java.util.*;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 * DAO data(base) access object
 *
 * 需求：定义泛型类 DAO<T>,定义一个Map对象，键值为string，T，分别创建 增删改查方法
 *       定义一个user类包含int id, int age,String name
 *       创建test去测试
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }

    //获取map中所有的T对象
    public List<T> list(){
        Collection<T> values = map.values();
        List<T> arrayList = new ArrayList<>();
        Iterator<T> iterator = values.iterator();
        while(iterator.hasNext()){
            T next = iterator.next();
            arrayList.add(next);
        }

        return arrayList;
    }

    public void delete(String id){
        map.remove(id);
    }
}
