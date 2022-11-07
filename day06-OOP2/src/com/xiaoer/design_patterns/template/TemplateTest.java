package com.xiaoer.design_patterns.template;
/**
 * 模板方法的设计模式
 */
public class TemplateTest {
    public static void main(String[] args) {
        SubTemplate subTemplate = new SubTemplate();
        subTemplate.speedTime();

    }
}
abstract class Template{
    //测试代码运行速度(模板方法，一般不能让子类重写)
    public final void speedTime(){
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();

        System.out.println("用时" + (end - start));
    }
    //将固定的写在方法里面，不固定的变成抽象方法让子类完成
    public abstract void code();
}

class SubTemplate extends Template{
    //测试：求1000以内质数个数
    @Override
    public void code() {
        label: for (int i = 2;i <= 1000; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    continue label;
                }
            }
            System.out.println(i);
        }
    }

}
