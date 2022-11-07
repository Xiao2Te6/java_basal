package com.atxiao2._03_collection_framework._02_map_test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author : XiaoEr
 * @date : 2022/8/8
 *
 * Map框架组成
 *   |----Map接口：双列集合，用来存储一对、一对（key,vale）的数据  (高中函数 y = f(x), key是对value的一个映射，  key只有一个)
 *           |----HashMap 作为map的主要实现类，线程不安全的，效率高，可以存储key或value为null的值
 *               |----LinkedHashMap 在HashMap上添加了双向链表（在linkedHashMap中使用的Entry，该Entry继承了HashMap的Node，并添加了一对引用 before和after），
 *                                  在遍历map元素时，可以按照添加的顺序遍历，在频繁遍历时，LinkedHashMap的执行效率高于HashMap
 *           |----TreeMap 保证按照key-value键值对进行排序，实现排序遍历，
 *                        此时考虑key 的定制排序或自然排序，底层使用红黑树（排序二叉树中的一种特殊结构）
 *           |----Hashtable 作为Map接口的古老实现类（JDk1.0），线程安全，效率低，不可以存储key或value为null的值（会报空指针异常）
 *               |----Properties 常用来处理配置文件，key和value都是String类型
 *
 *  1.HashMap 底层原理？
 *  2.HashMap 与 Hashtable 的异同？
 *  3.currentHashMap 与 Hashtable异同？
 *
 * Map结构理解
 *      Map中的一对key-value键值对构成一个Entry，Entry是无序的、不可重复的，使用Set存储Entry
 *      如果单看Map中的key：无序的、不可重复的，使用Set存储所有的key ->需要重写Key中hashCode()和equals()
 *          但看Map中的value：无序的、可重复的，使用Collection存储所有的value
 *
 */
public class MapTest{

    /**
     * HashMap: 作为map的主要实现类，线程不安全的，效率高，可以存储key或value为null的值
     *       底层：数组 + 链表（JDK7之前）
     *            数组 + 链表 + 红黑树（JDK8之后)
     *    要保证HashMap中的key无序、不可重复，需要重写key所在类的hashCode（）和eq
     *
     * 底层存储原理：
     *      jdk7中
     *      在实例化后底层会创建一个长度为16的Entry[] table（如果使用构造器创建对象时指定底层长度，不满16会是16，超过是16会是比指定数大的2^n）
     *      然后再put（myKey,myValue）时会将myKey的哈希值进行运算得出在数组中的存储位置，判断该位置是否为空，为空就调用添加方法addEntry()
     *      如果不为空（有一个或链式存储的多个元素），则一一比较这些元素中key和myKey的哈希值是否相等和通过equals(）比较两个key是否相等，
     *      如果都相等就直接替换相等元素的value为myValue，如果有一不相等则调用添加方法addEntry()，
     *      addEntry()会先根据需要扩容（数组size>临界值且当前位置不为空），然后将当前元素插在链表的头部，将当前位置的元素放在插入entry的next中
     *
     *
     *      jdk8中
     *      在添加put(myKey,myValue)时首先会判断地城数组table是否为null，为null则会创建长度为16的Node[]类型的数组，再调用key的哈希值进行运算（将hash值与数组长度进行&运算结果大小不会超过当前容量），找到在Node[] table 中的存放位置，
     *      如果该位置为空，就直接存放，myKey-myValue添加成功，如果该位置不为空（有一个或链式存储的多个元素），则一一比较这些元素中key和myKey的哈希值是否相等和通过equals(）比较两个key是否相等，如果都相等，就替换当前元素e中的value为myValue，
     *      如果所有元素都有一不相等，该位置的链表最后存放该值的Node，myKey-myValue添加成功。
     *
     *  当添加超过数组临界值的时候底层数组就会进行扩容，默认大小为2倍，并将HashMap中的元素复制过来并重新计算存放位置
     *
     *  JDK8相较于JDK7底层实现方式不同：
     *   1.JDK8 底层的数组时Node[] 类型 而非 Entry[]类型，Node 实现了 Map中的Entry接口
     *   2.在对象实例化的时候底层没有创建长度为16的数组，在首次调用put()方法时候才创建底层数组
     *   3.JDK8 底层用的 数组 + 链表 + 红黑树
     *      当数组某一个索引元素以链表形式存在的个数  > 8 且当前数组长度 > 64 时，此时索引位置上的所有数据改为使用红黑树存储，如果数组长度 < 64 则扩容。
     *
     *  DEFAULT_INITIAL_CAPACITY 默认容量 16
     *  DEFAULT_LOAD_FACTOR 默认加载引子 0.75
     *  threshold 扩容临界值（阈值）, = 容量*加载因子
     *  TREEIFY_THRESHOLD: 链表长度阈值 8
     *  MIN_TREEIFY_CAPACITY: 桶中Node被转成树时最小的hash表容量 64
     *
     *
     * 常用方法
     *      put(Object key, Object value) 添加或修改（传入的key已经存在）
     *      putAll(Map map) 将map中的所有数据添加到当前map中
     *      remove(Object key) 删除Map中key对应的键值对
     *      clear() 清空map
     *
     *      get(Object key) 获取指定key对应的value
     *      containsKey() 判断当前map是否包含指定key
     *      containsValue() 判断当前map是否包含指定value
     *      size()  返回当前map中 entry（key-value键值对）个数
     *      isEmpty() 判断当前map是否为空
     *      equals(Object obj) 判断当前map是否和obj相等
     *
     *      Set keySet() 返回map中所有key的set集合
     *      Collection values() 返回map中所有的value的Collection集合
     *      Set entrySet() 返回map中所有entry（key-value键值对）的set集合
     */
    @Test
    public void hashMapTest(){
        Map hashMap = new HashMap();
        System.out.println("------------------常规操作-------------------");
        //添加
        hashMap.put(1,"a");
        hashMap.put(2,"b");
        hashMap.put(3,"c");
        //修改
        hashMap.put(3,"cc");
        System.out.println("hashMap = " + hashMap);

        //putAll()
        Map hashMap02 = new HashMap();
        hashMap02.put("bb",4);
        hashMap02.put("cc",5);

        hashMap.putAll(hashMap02);
        System.out.println("hashMap = " + hashMap);

        //删除
        Object cc = hashMap.remove("cc");
        System.out.println("value = " + cc);
        System.out.println("hashMap = " + hashMap);

        //清空
        hashMap02.clear();
        System.out.println("hashMap02.size()" + hashMap02.size());
        System.out.println("-----------------元素操作-----------------------");

        //get()
        Object o = hashMap.get(1);
        System.out.println("get(1) ---> " + o);

        //containsKey()
        System.out.println("containsKey(1) ---> " +hashMap.containsKey(1));
        System.out.println("containsKey(7) ---> " + hashMap.containsKey(7));

        //containsValue()
        System.out.println("containsValue(1) ---> " +hashMap.containsValue(1));
        System.out.println("containsValue(4) ---> " + hashMap.containsValue(4));

        //size()
        System.out.println("size() --> " + hashMap.size());

        //isEmpty()
        System.out.println("isEmpty() --> " + hashMap02.isEmpty());

        //equals()
        System.out.println("equals() --> " + hashMap.equals(hashMap02));

        System.out.println("-----------------元视图操作-----------------------");
        //通过key遍历
        Iterator keyIterator = hashMap.keySet().iterator();
        while (keyIterator.hasNext()){
            Object next = keyIterator.next();
            System.out.println(next + "-->" + hashMap.get(next));
        }
        System.out.println("------------------");

        //遍历value
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println("value = " + value);;
        }
        System.out.println("------------------");

        //遍历entry
        Set set = hashMap.entrySet();
        for (Object entry : set) {
            // System.out.println(entry);
            Map.Entry entry1 = (HashMap.Entry) entry;
            System.out.println(entry1.getKey() + "-->" + entry1.getValue());
        }
    }

    /**
     * linkedHashMap :在HashMap上添加了双向链表（在linkedHashMap中使用的Entry，该Entry继承了HashMap的Node，并添加了一对引用 before和after），
     *                在遍历map元素时，可以按照添加的顺序遍历，在频繁遍历时，LinkedHashMap的执行效率高于HashMap
     *
     *   linkedHashMap 重写了 HashMao中的 newNode()方法， 并且LinkedHashMap中使用的是Entry，
     *      该Entry继承了HashMap中的Node并添加了 before和after两个引用用来记录前一个添加的节点和后一个添加的节点
     */
    @Test
    public void linkedHashMapTest() {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"a");
        linkedHashMap.put(2,"b");
        linkedHashMap.put(3,"c");
        System.out.println("linkedHashMap = " + linkedHashMap);
    }

    /**
     * TreeMap 保证按照key-value键值对进行排序，实现排序遍历，
     *       此时考虑key 的定制排序或自然排序，底层使用红黑树（排序二叉树中的一种特殊结构）
     */
    @Test
    public void treeMapTest() {
        //定制排序
        Comparator<Person> comparator = new Comparator<>() {
            @Override
            public int compare(Person p1, Person p2) {
                //按照名字从小到达排
                int i = p1.getName().compareTo(p2.getName());
                if(i == 0){
                    //再按照年龄从大到小
                    return -Integer.compare(p1.getAge(), p2.getAge());
                }
                return i;
            }
        };

        Map<Person, String> treeMap = new TreeMap<>(comparator);

        // Map<Person, String> treeMap = new TreeMap<>();
        treeMap.put(new Person("wang",18),"1001");
        treeMap.put(new Person("li",23),"1002");
        treeMap.put(new Person("liu",20),"1003");
        treeMap.put(new Person("zhou",22),"1004");
        treeMap.put(new Person("zhao",88),"1005");
        treeMap.put(new Person("zhao",77),"1005");

        Set<Map.Entry<Person, String>> entries = treeMap.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            System.out.println(entry);
        }
    }

    /**
     * Properties 常用来处理配置文件，key和value都是String类型
     */
    @Test
    public void propertiesTest(){
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("resouce/properties_test.properties");
            properties.load(fileInputStream);//加载文件
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println("name = " + name + ", password = " + password);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

