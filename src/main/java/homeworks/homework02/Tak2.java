package homeworks.homework02;

import java.util.Scanner;

public class Tak2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1-е целое число:");
        int a = scanner.nextInt();
        System.out.println("Введите второе целое число:");
        int b = scanner.nextInt();
        System.out.println("Сумма двух целых чисел = " + (a + b));
        System.out.println("Разница двух целых чисел = " + (a - b));
        System.out.println("Произведение из двух целых чисел = " + (a * b));
        System.out.println("Среднее из двух целых чисел = " + (a + b) / 2);
        System.out.println("Расстояние двух целых чисел = " + (a - b));
        if (a > b) {
            System.out.println("Максимальное целое число = " + a);
        } else {
            System.out.println("Максимальное целое число = " + b);
        }
        if (a < b) {
            System.out.println("Минимальное целое число = " + a);
        } else {
            System.out.println("Минимальное целое число = " + b);
        }

    }
}

