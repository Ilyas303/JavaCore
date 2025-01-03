package homeworks.homework05;

import java.util.Arrays;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        telev[] tvArray = new telev[10];
        int maxVolume = 0;

        System.out.println("Введите максимальный уровень громкости: ");
        maxVolume = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            System.out.println("Введите телевизионный бренд: ");
            String model = scanner.next();

            System.out.println("Введите номер канала: ");
            int channelNumber = scanner.nextInt();

            System.out.println("Введите уровень громкости: ");
            int volume = scanner.nextInt();

            System.out.println("Включен ли телевизор? : ");
            boolean isOn = scanner.nextBoolean();

            tvArray[i] = new telev(model, channelNumber, volume, isOn);
        }


        Arrays.sort(tvArray, (a, b) -> a.getChannelNumber() - b.getChannelNumber());

        System.out.println("Телевизоры с приемлемой громкостью:");

        for (telev tv : tvArray) {
            if (tv.isOn() && tv.getVolume() <= maxVolume) {
                System.out.println(tv);
            }
        }
    }
}