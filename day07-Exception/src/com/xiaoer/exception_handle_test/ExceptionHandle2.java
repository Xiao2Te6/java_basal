package com.xiaoer.exception_handle_test;

/**
 * 手动抛出异常
 */
public class ExceptionHandle2 {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.setAge(0);
            System.out.println(student.age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Student{
    int age;

    public void setAge(int age) throws Exception {
       if (age > 0){
           this.age = age;
       }else {
           //手动抛出异常（1.抛出运行时异常）
//            throw new RuntimeException("年龄小了");
           //(抛出异常)
            throw new Exception("数据小了");
       }
    }
}