package com.xiaoer.exercise;

public class EcmDef {
    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);

        try {
            System.out.println(ecm(i, j));
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("输入格式有问题");
        }catch (IndexOutOfBoundsException e){
            System.out.println("输入参数有问题");
        }catch (ArithmeticException e){
            System.out.println("分母不能为0");
        }
    }

    public static int ecm(int i, int j) throws EcDef {
        if(i < 0 || j < 0){
            throw new EcDef("请输入一个正数");
        }else{
            return i  / j;
        }
    }
}
