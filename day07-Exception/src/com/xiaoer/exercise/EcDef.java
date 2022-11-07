package com.xiaoer.exercise;

/**
 * 自定义异常类
 *      1.需要一个独有的uid
 *      2.需要两个构造器（一个空参，一个带msg参数）
 */
public class EcDef extends Exception{
    static final long serialVersionUID = -33993124229948L;

    public EcDef() {
    }
    public EcDef(String msg) {
        super(msg);
    }
}
