package homeworks.homework03;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Television tv1 = new Television("Samsung", 500, 32);
        Television tv2 = new Television("Sony", 400, 55);
        System.out.println(tv1);
        System.out.println(tv2);


        Television tv3 = new Television();
        Random random = new Random();
        tv3.setDiagonal(random.nextInt(10, 75));
        tv3.setprice(random.nextInt(10000, 50000));
        System.out.println(tv3);


    }
}
