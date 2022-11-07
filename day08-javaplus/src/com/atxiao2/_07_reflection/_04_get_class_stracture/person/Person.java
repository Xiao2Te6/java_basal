package com.atxiao2._07_reflection._04_get_class_stracture.person;


/**
 * @author : XiaoEr
 * @date : 2022/10/31
 *
 * 拥有各种结构的person类
 */
@MyAnnotation(value = "hi class")
public class Person extends Animal<String> implements Comparable<String>,IShow{
    @MyAnnotation("hi filed")
    public String name;
    private int age;
    String hobbies;

    public Person() {
    }

    public Person(String name, int age, String hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @MyAnnotation
    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public void show() {
        System.out.println("我叫" + name + "今年" + age + "岁了。");
    }

    private String show(String say) throws NumberFormatException {
        System.out.println("我叫" + name + "今年" + age + "岁了。");
        return "" + name + age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static String say(){
        System.out.println("你好");
        return "hello";
    }
}
