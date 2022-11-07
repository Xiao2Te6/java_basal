package com.atxiao2._08_java8_new_features._05_optional;

/**
 * @author : XiaoEr
 * @date : 2022/11/5
 */
public class Boy {

    private Girl girlfriend;

    public Boy() {
    }

    public Boy(Girl girlfriend) {
        this.girlfriend = girlfriend;
    }

    public Girl getGirlfriend() {
        return girlfriend;
    }

    public void setGirlfriend(Girl girlfriend) {
        this.girlfriend = girlfriend;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girlfriend=" + girlfriend +
                '}';
    }
}
