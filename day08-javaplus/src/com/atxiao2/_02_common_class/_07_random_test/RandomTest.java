package com.atxiao2._02_common_class._07_random_test;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * @author : XiaoEr
 * @date : 2022/8/4
 *
 * 生成随机数的方式
 *        1.Math类中的random方法
 *        2.Random类
 *        3.UUID
 */
public class RandomTest {

    /**
     * 使用 Math类中的random方法生成随机数
     *          生成0到1之间的 double类型的随机数 [0,1)
     *    生成[a，b]之间的数，(int)Math.random() * (b-a +1) + a
     *
     *   返回值默认为 double
     */
    @Test
    public void test01(){
        System.out.println("random ->" + Math.random());

        //生成random[1,78]之间的随机数
        System.out.println("[1,78]之间的随机数 ：" + (int)(Math.random() * 78 + 1) );
    }

    /**
     * 使用 Random类生成随机数
     *    使用Random中的 nextDouble（）方法生成 [0,1)区间内的double类型的伪随机数
     */
    @Test
    public void test02(){
        Random random = new Random();

        System.out.println("random.nextInt() = " + random.nextInt()); //返回int取值返回中均匀分布的随机数

        System.out.println("random.nextDouble() = " + random.nextDouble()); //返回0到1之间的double随机数 [0,1)

    }

    /**
     * 使用UUID生成全球唯一的随机码
     *        不可变的通用唯一标识符
     *  组成
     *    1.当前的时间和日期。
     *    2.时钟序列。
     *    3.全局唯一的IEEE机器识别号码，若有网卡，从网卡的MAC地址获取，没有就别的方式获取。
     *
     * 常用静态方法 UUID.randomUUID()直接获取一个uuid
     */
    @Test
    public void test03(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid); //e735e5c0-79b9-4e37-ae3c-056e0b9efd93
    }
}
