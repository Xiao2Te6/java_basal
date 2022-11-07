package com.atxiao2._02_common_class._03_compare_test.comparable_test;

public class Goods implements Comparable{

    private String name;
    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * @param o 将要被比较的对象
     * @return  正大，负小 ，零相等
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            if (this.getPrice() > goods.getPrice()){
                return 1;
            }else if(this.getPrice() < goods.getPrice()){
                return -1;
            }else{
                // return 0;
                return this.getName().compareTo(goods.getName());//调用String中的compareTo方法比较商品名称
            }
        }
        throw new RuntimeException("传入数据类型不一致");

        //方法二
        // return Double.compare(this.getPrice() , goods.getPrice());
    }
}
