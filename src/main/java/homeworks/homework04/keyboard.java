package homeworks.homework04;

import java.util.Scanner;

public class keyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите букву");
        char letter = scanner.next().charAt(0);

        char[] alphabet = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                if (i > 0) {
                    System.out.println("Слева стоит буква: " + alphabet[i - 1]);
                } else {
                    System.out.println("Буква  m");
                }
                break;
            }
        }
    }
}