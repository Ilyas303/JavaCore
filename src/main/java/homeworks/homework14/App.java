package homeworks.homework14;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>();

        // Ввод продуктов
        while (true) {
            try {
                System.out.println("Введите название продукта или 'END' для окончания: ");
                String productName = scanner.nextLine();
                if (productName.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.println("Введите цену продукта: ");
                double productPrice = scanner.nextDouble();
                scanner.nextLine();

                Product product = new Product();
                product.setName(productName);
                product.setPrice(productPrice);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Ввод покупателей
        while (true) {
            try {
                System.out.println("Введите имя покупателя или 'END' для окончания: ");
                String personName = scanner.nextLine();
                if (personName.equalsIgnoreCase("END")) {
                    break;
                }

                System.out.println("Введите сумму денег в кошельке: ");
                double personMoney = scanner.nextDouble();
                scanner.nextLine(); // Очистка буфера ввода

                Person person = new Person();
                person.setName(personName);
                person.setMoney(personMoney);
                persons.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("Начинаем покупку: ");

        String[] namePersons = new String[persons.size()];
        for (int i = 0; i < namePersons.length; i++) {
            namePersons[i] = persons.get(i).getName();
        }

        String[] nameProducts = new String[products.size()];
        for (int i = 0; i < nameProducts.length; i++) {
            nameProducts[i] = products.get(i).getName();
        }

        Random random = new Random();

        while (true) {
            System.out.println("Для окончания покупки введите 'END': ");
            String end = scanner.nextLine();
            if (end.equalsIgnoreCase("END")) {
                break;
            }

            String name = namePersons[random.nextInt(namePersons.length)];
            String nameProduct = nameProducts[random.nextInt(nameProducts.length)];

            for (Person person : persons) {
                if (person.getName().equalsIgnoreCase(name)) {
                    for (Product product : products) {
                        if (product.getName().equalsIgnoreCase(nameProduct)) {
                            person.addProduct(product);
                        }
                    }
                }
            }
        }

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}