package com.atxiao2._03_collection_framework._01_collection_test;

import org.junit.Test;

import java.util.*;

/**
 * @author : XiaoEr
 * @date : 2022/8/6
 *  |----Collection接口：单序列集合，用来存储一个一个的对象
 *      |----Set接口：存储无序的、不可重复的数据 （数学里的集合）
 *          |----HashSet 作为Set接口的主要实现类；线程不安全的；可以存储null值 （无序，重写hashCode（），不可重复，重写equals（））
 *              |----LinkHashSet 作为hHashSet的子类，在遍历内部数据时，可以按照添加的顺序遍历（看似有序的），
 *                                 对于频繁的遍历操作LinkedHashSet的效率要高于HashSet
 *          |----TreeSet 可以按照添加的对象的指定属性进行排序（底层为红黑树），只能存储相同类型对象
 *
 *
 *  Set 接口：存储无序的、不可重复的数据 （数学里的集合）
 *
 *              无序的：无序不等于随机性，指的是set存储数据在底层数组中时不是通过数组索引顺序添加，而是通过hashCode来判断数组中的存储位置
 *              不可重复的：set会通过判断hashCode值和 equals()来判断，如果重复则存储失败
 *
 *      set没有定义额外新的方法，用的都是collection接口中定义的方法
 *      向set中添加，数据所在的类一定要重写hashCode()和equals()，并尽可能保持一致性：相等的对象必须具有相等的散列码
 *      在重写equals（）和 hashCode（）时 在equals（）中比较的filed 都应该参与hashCode（）的计算
 */
public class SetTest {

    /**
     * HashSet: 作为Set接口的主要实现类；线程不安全的；可以存储null值
     *      **底层存储采用的 数组+链表 的结构
     *
     *     存储逻辑：添加元素会先通过元素的hash值进行计算找到存放位置，该位置没元素就存储，有值就判断哈希值是否相同，
     *             相同则通过equals（）判断属性值是否相同，若不相同则在该位置通过链式存储（JDK8插在链表尾部），相同则存储失败（保证相同元素只能添加一个）
     *       （判断hash值的过程类似于布隆过滤器，我算出来你不同就一定不相同，我算出你相同，不一定相同，还得通过equals（）方法进一步判断）
     *
     *  HashSet底层还是使用的HashMap，只不过只用了 key来存放HashSet的值，value则存储的是一个 Object的静态常量对象
     */
    @Test
    public void test01() {
        Set hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add(new Person("wang", 18));
        hashSet.add(new Person("wang", 18));
        hashSet.add(new Person("wang", 17));
        hashSet.add("abc");

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * linkedHashSet： 在遍历内部数据时，可以按照添加的顺序遍历（看似有序的）
     *          在HashSet的基础上加入双向链表，在添加的数据的同时还维护了两个引用（前驱后继节点）记录此数据前一个数据和后一个数据
     *          对于频繁的遍历操作LinkedHashSet的效率要高于HashSet
     *
     */
    @Test
    public void test02() {
        Set linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(456);
        linkedHashSet.add(new Person("wang", 18));
        linkedHashSet.add(new Person("wang", 18));
        linkedHashSet.add(new Person("wang", 17));
        linkedHashSet.add("abc");

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * TreeSet: 可以按照添加的对象的指定属性进行排序（底层为红黑树）只能存储相同类型对象
     *      在TreeSet当中判断是否相同的标准不在时hashCode() + equals() 而是 hashCode() + compareTo()/compare()
     *              (自然排序是实现Comparable接口 用的 compareTo() ,定制排序用的 Comparator接口实现类，用的 compare())
     */
    @Test
    public void test03() {
        Set treeSet = new TreeSet();

        //报错，不能存储不同类型的对象
        // treeSet.add(123);
        // treeSet.add(new Person("wang", 18));

        //tree会自动将存入的数据进行排序
        treeSet.add(11);
        treeSet.add(32);
        treeSet.add(-1);
        treeSet.add(25);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * TreeSet 存入自定义对象 自然排序
     *      使用comparable接口
     *    按照名字从大到小排序，名字相同则年龄从大到小
     */
    @Test
    public void test04() {

        Set treeSet = new TreeSet();
        //如果没有定义比较方式，TreeSet会不知道怎么排序报错
        treeSet.add(new Person("xie", 18));
        treeSet.add(new Person("li", 20));
        treeSet.add(new Person("li", 19));
        treeSet.add(new Person("zhao", 30));
        treeSet.add(new Person("mu", 80));
        treeSet.add(new Person("liu", 11));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    /**
     * TreeSet 存入自定义对象 定制排序
     *      使用Comparator接口的实现类,将其对象传入TreeSet构造器中
     *    按照名字从小到大排序，名字相同则年龄从大到小
     */
    @Test
    public void test05() {

        Comparator personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i == 0){
                    return Integer.compare(o1.getAge(),o2.getAge());
                }
                return -i;
            }
        };

        Set treeSet = new TreeSet(personComparator);
        //如果没有定义比较方式，TreeSet会不知道怎么排序报错
        treeSet.add(new Person("xie", 18));
        treeSet.add(new Person("li", 20));
        treeSet.add(new Person("li", 19));
        treeSet.add(new Person("zhao", 30));
        treeSet.add(new Person("mu", 80));
        treeSet.add(new Person("liu", 11));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //Set练习，观看代码模拟结果
    @Test
    public void test06(){
        Set<Person> peopleSet = new HashSet<>();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);
        peopleSet.add(p1);
        peopleSet.add(p2);
        System.out.println(peopleSet); // （AA，1001） （BB，1002）

        p1.setName("CC");
        peopleSet.remove(p1); //属性被修改->此时的p1hashCode改变，原本的hashCode没变，移除失败
        System.out.println(peopleSet); // （AA，1001）（BB，1002）

        peopleSet.add(new Person("CC", 1001)); //原本p1的hashCode没变，判断为不相同添加成功
        System.out.println(peopleSet); // （CC，1001）（BB，1002）（CC，1001）

        peopleSet.add(new Person("AA", 1001)); // 与原本的p1值相同 hashCode值相同，会存放在同一个位置，但通过equals()比较值不相同，存入成功
        System.out.println(peopleSet); //（CC，1001）（BB，1002）（CC，1001）(AA, 1001)


    }

}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    /**
     * 将参与运算的值，混合再运算形成新的哈希值
     * @return 新的哈希值
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0; //获取name的哈希值
        result = 31 * result + age; //将name的哈希值膨胀31倍，加上age值，形成新的hashCode
        return result;
    }

    //按照name从大到小排序，如果名字相同则比较age大小(若想顺序颠倒则取反)
    @Override
    public int compareTo(Person o) {
        int i = this.name.compareTo(o.name);
        if (i == 0) {
            return Integer.compare(this.age,o.age);
        }
        return i;
    }
}
