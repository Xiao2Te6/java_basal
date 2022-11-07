package com.atxiao2._08_java8_new_features._05_optional;

/**
 * @author : XiaoEr
 * @date : 2022/11/5
 */
public class Girl {

    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
