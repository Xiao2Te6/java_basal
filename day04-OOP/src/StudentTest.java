/**
 * 定义类Student 保函三个属性：学号，年级，成绩
 * 创建20个学生对象学号1-20， 年纪何成绩都随机
 * 1.打印出3年纪学生的信息
 * 2.使用冒泡排序并遍历学生信息
 */

public class StudentTest {
    public static void main(String[] args) {

        //声明一个Student数组变量
        Student[] stus = new Student[20];

        Student sTool = new Student();
        //赋值
        sTool.voluation(stus);
        //输出数组信息
        sTool.print(stus);
        System.out.println("_________________________________");
        //年级查询
        sTool.SearchState(stus, 4);
        System.out.println("_________________________________");
        // 按成绩排序
        sTool.sortScore(stus);
        sTool.print(stus);

        System.out.println("_________________________________");
        //匿名变量
        new Student().score = 100;
        //每次new都是新的只能使用一次（快餐）
        System.out.println(new Student().score);

        sTool.show(new Student());



    }
}

class Student {

    int number;     //学号
    int score;      //成绩
    int state;      //年级

    /**
     * 初始化数组并赋值
     * @param arr
     */
    public void voluation(Student arr[]) {
        for (int i = 0; i < arr.length; i++) {
            //初始化数组
            arr[i] = new Student();
            //赋值
            arr[i].number = i + 1;
            arr[i].score = (int) (Math.random() * (100 - 1) + 1);
            arr[i].state = (int) (Math.random() * (6 - 1) + 1);
        }
    }

    /**
     * 输出student类信息
     */
    public void info() {
        System.out.println("学号：" + number + "  年级为：" +
                state + "  年级" + "  成绩为：" + score);
    }

    /**
     * 遍历学生信息
     *
     * @param arr 需要遍历色student数组
     * @return 学生信息
     */

    public void print(Student arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].info();
        }
    }

    /**
     * 年级查询
     *
     * @param arr 需要查询的数组
     * @param sta 需要查询的年级
     */
    public void SearchState(Student arr[], int sta) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].state == sta) {
                arr[i].info();
            }
        }
    }

    /**
     * 按照成绩排序
     * @param arr 需要排序的数组
     */
    public void sortScore(Student arr[]){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < (arr.length - 1 - i); j++){
                if (arr[j].score > arr[j + 1].score){
                    //定义一个空的Student变量存放，交换整个数组元素，不是交换score值
                    Student temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;

                }
            }
        }
    }

    //匿名对象测试
    public void show(Student stu){
        stu.number = 10;
        stu.state = 3;
        System.out.println("number = " + stu.number);
        System.out.println("state = " + stu.state);
    }
}
