package homeworks.homework02;

import java.util.Scanner;

public class Tak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите степень в градусах Фаренгейта");
        double f = scanner.nextDouble();
        double c;
        c = 5 * (f - 32) / 9;
        System.out.println("градусы Фаренгейта равна по Цельсию =" + c);
    }
}







