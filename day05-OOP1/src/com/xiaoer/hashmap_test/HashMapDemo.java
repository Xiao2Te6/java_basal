package com.xiaoer.hashmap_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMapDemo.HashTest();
    }
    public static void HashTest(){
        HashMap<String, String> map = new HashMap<>();
        // 增
        map.put("高胖","sb");
        map.put("胖大海","煞笔");
        map.put("高贵妃","心机婊");
        map.put("高兴不","翔");
        System.out.println(map);
        // 删
        map.remove("高兴不");
        System.out.println(map);
        // 改
        map.put("高胖","傻逼");
        System.out.println(map);
        // 查
        System.out.println(map.get("高贵妃"));
        System.out.println(map.size());
//        map.clear();
//        System.out.println(map);

        //遍历
        // 方式一获取key集合
        Set<String> keyset = map.keySet();
        for (String key : keyset){
            System.out.println(key + " --> " + map.get(key));
        }
        System.out.println();
        //方式二获取entry集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String,String> entry : entries){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        //统计字符串中每个字符出现的次数
        String strArr = "ABABCABFGEBDDDASDBS";
        System.out.println(strArr);
        //切割成单个字符数组
        String[] strs = strArr.split("");
        System.out.println("strs = " + Arrays.toString(strs));
        //创建hash集合存放统计数据
        HashMap<String, Integer> counts = new HashMap<String,Integer>();
        for (String str : strs){
            if (counts.get(str) == null){
                counts.put(str,1);
            }else {
                Integer count = counts.get(str);
                counts.put(str,count + 1);
            }
        }
        System.out.println("counts = " + counts);

    }

}
