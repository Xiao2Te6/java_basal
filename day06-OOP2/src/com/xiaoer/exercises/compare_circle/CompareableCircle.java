package com.xiaoer.exercises.compare_circle;

public class CompareableCircle extends Circle implements ICompareable {

    public CompareableCircle(double redius) {
        super(redius);
    }

    @Override
    public double compareTo(Object o) {

        if (this == o ){
            return 0;
        }else if (o instanceof CompareableCircle){
            CompareableCircle c = (CompareableCircle)o;
            return this.getRedius() - c.getRedius();
//            //方式二(用Double封装类，调用Double中的compareTo方法)
//            Double redius;
//            return this.getRedius().compareTo(o);
        }else {
            throw new RuntimeException("传入数据不匹配");
        }
    }
}
