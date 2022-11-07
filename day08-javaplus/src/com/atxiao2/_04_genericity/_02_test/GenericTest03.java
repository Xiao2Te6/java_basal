package com.atxiao2._04_genericity._02_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 *
 * 泛型类在继承反面分体现
 *  如果类A时类B的父类，G<A>,G<B>不具备父子关系，二者是并列关系
 *         A<G> 和 B<G>构成子父类关系
 *
 * 通配符的使用
 *    通配符：？
 *      G<A>,G<B>不具备父子关系，二者是并列关系，但二者共同的父类可以是是 G<?>
 *      对于List<?> 就不能再向其内部添加数据，null除外，但允许读取，类型为Object
 *
 *     有限制条件的通配符的使用
 *         <？ extends A>: 通配符？可以代表是  A 及其子类
 *         <？ super A> ： 通配符？可以是 A 及其父类
 */
public class GenericTest03 {
    //继承方面的体现
    @Test
    public void test01(){
        Object obj = null;
        String str = null;

        obj = str; //多态

        List<Object> listO = null;
        List<String> listS = null;

        // listO = listS;//不够成子父类关系，编译不通过

        show(listO);

        show1(listO);
        // show1(lisS);
        show2(listS);

        ArrayList<Object> list = null;
        obj = list; //多态
    }

    public <E> E show(List<E> l){
        return null;
    }
    //不能构成重载因为方法类型相同
    public void show1(List<Object> l){
    }

    public void show2(List<String> l){
    }

    //通配符的使用
    @Test
    public void test02(){

        List<Object> listO = null;
        List<String> listS = null;

        List<?> list = null;

        list = listO;
        list = listS;

        print(list);
        print(listO);
        print(listS);

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");

        list = list1;
        //对于List<?> 就不能再向其内部添加数据，null除外
        // list.add("dd");
        list.add(null);

        //但允许读取，类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }
    public void print(List<?> list){
        if (list == null){
            return;
        }
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test03(){
        //  ? <= Person
        List<? extends Person> list1 = null;
        //  ? >= Person
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        // 通配符？可以是 Person 及其子类
        list1 = list3;
        list1 = list4;
        // list1 = list5;

        // 通配符？可以是 Person 及其父类
        // list2 = list3;
        list2 = list4;
        list2 = list5;

        // ? extends Person可以使用Person获取
        Person person = list1.get(0);

        // ? super Person 可以添加Person类及其子类
        list2.add(new Person());
        list2.add(new Student());
    }

}
