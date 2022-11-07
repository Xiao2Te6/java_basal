public class IfElseIfElseDemo3_05
{
    /*（1）定义一个变量days，表示天数
    （2）判断天数范围*/
    public static void main(String[] args) {
        int days = 6;

        if (days > 0 && days < 5){
            System.out.println("天数太少，继续加油哦！");
        }else if (days >= 5 && days < 12){
            System.out.println("你的qq等级为：⭐");
        }else if (days >= 12 && days < 21){
            System.out.println("你的qq等级为：⭐⭐");
        }else if (days >= 21 && days < 32){
            System.out.println("你的qq等级为：⭐⭐⭐");
        }else {
            System.out.println("你的qq等级为：🌙");
        }
    }
}
